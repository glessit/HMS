package com.handmakestore.common.VO.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ResetPasswordVO {

    @Data
    @NoArgsConstructor
    public static class ResetPasswordResponse {
        private String result;
        private LocalDateTime dateTime = LocalDateTime.now();
    }

    @Email
    private String email;
    private ResetPasswordResponse response;
}
