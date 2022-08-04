package com.rook.ddd.module.user.presentation.dto;

import com.rook.ddd.module.user.domain.usecase.result.MemberSignupResult;
import java.time.ZonedDateTime;
import lombok.Getter;

@Getter
public class MemberSignupResponse {

    private String signupAt;

    private MemberSignupResponse(ZonedDateTime signupAt) {
        this.signupAt = signupAt.toString();
    }

    public static MemberSignupResponse from(MemberSignupResult result) {
        return new MemberSignupResponse(result.getSignupAt());
    }
}
