package uz.pdp.pdptaskspringadvanced11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdptaskspringadvanced11.entity.Address;
import uz.pdp.pdptaskspringadvanced11.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer> {
}
