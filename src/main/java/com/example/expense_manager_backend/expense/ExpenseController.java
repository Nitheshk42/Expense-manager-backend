package com.example.expense_manager_backend.expense;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin
public class ExpenseController {
    private final ExpenseService service;
    private final ExpenseRepository repo;

    public ExpenseController(ExpenseService service, ExpenseRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping
    public List<ExpenseResponse> getAll() {
        return service.findAll().stream()
                .map(e -> new ExpenseResponse(
                        e.getId(), e.getDescription(), e.getAmount(),
                        e.getCategory(), e.getDate(), e.getNotes()))
                .toList();
    }
    @GetMapping("/{id}")
    public ExpenseResponse getOne(@PathVariable Long id) {
        var e = service.findById(id);
        return new ExpenseResponse(
                e.getId(), e.getDescription(), e.getAmount(),
                e.getCategory(), e.getDate(), e.getNotes());
    }
    @PostMapping
    public ResponseEntity<ExpenseResponse> create(@Valid @RequestBody ExpenseRequest req) {
        Expense e = service.create(req);
        ExpenseResponse response = (new ExpenseResponse(
                e.getId(), e.getDescription(), e.getAmount(),
                e.getCategory(), e.getDate(), e.getNotes()));

        return ResponseEntity.ok(response);
    }
@PutMapping("/{id}")
    public ExpenseResponse update(@PathVariable Long id, @Valid @RequestBody ExpenseRequest req) {
        var e = service.update(id, req);
        return new ExpenseResponse(
                e.getId(), e.getDescription(), e.getCategory(),
                e.getAmount(), e.getDate(), e.getNotes());
}
@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
}
@GetMapping("/summary/total")
    public BigDecimal total() {
        return repo.sumAll();
   }
}
