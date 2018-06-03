package com.handmakestore.service.repository;

import com.handmakestore.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
    Boolean existsByNameAndEmail(@NotEmpty String name, @Email @NotEmpty String email);
}
