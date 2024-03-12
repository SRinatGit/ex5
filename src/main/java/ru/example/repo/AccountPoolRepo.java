package ru.example.repo;


import ru.example.model.AccountPool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountPoolRepo extends CrudRepository<AccountPool, Long> {
   AccountPool findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(String var1, String var2, String var3, String var4, String var5);
}
