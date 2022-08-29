package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.dto;

import lombok.Builder;
import lombok.Getter;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.Member.entity.Member;

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
