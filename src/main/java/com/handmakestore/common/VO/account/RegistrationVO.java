package com.handmakestore.common.VO.account;

import com.handmakestore.service.type.CustomerType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RegistrationVO {

    @NotNull
    private CustomerType customerType;
    @Email
    @NotEmpty
    String email;
    @NotEmpty
    private String name;
}
