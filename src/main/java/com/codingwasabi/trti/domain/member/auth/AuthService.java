package com.codingwasabi.trti.domain.member.auth;

import com.codingwasabi.trti.config.auth.oauth.kind.OauthInfo;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;

    @Transactional
    public void join(OauthInfo oauthInfo) {
        Member entity = oauthInfo.getEntity();
        memberRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public boolean existsProviderIdAndEmail(String providerId, String email) {
        return memberRepository.existsByOauthIdAndEmail(providerId, email);
    }
}

