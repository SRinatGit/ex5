package ru.example.repo;


import ru.example.model.ProductClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductClassRepo extends CrudRepository<ProductClass, Long> {
   Optional<ProductClass> findByGlobalCode(String var1);
}
