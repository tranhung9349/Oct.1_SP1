package da.qlcn.service.impl;

import da.qlcn.model.Expense;
import da.qlcn.repository.ExpenseRepo;
import da.qlcn.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseServiceImpl implements IExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;


    @Override
    public Iterable<Expense> findAll() {
        return expenseRepo.findAll();
    }

    @Override
    public Optional<Expense> findById(long id) {
        return expenseRepo.findById(id);
    }

    @Override
    public Expense save(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public void deleteById(long id) {
        expenseRepo.deleteById(id);
    }

    @Override
    public Iterable<Expense> findAllByUserId(long userId) {
        return expenseRepo.findAllByUserId(userId);
    }

    @Override
    public double totalExpenseOfUser(long userId) {
        return expenseRepo.totalExpenseOfUser(userId);
    }
}
