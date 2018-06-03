package com.handmakestore.web.REST;

import com.handmakestore.common.VO.account.AccountVO;
import com.handmakestore.common.VO.account.RegistrationVO;
import com.handmakestore.common.VO.account.ResetPasswordVO;
import com.handmakestore.common.mapper.AccountMapper;
import com.handmakestore.domain.Account;
import com.handmakestore.service.AccountService;
import com.handmakestore.service.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(
        value = "/api/v1/account",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
@Slf4j
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountController(
            AccountService accountService,
            AccountMapper accountMapper) {

        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PostMapping
    public ResponseEntity<AccountVO> create(
            @Valid RegistrationVO registrationVO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw ErrorUtil.validationException(bindingResult.getAllErrors());
        }

        Account account = accountService.createAccount(registrationVO);
        return new ResponseEntity<>(accountMapper.toVO(account), HttpStatus.CREATED);
    }

    @PostMapping(value = "/reset/password")
    public ResponseEntity resetPassword(@Valid ResetPasswordVO resetPasswordVO) {

        return null;
    }



}
