package da.qlcn.controller;

import da.qlcn.model.Income;
import da.qlcn.service.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/incomes")
@CrossOrigin("*")
public class IncomeAPI {
    @Autowired
    private IIncomeService incomeService;

    @GetMapping("/{userId}")
    ResponseEntity<Iterable<Income>> findAllByUser(@PathVariable long userId) {
        return new ResponseEntity<>(incomeService.findAllByUserId(userId), HttpStatus.OK);
    }
    @GetMapping("")
    ResponseEntity<Optional<Income>> findByID(@RequestParam long incomeId) {
        return new ResponseEntity<>(incomeService.findById(incomeId), HttpStatus.OK);
    }
    @PostMapping("")
    ResponseEntity<Income> save(@RequestBody Income newIncome) {
        incomeService.save(newIncome);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("")
    ResponseEntity<Optional<Income>> edit (@RequestParam long incomeId, @RequestBody Income editedIncome) {
        Optional<Income> selected = incomeService.findById(incomeId);
        if(selected.isPresent()) {
            editedIncome.setId(selected.get().getId());
            editedIncome.setIncomeValue(selected.get().getIncomeValue());
            editedIncome.setCreatedTime(selected.get().getCreatedTime());
            editedIncome.setUser(selected.get().getUser());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("")
    ResponseEntity<Income> delete(@RequestParam long incomeId) {
        incomeService.deleteById(incomeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
