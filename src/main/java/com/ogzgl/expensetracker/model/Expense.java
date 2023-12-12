package com.ogzgl.expensetracker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="expenses")
@Data
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String expense;

  private String description;

  private BigDecimal amount;
}
