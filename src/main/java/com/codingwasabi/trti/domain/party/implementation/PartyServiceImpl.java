package com.codingwasabi.trti.domain.party.implementation;

import com.codingwasabi.trti.domain.city.model.Location;
import com.codingwasabi.trti.domain.city.repository.CityRepository;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.repository.MemberRepository;
import com.codingwasabi.trti.domain.memberInParty.model.MemberInParty;
import com.codingwasabi.trti.domain.memberInParty.repository.MemberInPartyRepository;
import com.codingwasabi.trti.domain.party.PartyService;
import com.codingwasabi.trti.domain.party.model.Party;
import com.codingwasabi.trti.domain.party.model.request.RequestCreatePartyDto;
import com.codingwasabi.trti.domain.party.model.response.*;
import com.codingwasabi.trti.domain.party.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;
    private final MemberInPartyRepository memberInPartyRepository;
    private final MemberRepository memberRepository;
    private final CityRepository cityRepository;

    @Override
    @Transactional
    public ResponseCreatePartyDto create(Member member, RequestCreatePartyDto requestDto) {
        Party party = requestDto.getEntityFrom();

        setPartyCaptain(member, party);
        setPartyCity(requestDto, party);
        partyRepository.save(party);

        putMemberInParty(party, requestDto.getMembers());

        return ResponseCreatePartyDto.from(party);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponsePartyInfoDto getInfo(Member member, Long id) {
        // 현재 로그인한 회원이 조회 권한이 있는지 확인 하는 검증 로직 구현해야함

        // Error code 추가 해야함
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 id의 Party는 존재하지 않습니다."));
        ResponsePartyInfoDto responseDto = ResponsePartyInfoDto.from(party);
        responseDto.setParticipantsCount(memberInPartyRepository.countByParty(party));

        return responseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponsePartyMemberListDto getMemberList(Member member, Long id) {
        // 현재 로그인한 회원이 조회 권한이 있는지 확인 하는 검증 로직 구현해야함

        // Error code 추가 해야함
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 id의 Party는 존재하지 않습니다."));

        List<MemberInParty> memberList = memberInPartyRepository.findAllByParty(party);

        return ResponsePartyMemberListDto.of(
                memberList.size(),
                memberList.stream()
                        .map((memberInParty) -> ResponseMemberDto.from(memberInParty))
                        .collect(Collectors.toList())
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ResponsePartyResultDto getResult(Member member, Long id) {
        // Error code 추가 해야함
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 id의 Party는 존재하지 않습니다."));

        return ResponsePartyResultDto.from(party.getResult());
    }

    private void setPartyCaptain(Member member, Party party) {
        party.setCaptain(member);
    }

    private void setPartyCity(RequestCreatePartyDto requestDto, Party party) {
        Location.parseName(requestDto.getLocation());
        party.setCity(cityRepository
                .findByLocation(Location.parseName(requestDto.getLocation()))
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 도시의 정보가 존재하지 않습니다.")));
    }

    private void putMemberInParty(Party party, List<Long> memberIdList) {
        memberIdList.stream()
                .map((id) -> memberRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 회원의 id가 입력되었습니다.")))
                .forEach((member) -> memberInPartyRepository.save(MemberInParty.of(party, member)));
    }
}
