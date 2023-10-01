package com.example.productservice.Service;

import com.example.productservice.DTO.GenericProductDto;
import com.example.productservice.Exception.NotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repository.CategoryRepository;
import com.example.productservice.Repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("DBProductService")
public class DBProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Product product = consstructProductDTO(genericProductDto);
        productRepository.save(product);
        return genericProductDto;

    }

    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        Optional<Product> products = Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Record with UUID : " + id + " Not available in the record")));
        return convertGenericProductDTO(products);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return getAllGenericProductDtos(products);
    }

    @Override
    public GenericProductDto deleteProduct(UUID id) throws NotFoundException {
        GenericProductDto genericProductDto;
        Optional<Product> products = Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Record with UUID : " + id + " Not available in the record, Cannot delete record")));
        genericProductDto = convertGenericProductDTO(products);
        productRepository.deleteById(id);
        return genericProductDto;
    }


    @Override
    public GenericProductDto updateProduct(UUID id, GenericProductDto genericProductDto) {
        Product product = consstructProductDTO(genericProductDto);
        product.setId(id);
        productRepository.save(product);
        return genericProductDto;
    }

    @Override
    public List<String> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<GenericProductDto> getInCategory(String categoryType) {
        List<Category> categories = categoryRepository.findAllByName(categoryType);
        List<UUID> uuid = categories.stream()
                .map(Category::getId)
                .collect(Collectors.toList());
        List<Product> products = productRepository.findAllByCategoryIn(uuid);
        return getAllGenericProductDtos(products);

    }

    private List<GenericProductDto> getAllGenericProductDtos(List<Product> products) {
        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for (Product product : products) {
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setId(product.getId().getLeastSignificantBits());
            Category category = product.getCategory();
            genericProductDto.setCategory(category.getName());
            genericProductDto.setPrice(product.getPrice());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setTitle(product.getTitle());
            genericProductDtoList.add(genericProductDto);
        }

        return genericProductDtoList;
    }

    private Product consstructProductDTO(GenericProductDto genericProductDto) {
        Product product = new Product();
        product.setDescription(genericProductDto.getDescription());
        product.setImage(genericProductDto.getImage());
        product.setPrice(genericProductDto.getPrice());
        product.setTitle(genericProductDto.getTitle());

        Category category = new Category();
        category.setName(genericProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private GenericProductDto convertGenericProductDTO(Optional<Product> products) throws NotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        Category category = products.get().getCategory();
        genericProductDto.setId(products.get().getId().getLeastSignificantBits());
        genericProductDto.setTitle(products.get().getTitle());
        genericProductDto.setCategory(category.getName());
        genericProductDto.setPrice(products.get().getPrice());
        genericProductDto.setImage(products.get().getImage());
        genericProductDto.setDescription(products.get().getDescription());
        genericProductDto.setTitle(products.get().getTitle());
        return genericProductDto;
    }
}
