package da.qlcn.controller;

import da.qlcn.model.Expense;
import da.qlcn.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*")
public class ExpenseAPI {
    @Autowired
    private IExpenseService expenseService;

    @GetMapping("/{userId}")
    ResponseEntity<Iterable<Expense>> findAllByUser(@PathVariable long userId) {
        return new ResponseEntity<>(expenseService.findAllByUserId(userId), HttpStatus.OK);
    }
    @GetMapping("")
    ResponseEntity<Optional<Expense>> findById(@RequestParam long expenseId) {
        return new ResponseEntity<>(expenseService.findById(expenseId), HttpStatus.OK);
    }
    @PostMapping("")
    ResponseEntity<Expense> save(@RequestBody Expense newExpense) {
        expenseService.save(newExpense);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("")
    ResponseEntity<Optional<Expense>> edit (@RequestParam long expenseId, @RequestBody Expense edited) {
        Optional<Expense> selected = expenseService.findById(expenseId);
        if(selected.isPresent()) {
            edited.setId(selected.get().getId());
            edited.setCreatedTime(selected.get().getCreatedTime());
            edited.setExpenseAmount(selected.get().getExpenseAmount());
            edited.setUser(selected.get().getUser());
            expenseService.save(edited);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("")
    ResponseEntity<Expense> delete(@RequestParam long expenseId) {
        expenseService.deleteById(expenseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
