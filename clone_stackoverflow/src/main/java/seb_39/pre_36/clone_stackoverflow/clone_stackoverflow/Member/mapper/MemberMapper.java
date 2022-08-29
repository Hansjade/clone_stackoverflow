package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.mapper;
import org.mapstruct.Mapper;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.dto.MemberPostDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.dto.MemberResponseDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
