package com.example.productservice.Service;

import com.example.productservice.DTO.GenericProductDto;
import com.example.productservice.Exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(UUID id)  throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(UUID id) throws NotFoundException;

    GenericProductDto updateProduct(UUID id, GenericProductDto product);

    List<String> getAllCategory();

    List<GenericProductDto> getInCategory(String category);


}
