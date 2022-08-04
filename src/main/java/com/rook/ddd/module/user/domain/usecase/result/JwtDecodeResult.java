package com.rook.ddd.module.user.domain.usecase.result;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JwtDecodeResult {
    private Long memberId;

    @Builder
    private JwtDecodeResult(Long memberId) {
        this.memberId = memberId;
    }
}
