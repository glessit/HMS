package com.handmakestore.service;

import com.handmakestore.web.VO.RegistrationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void createAccount(RegistrationVO registrationVO) {

        LOGGER.debug(
                "Creating new account, email: {}, name",
                registrationVO.getEmail(),
                registrationVO.getName());





    }

}
