package com.example.expense_manager_backend.expense;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


                           //— marks this class as a JPA entity. JPA will map this class to a database table (by default table name = expense or Expense depending on the JPA provider). This is what makes the class persistable.
public class ExpenseRequest {             //— normal Java class that will represent a row in the expense table.
                 //— primary key type Long is common for DB keys.
    @NotBlank                       //— validation rule (from Jakarta Bean Validation). @NotBlank means the string must be non-null and contain at least one non-whitespace character. Useful to ensure user provides a meaningful description.
    private String description;     //— the text description of the expense.

    @NotNull                        // prevents null amounts; @DecimalMin("0.0") prevents negative amounts (money shouldn’t be negative here). amount uses BigDecimal which is the correct type for currency to avoid floating-point rounding errors.
    @DecimalMin("0.0")
    private BigDecimal amount;      // precise numeric value for money.
                               //— maps Java enum values to the database as strings (e.g., "FOOD", "TRANSPORT"). This is safer than storing ordinal numbers because it remains stable if you reorder enum entries.
    @NotNull
    private  ExpenseCategory category;

    @NotNull                        //— ensures every expense has a date.
    private LocalDate date;         //— stores date without time (maps to SQL DATE). Good for daily expenses.

    private String notes;           //optional extra text.

    //Getters and setters

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public ExpenseCategory getCategory() { return category; }
    public void setCategory(ExpenseCategory category) { this.category = category; }

    public LocalDate getDate() { return date; }
    public void setDate (LocalDate date) { this.date = date; }

    public String getNotes() { return notes; }
    public void setNotes (String notes) { this.notes = notes; }

}
