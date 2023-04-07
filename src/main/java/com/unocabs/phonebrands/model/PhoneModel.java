package com.unocabs.phonebrands.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneModel {
    private String phoneName;
    private String brandName;
    private Integer price;
}
