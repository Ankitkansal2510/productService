package com.example.productservice.InheritenceExamples.Joined;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("joined_user")
public interface UserRepositoryJoined extends JpaRepository<UserJoined,Long> {
    @Override
    <S extends UserJoined> S save(S entity);
}
