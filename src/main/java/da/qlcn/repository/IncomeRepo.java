package da.qlcn.repository;

import da.qlcn.model.Income;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepo extends PagingAndSortingRepository<Income, Long> {
    @Query(value = "select * from income where user_id =?1 ", nativeQuery = true)
    Iterable<Income> findAllByUserId(long userId);

    @Query(value = "select sum(income_value) from income where user_id=?1 ", nativeQuery = true)
    double totalIncomeValueOfUser(long userId);

}
