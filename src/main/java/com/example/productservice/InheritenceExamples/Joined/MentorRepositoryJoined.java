package com.example.productservice.InheritenceExamples.Joined;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("joined_mr")
public interface MentorRepositoryJoined extends JpaRepository<MentorJoined, Long> {

    @Override
    <S extends MentorJoined> S save(S entity);
}
