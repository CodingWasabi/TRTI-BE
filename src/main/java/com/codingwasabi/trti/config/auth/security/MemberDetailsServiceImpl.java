package com.codingwasabi.trti.config.auth.security;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Error code 추가 예정
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));

        return new MemberAdaptor(member);
    }
}
