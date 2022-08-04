package com.rook.ddd.module.user.presentation.dto;

import com.rook.ddd.module.user.domain.usecase.input.MemberSignupInput;
import lombok.Getter;

@Getter
public class MemberSignupRequest {
    private String username;
    private String name;
    private String password;

    public MemberSignupInput toInput() {
        return MemberSignupInput.builder()
                                .name(name)
                                .username(username)
                                .password(password)
                                .build();
    }
}
