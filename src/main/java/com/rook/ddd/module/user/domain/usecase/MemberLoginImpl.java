package com.rook.ddd.module.user.domain.usecase;

import com.rook.ddd.module.user.domain.entity.Member;
import com.rook.ddd.module.user.domain.exception.MemberNotFoundException;
import com.rook.ddd.module.user.domain.exception.WrongPasswordException;
import com.rook.ddd.module.user.domain.repository.MemberRepository;
import com.rook.ddd.module.user.domain.usecase.command.JwtTokenManager;
import com.rook.ddd.module.user.domain.usecase.command.MemberLogin;
import com.rook.ddd.module.user.domain.usecase.input.MemberLoginInput;
import com.rook.ddd.module.user.domain.usecase.result.MemberLoginResult;
import com.rook.ddd.module.user.domain.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberLoginImpl implements MemberLogin {
    private final MemberRepository memberRepository;
    private final JwtTokenManager jwtTokenManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberLoginResult execute(MemberLoginInput input) {
        Member member = memberRepository.findByUsername(input.getUsername());
        if (member == null) {
            throw new MemberNotFoundException();
        }
        if (!passwordEncoder.matches(input.getPassword(), member.getEncodedPassword())) {
            throw new WrongPasswordException();
        }
        String accessToken = jwtTokenManager.createAccessToken();
        String refreshToken = jwtTokenManager.createRefreshToken();
        return MemberLoginResult.builder()
                                .accessToken(accessToken)
                                .refreshToken(refreshToken)
                                .build();
    }
}
