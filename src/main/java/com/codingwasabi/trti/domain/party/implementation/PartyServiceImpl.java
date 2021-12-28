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
import com.codingwasabi.trti.domain.party.model.response.ResponseCreatePartyDto;
import com.codingwasabi.trti.domain.party.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;
    private final MemberInPartyRepository memberInPartyRepository;
    private final MemberRepository memberRepository;
    private final CityRepository locationRepository;

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

    private void setPartyCaptain(Member member, Party party) {
        party.setCaptain(member);
    }

    private void setPartyCity(RequestCreatePartyDto requestDto, Party party) {
        Location.parseName(requestDto.getLocation());
        party.setLocation(locationRepository
                .findByCity(Location.parseName(requestDto.getLocation()))
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
