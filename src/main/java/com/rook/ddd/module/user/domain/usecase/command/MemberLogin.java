package com.rook.ddd.module.user.domain.usecase.command;

import com.rook.ddd.module.user.domain.usecase.input.MemberLoginInput;
import com.rook.ddd.module.user.domain.usecase.result.MemberLoginResult;

public interface MemberLogin {
    MemberLoginResult execute(MemberLoginInput input);
}
