package da.qlcn.service;

import da.qlcn.model.Expense;


public interface IExpenseService extends IGeneralService<Expense>{
    Iterable<Expense> findAllByUserId(long userId);
    double totalExpenseOfUser(long userId);
}
