package com.codingwasabi.trti.util.annonymous;

import com.codingwasabi.trti.util.annonymous.dto.ResponseAnonymousResultDto;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anonymous")
public class AnonymousController {
    private final AnonymousService anonymousService;

    @PostMapping("/survey")
    public ResponseEntity<ResponseAnonymousResultDto> submitSurvey(@RequestBody RequestSurveyDto requestSurveyDto) {
        return ResponseEntity.ok(anonymousService.submitSurvey(requestSurveyDto));
    }
}
