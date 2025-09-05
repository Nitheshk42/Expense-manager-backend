package com.example.expense_manager_backend.expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ExpenseResponse {
    private Long Id;
    private String Description;
    private String Category;
    private LocalDate date;
    private String Notes;
    private BigDecimal Amount;

    public ExpenseResponse(Long Id, String Description, String Category, BigDecimal amount, LocalDate date, String Notes) {
        this.Id = Id;
        this.Description = Description;
        this.Category = Category;
        this.date = date;
        this.Notes = Notes;
        this.Amount = amount;
        }

    public ExpenseResponse(Long id, String description, BigDecimal amount, ExpenseCategory category, LocalDate date, String notes) {

    }

    public Long getId() {return Id; }
    public String getDescription() { return Description; }
    public String getCategory() { return Category; }
    public LocalDate getDate() { return date; }
    public String getNotes() { return Notes; }
    public BigDecimal getAmount() { return Amount; }
}

