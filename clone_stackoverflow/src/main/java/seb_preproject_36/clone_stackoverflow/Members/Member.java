package seb_preproject_36.clone_stackoverflow.Members;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable=false, updatable=false, unique=true)
    private String email;

    @Column(length=100, nullable = false, unique = true)
    private String displayName;

    @Column(nullable = false)
    private String password;

    public Member(String email, String displayName, String password) {
        this.email = email;
        this.displayName = displayName;
        this.password = password;
    }

    @Enumerated(value= EnumType.STRING)
    @Column(length=20, nullable=false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @Column(nullable = false)
    private LocalDateTime createdAt=LocalDateTime.now();

    @Column(nullable = false, name="LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt=LocalDateTime.now();

    //TODO: onetomany로 question/answer list와 연결




    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
