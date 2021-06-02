package com.telusko.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthoritiesRepo extends JpaRepository<Authorities, AuthorityPKId> {

}
