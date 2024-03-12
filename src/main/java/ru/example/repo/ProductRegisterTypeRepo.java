package ru.example.repo;

import ru.example.model.ProductClass;
import ru.example.model.ProductRegisterType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRegisterTypeRepo extends CrudRepository<ProductRegisterType, Long> {
   List<ProductRegisterType> findAllByValue(String var1);

   ProductRegisterType findByRegisterTypeName(String var1);

   List<ProductRegisterType> findAllByProductClass(ProductClass var1);
}
