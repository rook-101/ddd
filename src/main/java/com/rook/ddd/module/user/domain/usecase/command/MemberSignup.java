package com.rook.ddd.module.user.domain.usecase.command;

import com.rook.ddd.module.user.domain.usecase.input.MemberSignupInput;
import com.rook.ddd.module.user.domain.usecase.result.MemberSignupResult;

public interface MemberSignup {
    MemberSignupResult execute(MemberSignupInput input);
}
