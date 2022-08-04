package com.rook.ddd.module.user.presentation.dto;

import com.rook.ddd.module.user.domain.usecase.input.MemberLoginInput;
import lombok.Getter;

@Getter
public class MemberLoginRequest {
    private String username;
    private String password;

    public MemberLoginInput toInput() {
        return MemberLoginInput.builder().username(this.username).password(this.password).build();
    }
}
