package com.example.productservice.InheritenceExamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_mr")
public interface MentorRepositoryTPC extends JpaRepository<MentorTPC, Long> {

    @Override
    <S extends MentorTPC> S save(S entity);

}
