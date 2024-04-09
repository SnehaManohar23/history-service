package edu.iu.snemanoh.historyservice.repository;
import org.springframework.data.repository.CrudRepository;
import edu.iu.snemanoh.historyservice.model.PimesRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface PrimesHistoryRepository extends CrudRepository<PimesRecord, Integer> {
    List<PimesRecord> findAllByCustomer(String customer);
}
