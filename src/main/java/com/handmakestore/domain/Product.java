package com.handmakestore.domain;

import com.handmakestore.service.type.ProductStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "HMS_PRODUCT",
        indexes = { @Index(name = "EMAIL_UNIQUE_INDEX", unique = true, columnList = "name,email") }
)
@NoArgsConstructor
@Data
public class Product extends AbstractAuditable<LocalDateTime, Long> {

    private String name;
    private BigDecimal price;
    private Boolean isActive;
    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;
    private Account account;
    private Float rating;
}
