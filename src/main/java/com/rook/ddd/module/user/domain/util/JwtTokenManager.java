package com.rook.ddd.module.user.domain.util;

import com.rook.ddd.module.user.domain.entity.Member;
import com.rook.ddd.module.user.domain.usecase.result.JwtDecodeResult;

public interface JwtTokenManager {
    String createAccessToken(Member member);
    String createRefreshToken(Member member);
    JwtDecodeResult decodeJwtToken(String token);
}
