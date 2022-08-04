package com.rook.ddd.module.user.domain.util;

public interface PasswordEncoder {
    String encode(String password);

    boolean matches(String rawPassword, String encodedPassword);
}
