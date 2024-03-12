package ru.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tpp_ref_account_type")
public class AccountType {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_type_seq")
   @SequenceGenerator(name = "account_type_seq", sequenceName = "seq_id", allocationSize = 1)
   @Column( name = "internal_id", nullable = false)
   private long id;
   @Column(name = "value", nullable = false, unique = true)
   private String value;

   public void setValue(String value) {
      this.value = value;
   }
}
