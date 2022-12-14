package com.rook.ddd.module.user.domain.usecase.result;

import com.rook.ddd.module.user.domain.entity.Member;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSignupResult {
    private ZonedDateTime signupAt;
    private String username;
    private String name;

    @Builder(access = AccessLevel.PRIVATE)
    private MemberSignupResult(ZonedDateTime signupAt, String username, String name) {
        this.signupAt = signupAt;
        this.username = username;
        this.name = name;
    }

    public static MemberSignupResult from(Member member) {
        return MemberSignupResult.builder()
                                 .signupAt(ZonedDateTime.now())
                                 .username(member.getUsername())
                                 .name(member.getName())
                                 .build();
    }
}
