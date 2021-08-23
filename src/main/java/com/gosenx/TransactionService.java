package com.gosenx;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {
  List<Transaction> transactions = new CopyOnWriteArrayList<>(Arrays.asList(new Transaction(223, "Prego no pão"),
      new Transaction(50, "Crédito"), new Transaction(100, "Dei a Miranda")));

  public List<Transaction> findAll() {
    return transactions;
  }

  public Transaction create(double amount, String reference) {
    Transaction transaction = new Transaction(amount, reference);
    transactions.add(transaction);
    return transaction;
  }
}
