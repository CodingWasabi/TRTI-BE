package com.codingwasabi.trti.config.auth.jwt;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {
    private final UserDetailsService securityService;
    private final Long validTimeMilli;
    private String key;

    public JwtProvider(@Value("${jwt.validTime}") Long validTime,
                       @Value("${jwt.secret}") String key,
                       UserDetailsService securityService) {
        this.securityService = securityService;
        this.validTimeMilli = validTime * 1000L;
        this.key = key;
    }

    @PostConstruct
    protected void init() {
        key = Base64.getEncoder().encodeToString(key.getBytes());
    }

    /**
     * JWT 생성
     * @param email
     * @return
     */
    public String create(String email, String providerId) {
        Date now = new Date();
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("providerId", providerId);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validTimeMilli))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }


    /**
     * JWT 유효성 검증 (key 검증 및 만료일자 검증)
     * @param jwtToken
     * @return
     */
    public boolean validate(String jwtToken) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwtToken);

            return claimsJws.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * JWT 에서 회원정보 추출
     * @param jwtToken
     * @return
     */
    public Authentication getAuthentication(String jwtToken) {
        MemberAdaptor memberAdaptor = (MemberAdaptor) securityService
                .loadUserByUsername(getEmailFromToken(jwtToken));

        return new UsernamePasswordAuthenticationToken(memberAdaptor, null,
                memberAdaptor.getAuthorities());
    }

    /**
     * JWT 에서 email 추출
     * @param jwtToken
     * @return
     */
    private String getEmailFromToken(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtToken)
                .getBody()
                .getSubject();
    }

    /**
     * request 의 header 로부터 토큰 추출
     * @param request
     * @return
     */
    public String resolve(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    public String setInvalidJwtMessage(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken);
            return "Server 내부에서 발생한 인증 오류입니다. Concorn 개발팀에 문의하세요.";
        } catch (UnsupportedJwtException | MalformedJwtException e) {
            return "지원하지 않는 구성의 JWT 입니다. 버전 혹은 암호화 방식을 확인하세요.";
        } catch (ExpiredJwtException e) {
            return "만료된 JWT 입니다.";
        } catch (SignatureException e) {
            return "서버에서 허용하지 않은 key 로 생성한 JWT 입니다. 접근 거부";
        } catch (IllegalArgumentException e) {
            return "JWT 가 공백 형태입니다. 헤더를 확인해주세요.";
        }
    }
}
