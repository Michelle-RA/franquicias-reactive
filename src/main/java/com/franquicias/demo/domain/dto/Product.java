package com.franquicias.demo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    @NotBlank(message = "It should not be blank")
    @NotEmpty(message = "It should not be empty")
    @NotNull(message = "It should not be null")
    private String name;

    private int stock;
    @NotNull(message = "It should not be null")
    private Long branchId ;
}
