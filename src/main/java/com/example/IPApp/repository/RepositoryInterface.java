package com.example.IPApp.repository;

import com.example.IPApp.entity.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryInterface extends CrudRepository<Register, String> {
    Optional<Register> findByName(String name);
}
