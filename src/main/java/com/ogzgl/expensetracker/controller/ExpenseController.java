package com.ogzgl.expensetracker.controller;

import com.ogzgl.expensetracker.model.Expense;
import com.ogzgl.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class ExpenseController {

  @Autowired
  ExpenseService expenseService;

  @GetMapping("/expenses")
  public ResponseEntity<List<Expense>> get() {
    List<Expense> expenses = expenseService.findALL();
    return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
  }

  @PostMapping("/expenses")
  public ResponseEntity<Expense> save(@RequestBody Expense expense) {
   Expense expenseOne = expenseService.save(expense);

   return new ResponseEntity<Expense>(expenseOne, HttpStatus.OK);
  }

  @GetMapping("/expenses/{id}")
  public ResponseEntity<Expense> get(@PathVariable("id") Long id) {
   Expense expense = expenseService.findById(id);
    return new ResponseEntity<Expense>(expense, HttpStatus.OK);
  }

  @DeleteMapping("/expenses/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") Long id) {
    expenseService.delete(id);
    return new ResponseEntity<String>("Expense is deleted successfully.!", HttpStatus.OK);
  }
}
