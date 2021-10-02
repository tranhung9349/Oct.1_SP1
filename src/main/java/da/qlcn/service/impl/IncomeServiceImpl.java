package da.qlcn.service.impl;

import da.qlcn.model.Income;
import da.qlcn.repository.IncomeRepo;
import da.qlcn.service.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncomeServiceImpl implements IIncomeService {
    @Autowired
    private IncomeRepo incomeRepo;


    @Override
    public Iterable<Income> findAll() {
        return incomeRepo.findAll();
    }

    @Override
    public Optional<Income> findById(long id) {
        return incomeRepo.findById(id);
    }

    @Override
    public Income save(Income income) {
        return incomeRepo.save(income);
    }

    @Override
    public void deleteById(long id) {
        incomeRepo.deleteById(id);
    }

    @Override
    public Iterable<Income> findAllByUserId(long userId) {
        return incomeRepo.findAllByUserId(userId);
    }

    @Override
    public double totalIncomeValueOfUser(long userId) {
        return incomeRepo.totalIncomeValueOfUser(userId);
    }
}
