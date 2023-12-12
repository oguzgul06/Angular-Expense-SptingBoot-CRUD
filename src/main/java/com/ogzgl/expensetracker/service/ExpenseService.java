package com.ogzgl.expensetracker.service;

import com.ogzgl.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {

  List<Expense> findALL();

  Expense save(Expense expense);

  Expense findById(Long id);

  void delete(Long id);
}
