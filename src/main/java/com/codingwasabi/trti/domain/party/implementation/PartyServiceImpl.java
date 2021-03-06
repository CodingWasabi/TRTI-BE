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
import com.codingwasabi.trti.domain.result.model.Result;
import com.codingwasabi.trti.domain.result.repository.ResultRepository;
import com.codingwasabi.trti.util.survey.SurveyHandler;
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
    private final ResultRepository resultRepository;

    @Override
    @Transactional
    public ResponseCreatePartyDto create(Member member, RequestCreatePartyDto requestDto) {
        Party party = requestDto.getEntityFrom();

        setPartyCaptain(member, party);
        setPartyCity(requestDto, party);
        partyRepository.save(party);

        putMemberInParty(party, requestDto.getMembers());

        List<Member> memberList = getMemberList(memberInPartyRepository.findAllByParty(party));

        Result result = SurveyHandler.proceedForParty(memberList);
        party.setResult(result);

        resultRepository.save(result);
        partyRepository.save(party);

        return ResponseCreatePartyDto.from(party);
    }

    private List<Member> getMemberList(List<MemberInParty> allByParty) {
        List<Member> memberList = allByParty.stream()
                .map((memberInParty) -> memberInParty.getMember())
                .collect(Collectors.toList());
        return memberList;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponsePartyInfoDto getInfo(Member member, Long id) {
        // ?????? ???????????? ????????? ?????? ????????? ????????? ?????? ?????? ?????? ?????? ???????????????

        // Error code ?????? ?????????
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] ?????? id??? Party??? ???????????? ????????????."));
        ResponsePartyInfoDto responseDto = ResponsePartyInfoDto.from(party);
        responseDto.setParticipantsCount(memberInPartyRepository.countByParty(party));

        return responseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponsePartyMemberListDto getMemberList(Member member, Long id) {
        // ?????? ???????????? ????????? ?????? ????????? ????????? ?????? ?????? ?????? ?????? ???????????????

        // Error code ?????? ?????????
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] ?????? id??? Party??? ???????????? ????????????."));

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
        // Error code ?????? ?????????
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] ?????? id??? Party??? ???????????? ????????????."));

        return ResponsePartyResultDto.from(party.getResult());
    }

    private void setPartyCaptain(Member member, Party party) {
        party.setCaptain(member);
    }

    private void setPartyCity(RequestCreatePartyDto requestDto, Party party) {
        System.out.println(requestDto.getLocation());
        System.out.println(Location.parseName(requestDto.getLocation()));
        party.setCity(cityRepository
                .findByLocation(Location.parseName(requestDto.getLocation()))
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] ????????? ????????? ???????????? ????????????.")));
    }

    private void putMemberInParty(Party party, List<Long> memberIdList) {
        memberIdList.stream()
                .map((id) -> memberRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("[ERROR] ???????????? ?????? ????????? id??? ?????????????????????.")))
                .forEach((member) -> memberInPartyRepository.save(MemberInParty.of(party, member)));
    }
}
