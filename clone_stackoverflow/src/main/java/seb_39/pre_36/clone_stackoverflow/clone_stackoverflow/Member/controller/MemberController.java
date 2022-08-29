package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.dto.MemberLoginDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.dto.MemberPostDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.entity.Member;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.mapper.MemberMapper;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.service.MemberService;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.response.SingleResponseDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/members")
@Validated
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto){
        Member member=
                memberService.createUser(mapper.memberPostDtoToMember(memberDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponseDto(member)),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody MemberLoginDto memberLoginDto) throws Exception {
        String email=memberLoginDto.getEmail();
        String password= memberLoginDto.getPassword();

        return new ResponseEntity<>(
                memberService.login(email,password),
                HttpStatus.OK);
    }
}
