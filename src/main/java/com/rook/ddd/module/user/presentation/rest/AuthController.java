package com.rook.ddd.module.user.presentation.rest;

import com.rook.ddd.module.user.domain.usecase.command.MemberLogin;
import com.rook.ddd.module.user.domain.usecase.command.MemberLogout;
import com.rook.ddd.module.user.domain.usecase.command.MemberSignup;
import com.rook.ddd.module.user.presentation.dto.MemberLoginRequest;
import com.rook.ddd.module.user.presentation.dto.MemberLoginResponse;
import com.rook.ddd.module.user.presentation.dto.MemberLogoutResponse;
import com.rook.ddd.module.user.presentation.dto.MemberSignupRequest;
import com.rook.ddd.module.user.presentation.dto.MemberSignupResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final MemberLogin memberLogin;
    private final MemberLogout memberLogout;
    private final MemberSignup memberSignup;

    @PostMapping("login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest request) {
        log.info("LoginRequest: " + request.toString());
        memberLogin.execute(request.toInput());
        MemberLoginResponse response = new MemberLoginResponse();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("signup")
    public ResponseEntity<MemberSignupResponse> signup(@RequestBody MemberSignupRequest request) {
        log.info("Signup Request : " + request.toString());
        memberSignup.execute(request.toInput());
        MemberSignupResponse response = new MemberSignupResponse();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("logout")
    public ResponseEntity<MemberLogoutResponse> logout() {
        memberLogout.execute();
        MemberLogoutResponse response = new MemberLogoutResponse();
        return ResponseEntity.ok().body(response);
    }
}
