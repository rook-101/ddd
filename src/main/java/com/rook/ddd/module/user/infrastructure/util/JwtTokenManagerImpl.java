package com.rook.ddd.module.user.infrastructure.util;

import com.rook.ddd.module.user.domain.entity.Member;
import com.rook.ddd.module.user.domain.util.JwtTokenManager;
import com.rook.ddd.module.user.domain.usecase.result.JwtDecodeResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenManagerImpl implements JwtTokenManager {

    private final String SECRET_KEY = "wefaxzcvfefaefaefaefaeease";
    private static final int ACCESS_TOKEN_DURATION = 300;
    private static final int REFRESH_TOKEN_DURATION = 7200;

    @Override
    public String createAccessToken(Member member) {
        Date expireDate = Date.from(Instant.now().plusSeconds(ACCESS_TOKEN_DURATION));
        return createJwtToken(member, expireDate);
    }

    @Override
    public String createRefreshToken(Member member) {
        Date expireDate = Date.from(Instant.now().plusSeconds(REFRESH_TOKEN_DURATION));
        return createJwtToken(member, expireDate);
    }

    @Override
    public JwtDecodeResult decodeJwtToken(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(SECRET_KEY)
                            .parseClaimsJwt(token)
                            .getBody();
        Long memberId = Long.parseLong(claims.getSubject());
        return JwtDecodeResult.builder()
                              .memberId(memberId)
                              .build();
    }

    private String createJwtToken(Member member, Date expireDate) {
        return Jwts.builder()
                   .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                   .setSubject(member.getId().toString())
                   .setIssuedAt(new Date())
                   .setExpiration(expireDate)
                   .compact();
    }
}
