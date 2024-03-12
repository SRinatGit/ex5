package ru.example.repo;


import ru.example.model.ProductRegister;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRegisterRepo extends CrudRepository<ProductRegister, Long> {
   List<ProductRegister> findByProductId(long var1);
}
