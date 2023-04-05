package com.example.productmng.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestForm {
    private Long id;
    @NotBlank
    private String productName;

    @Min(500000)
    private int productPrice;
    @Min(1)
    private int productQuantity;
    @NotBlank
    private String productColor;
    private String productDetail;
    @NotBlank
    private String categoryName;
    @NotBlank
    private String brandName;
}
