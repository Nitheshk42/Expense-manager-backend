package com.example.expense_manager_backend.expense;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }
    public List<Expense> findAll() {
        return repo.findAll();
    }
    public Expense findById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public Expense create(@Valid ExpenseRequest req) {
        Expense expense = new Expense();
        expense.setDescription(req.getDescription());
        expense.setAmount(req.getAmount());
        expense.setCategory(req.getCategory());
        expense.setDate(req.getDate());
        expense.setNotes(req.getNotes());

        return repo.save(expense);
    }
    public ExpenseResponse update(Long id, @Valid ExpenseRequest req) {
        Expense existing = findById(id);
        existing.setDescription(req.getDescription());
        existing.setAmount(req.getAmount());
        existing.setCategory(req.getCategory());
        existing.setDate(req.getDate());
        existing.setNotes(req.getNotes());

     Expense saved = repo.save(existing);

     return new ExpenseResponse(
             saved.getId(),
             saved.getDescription(),
             saved.getAmount(),
             saved.getCategory(),
             saved.getDate(),
             saved.getNotes()
     );
    }
    public void delete(Long id){
        repo.deleteById(id);
    }

}
