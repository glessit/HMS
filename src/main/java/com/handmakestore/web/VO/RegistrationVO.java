package com.handmakestore.web.VO;

import com.handmakestore.service.type.CustomerType;
import lombok.*;

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
