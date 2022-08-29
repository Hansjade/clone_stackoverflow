package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.dto.MemberPostDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.dto.MemberResponseDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.entity.Member;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-29T14:27:59+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( memberPostDto.getEmail() );
        member.setDisplayName( memberPostDto.getDisplayName() );
        member.setPassword( memberPostDto.getPassword() );

        return member;
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto.MemberResponseDtoBuilder memberResponseDto = MemberResponseDto.builder();

        memberResponseDto.memberId( member.getMemberId() );
        memberResponseDto.email( member.getEmail() );
        memberResponseDto.displayName( member.getDisplayName() );
        memberResponseDto.password( member.getPassword() );
        memberResponseDto.memberStatus( member.getMemberStatus() );

        return memberResponseDto.build();
    }
}
