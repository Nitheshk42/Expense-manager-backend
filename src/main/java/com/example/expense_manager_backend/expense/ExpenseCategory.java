package com.example.expense_manager_backend.expense;

public enum ExpenseCategory {      //— a Java enum: a type-safe set of predefined constants. Using enums for categories avoids magic strings and typos in code.
	                              //	Because we used @Enumerated(EnumType.STRING) in the entity, the DB will store "FOOD", "TRANSPORT", etc. If you added a new enum later, old rows still map correctly (unlike ordinal storage).
    FOOD, TRANSPORT, BILLS, ENTERTAINMENT, HEALTH, SHOPPING, OTHER
}
