package com.example.productservice.Service;

import com.example.productservice.DTO.GenericProductDto;
import com.example.productservice.Exception.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id)  throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

    GenericProductDto updateProduct(long id, GenericProductDto product);
}
