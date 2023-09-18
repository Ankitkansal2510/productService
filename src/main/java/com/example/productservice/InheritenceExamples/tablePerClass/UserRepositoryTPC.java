package com.example.productservice.InheritenceExamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_user")
public interface UserRepositoryTPC extends JpaRepository<UserTPC,Long> {
    @Override
    <S extends UserTPC> S save(S entity);
}
