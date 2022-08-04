package com.rook.ddd.module.user.domain.usecase.command;

public interface JwtTokenManager {
    String createAccessToken();
    String createRefreshToken();
}
