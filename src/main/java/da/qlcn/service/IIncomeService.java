package da.qlcn.service;

import da.qlcn.model.Income;

public interface IIncomeService extends IGeneralService <Income> {
    Iterable<Income> findAllByUserId(long userId);
    double totalIncomeValueOfUser(long userId);
}
