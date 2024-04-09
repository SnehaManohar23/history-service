package edu.iu.snemanoh.historyservice.controller;

import edu.iu.snemanoh.historyservice.model.PimesRecord;
import edu.iu.snemanoh.historyservice.repository.PrimesHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesHistoryController {
    private final PrimesHistoryRepository primesHistoryRepository;
    public PrimesHistoryController(
            PrimesHistoryRepository primesHistoryRepository){
        this.primesHistoryRepository=primesHistoryRepository;
    }
    @GetMapping("/{customer}")
    public List<PimesRecord> findAll(@PathVariable String customer){
        return primesHistoryRepository.findAllByCustomer(customer);
    }

}
