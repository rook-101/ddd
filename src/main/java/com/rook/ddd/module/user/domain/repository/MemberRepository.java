package com.rook.ddd.module.user.domain.repository;

import com.rook.ddd.module.user.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
    Boolean existsByUsername(String username);
}
