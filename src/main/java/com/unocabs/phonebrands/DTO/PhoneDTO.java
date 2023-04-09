package com.unocabs.phonebrands.DTO;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class PhoneDTO {
    private UUID phoneId;
    private String phoneName;
    private String brandName;
    private Integer price;
}
