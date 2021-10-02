package da.qlcn.controller;

import da.qlcn.model.Fund;
import da.qlcn.model.User;
import da.qlcn.service.IExpenseService;
import da.qlcn.service.IFundService;
import da.qlcn.service.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/fund")
@CrossOrigin("*")
public class FundAPI {
    @Autowired
    private IFundService fundService;
    @Autowired
    private IIncomeService incomeService;
    @Autowired
    private IExpenseService expenseService;


    @PostMapping("")
    ResponseEntity<Fund> newFund(@RequestBody Fund fund) {
        return new ResponseEntity<>(fundService.save(fund), HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    ResponseEntity<Iterable<Fund>> findByUserId(@PathVariable long userId) {
        return new ResponseEntity<>(fundService.findByUserId(userId),HttpStatus.OK);
    }
    @PutMapping("/{fundId}")
    ResponseEntity<Optional<Fund>> updateBalance (@PathVariable long fundId, @RequestBody Fund updated) {
        Optional<Fund> selected = fundService.findById(fundId);
        if(selected.isPresent()) {
            double incomes = incomeService.totalIncomeValueOfUser(selected.get().getUser().getId());
            double expenses = expenseService.totalExpenseOfUser(selected.get().getUser().getId());
            updated.setId(selected.get().getId());
            updated.setUser(selected.get().getUser());
            updated.setCreatedDate(selected.get().getCreatedDate());
            updated.setBalance((selected.get().getBalance() + incomes - expenses));
            fundService.save(updated);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("")
    ResponseEntity<Fund> create () {
        Fund newFund = new Fund();
        newFund.setBalance(0);
        newFund.setCreatedDate(new Date());
        newFund.setUser();

        return new ResponseEntity<>()
    }
}
