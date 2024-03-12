package ru.example.services;


import ru.example.model.Account;
import ru.example.model.AccountPool;
import ru.example.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
   private final AccountRepo accountRepo;

   @Autowired
   public AccountService(AccountRepo accountRepo) {
      this.accountRepo = accountRepo;
   }

   public Account findFirstByAccountPool(AccountPool accountPool) {
      return this.accountRepo.findFirstByAccountPool(accountPool);
   }
}
