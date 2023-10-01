package com.example.productservice.Repository;

import com.example.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,String> {
    @Override
    List<Category> findAll();

    List<Category> findAllByName(String s);
}
