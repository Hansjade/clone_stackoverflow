package seb_preproject_36.clone_stackoverflow.Members;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createUser(Member member){
        verifyExistsEmail(member.getEmail());

        return memberRepository.save(member);
    }

    private void verifyExistsEmail(String email){
        Optional<Member> member= memberRepository.findByEmail(email);
        if(member.isPresent())
            try {
                throw new Exception("Email is already exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public boolean login(String email, String password) throws Exception {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent()){
            if(password.equals(member.get().getPassword()))
                return true;
            else
                throw new Exception("Password is not correct");
        }
        else{
            throw new Exception("Email is not correct");
        }
    }
}
