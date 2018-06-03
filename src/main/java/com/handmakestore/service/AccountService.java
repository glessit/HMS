package com.handmakestore.service;

import com.handmakestore.common.VO.account.RegistrationVO;
import com.handmakestore.domain.Account;
import com.handmakestore.service.exception.HMSUserAlreadyExist;
import com.handmakestore.service.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Account createAccount(RegistrationVO registrationVO) {

        LOGGER.debug(
                "Creating new account, email: {}, name",
                registrationVO.getEmail(),
                registrationVO.getName());

        // new Account should be unique by email and username
        if (accountRepository.existsByNameAndEmail(registrationVO.getName(), registrationVO.getEmail())) {

            LOGGER.info("");
            throw new HMSUserAlreadyExist(); 
        }

        Account account = new Account();
        account.setStatus(Boolean.TRUE);

        Account result = accountRepository.save(account);
        LOGGER.info("Account with name: {}, email: {} has been created", result.getName(), result.getEmail());

        return result;
    }

}
