package com.handmakestore.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDateTime;

//@Entity
//@Table(
//    name = "HMS_ACCOUNT",
//    indexes = { @Index (name = "EMAIL_UNIQUE_INDEX", unique = true, columnList = "name,email") }
//)
@NoArgsConstructor
@Data
public class Account {//extends AbstractAuditable<LocalDateTime, Long> {

    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false, length = 128)
    private String email;
    @Column
    private Boolean status;
    @Column(nullable = false)
    private String password;
}
