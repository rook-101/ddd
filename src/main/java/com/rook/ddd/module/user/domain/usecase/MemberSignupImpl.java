package com.rook.ddd.module.user.domain.usecase;

import com.rook.ddd.module.user.domain.entity.Member;
import com.rook.ddd.module.user.domain.repository.MemberRepository;
import com.rook.ddd.module.user.domain.usecase.command.MemberSignup;
import com.rook.ddd.module.user.domain.usecase.input.MemberSignupInput;
import com.rook.ddd.module.user.domain.usecase.result.MemberSignupResult;
import com.rook.ddd.module.user.domain.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSignupImpl implements MemberSignup {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberSignupResult execute(MemberSignupInput input) {
        Member member = Member.builder()
                              .username(input.getUsername())
                              .name(input.getName())
                              .encodedPassword(passwordEncoder.encode(input.getPassword()))
                              .build();
        memberRepository.save(member);
        MemberSignupResult result = MemberSignupResult.from(member);
        return result;
    }
}
