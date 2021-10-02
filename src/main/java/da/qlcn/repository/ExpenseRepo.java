package da.qlcn.repository;

import da.qlcn.model.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends PagingAndSortingRepository<Expense, Long> {

    @Query(value = "select * from expense where user_id =?1 ", nativeQuery = true)
    Iterable<Expense> findAllByUserId(long userId);

    @Query(value = "select sum(expense_amount) from expense where user_id =?1 ",nativeQuery = true)
    double totalExpenseOfUser(long userId);
}
