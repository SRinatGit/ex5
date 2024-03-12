package ru.example.repo;


import ru.example.model.Account;
import ru.example.model.AccountPool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
   Account findFirstByAccountPool(AccountPool var1);
}
