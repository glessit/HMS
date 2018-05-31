package com.handmakestore.web.REST;

import com.handmakestore.service.ErrorUtil;
import com.handmakestore.web.VO.RegistrationVO;
import com.handmakestore.web.VO.ResetPasswordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        value = "/api/v1/account",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
@Slf4j
public class AccountController {

    @PostMapping
    public ResponseEntity create(
            @Valid RegistrationVO registrationVO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw ErrorUtil.validationException(bindingResult.getAllErrors());
        }

        return null;
    }

    @PostMapping(value = "/reset/password")
    public ResponseEntity resetPassword(@Valid ResetPasswordVO resetPasswordVO) {

        return null;
    }



}
