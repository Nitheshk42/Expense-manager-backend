package com.example.expense_manager_backend.expense;

import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ExpenseRepository extends JpaRepository<Expense, Long> { // — This is a Spring Data JPA repository. By extending JpaRepository<T, ID> you automatically get a bunch of CRUD data-access methods implemented for you:
                                                                          // 	save(), findById(), findAll(), deleteById(), count(), paging, sorting, etc.
                                                                            //	The generics <Expense, Long> tie this repo to the Expense entity with primary key type Long.

    @Query("select coalesce(sum(e.amount), 0) from Expense e")           //— custom JPQL query: compute the sum of all amount values. coalesce(..., 0) ensures that if there are no rows the query returns 0 instead of null.
    BigDecimal sumAll();                                                //— method signature for the custom query. Spring Data wires the JPQL query to this method.

}
