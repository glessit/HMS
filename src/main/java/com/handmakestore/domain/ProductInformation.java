package com.handmakestore.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(
        name = "HMS_PRODUCT_INFORMATION",
        indexes = { @Index(name = "EMAIL_UNIQUE_INDEX", unique = true, columnList = "name,email") }
)
@NoArgsConstructor
@Data
public class ProductInformation extends AbstractAuditable<LocalDateTime, Long> {

    private String overview;
    private String overviewPicture;
    private Set<String> pictures;
}
