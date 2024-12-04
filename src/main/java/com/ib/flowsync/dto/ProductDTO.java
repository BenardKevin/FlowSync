package com.ib.flowsync.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Float price;
    private Float vat;
    private Integer categoryId;
    private Integer supplierId;
}
