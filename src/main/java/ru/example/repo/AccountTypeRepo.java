package ru.example.repo;


import ru.example.model.AccountType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountTypeRepo extends CrudRepository<AccountType, Long> {
   Optional<AccountType> findById(Long var1);

   Optional<AccountType> findByValue(String var1);
}
