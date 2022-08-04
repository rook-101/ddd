package com.rook.ddd.module.user.domain.usecase.result;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberLoginResult {
    private String accessToken;
    private String refreshToken;

    @Builder
    private MemberLoginResult(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
