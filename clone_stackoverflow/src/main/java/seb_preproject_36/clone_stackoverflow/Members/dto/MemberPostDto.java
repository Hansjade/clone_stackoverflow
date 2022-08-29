package seb_preproject_36.clone_stackoverflow.Members.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class MemberPostDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank(message= "displayname은 공백이 아니어야 합니다")
    private String displayName;

    @NotBlank(message = "password는 공백이 아니어야 합니다")
    private String password;
}
