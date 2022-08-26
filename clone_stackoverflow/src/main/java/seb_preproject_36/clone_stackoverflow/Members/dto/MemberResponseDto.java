package seb_preproject_36.clone_stackoverflow.Members.dto;

import lombok.Builder;
import lombok.Getter;
import seb_preproject_36.clone_stackoverflow.Members.Member;

@Builder
@Getter
public class MemberResponseDto {
    private long memberId;
    private String email;
    private String displayName;
    private String password;
    private Member.MemberStatus memberStatus;

    public String getMemberStatus(){
        return memberStatus.getStatus();
    }
}
