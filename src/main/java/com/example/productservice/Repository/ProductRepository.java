package com.example.productservice.Repository;

import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    <S extends Product> S save(S entity);

    @Override
    Optional<Product> findById(UUID uuid);

    @Override
    List<Product> findAll();

    @Override
    void deleteById(UUID uuid);


    @Query(value = "select * from Product p where p.category_id in :uuids",
            nativeQuery = true)
    List<Product> findAllByCategoryIn(List<UUID> uuids);

}
