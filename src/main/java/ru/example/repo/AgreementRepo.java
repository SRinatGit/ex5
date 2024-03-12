package ru.example.repo;


import ru.example.model.Agreement;
import ru.example.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgreementRepo extends CrudRepository<Agreement, Long> {
   Optional<Agreement> findById(Long var1);

   Optional<Agreement> findByProductAndNumber(Product var1, String var2);
}
