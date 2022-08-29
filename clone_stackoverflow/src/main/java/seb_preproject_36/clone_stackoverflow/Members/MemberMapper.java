package seb_preproject_36.clone_stackoverflow.Members;
import org.mapstruct.Mapper;
import seb_preproject_36.clone_stackoverflow.Members.dto.MemberPostDto;
import seb_preproject_36.clone_stackoverflow.Members.dto.MemberResponseDto;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
