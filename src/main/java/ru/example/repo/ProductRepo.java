package ru.example.repo;

import ru.example.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
   Optional<Product> findById(long var1);

   Optional<Product> findByNumber(String var1);

   void delete(Product var1);
}
