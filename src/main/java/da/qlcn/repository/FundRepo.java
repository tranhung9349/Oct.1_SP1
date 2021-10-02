package da.qlcn.repository;

import da.qlcn.model.Fund;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FundRepo extends CrudRepository<Fund, Long> {

    @Query(value = "select * from fund where user_id =?1 ", nativeQuery = true)
    Iterable<Fund> findByUserId(long userId);
}
