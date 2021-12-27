package com.codingwasabi.trti.domain.member.auth;

import com.codingwasabi.trti.config.auth.jwt.JwtProvider;
import com.codingwasabi.trti.config.auth.oauth.kind.OauthInfo;
import com.codingwasabi.trti.config.auth.oauth.service.OauthService;
import com.codingwasabi.trti.domain.member.model.response.ResponseJwtWithOauthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.codingwasabi.trti.domain.member.MemberAPI.OAUTH_JOIN;
import static com.codingwasabi.trti.domain.member.MemberAPI.OAUTH_LOGIN;

@RestController
@RequiredArgsConstructor
public class OauthController {
    private final String RESPONSE_MAP_KEY_TYPE = "type";
    private final String RESPONSE_MAP_KET_JWT = "token";

    private final OauthService oauthService;
    private final AuthService authService;
    private final JwtProvider jwtProvider;

    @PostMapping("/auth/{provider}")
    @Transactional
    public ResponseEntity<ResponseJwtWithOauthDto> createJwtWithOauth(
            @RequestBody Map<String, Object> requestMap,
            @PathVariable("provider") String provider) {

        Map<String, String> responseMap = new HashMap<>();
        OauthInfo oauthInfo = oauthService.filtrateOauth(provider.toLowerCase(), requestMap);

        if (isProviderIdAndEmailExists(oauthInfo.getProviderId(), oauthInfo.getEmail())) {
            putMapType(responseMap, RESPONSE_MAP_KEY_TYPE, OAUTH_LOGIN.getMessage());
        }

        if (!isProviderIdAndEmailExists(oauthInfo.getProviderId(), oauthInfo.getEmail())) {
            putMapType(responseMap, RESPONSE_MAP_KEY_TYPE, OAUTH_JOIN.getMessage());
            authService.join(oauthInfo);
        }

        putMapType(responseMap,
                RESPONSE_MAP_KET_JWT,
                jwtProvider.create(oauthInfo.getEmail(), oauthInfo.getProviderId()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseJwtWithOauthDto.of(
                        responseMap.get(RESPONSE_MAP_KEY_TYPE),
                        responseMap.get(RESPONSE_MAP_KET_JWT)));
    }

    private void putMapType(Map<String, String> responseMap,String key, String value) {
        responseMap.put(key, value);
    }

    private boolean isProviderIdAndEmailExists(String providerId, String email) {
        return authService.existsProviderIdAndEmail(providerId, email);
    }
}
