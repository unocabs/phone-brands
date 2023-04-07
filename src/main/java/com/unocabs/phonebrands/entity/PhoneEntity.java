package com.unocabs.phonebrands.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "rosgian", name = "phones")
public class PhoneEntity {
    @Id
    private UUID phoneId;
    private String phoneName;
    private String brandName;
    private Integer price;

}
