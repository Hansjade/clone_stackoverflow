package seb_preproject_36.clone_stackoverflow.Members;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import seb_preproject_36.clone_stackoverflow.Members.dto.MemberLoginDto;
import seb_preproject_36.clone_stackoverflow.Members.dto.MemberPostDto;
import seb_preproject_36.clone_stackoverflow.response.SingleResponseDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/members")
@Validated
@Slf4j
@CrossOrigin("*")
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
