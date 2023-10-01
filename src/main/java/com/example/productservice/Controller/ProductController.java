package com.example.productservice.Controller;

import com.example.productservice.DTO.GenericProductDto;
import com.example.productservice.Exception.NotFoundException;
import com.example.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {


    //    @Autowired
    // field injection
    private ProductService productService;
    // ....;
    // ...;


    // constructor injection
//    @Autowired
    public ProductController(@Qualifier("DBProductService") ProductService productService) {
        this.productService = productService;
    }
//

    // setter injection
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") UUID id) throws NotFoundException {
            return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto product) {
        return new ResponseEntity<>(productService.createProduct(product),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<GenericProductDto> updateProductById(@PathVariable("id") UUID id, @RequestBody GenericProductDto product) {
        return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategory() {
        return new ResponseEntity<>(productService.getAllCategory(),HttpStatus.OK);

    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<GenericProductDto>> getInCategory(@PathVariable("category") String category) {
        return new ResponseEntity<>(productService.getInCategory(category),HttpStatus.OK);
    }
}
