package uz.pdp.pdptaskspringadvanced11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.pdptaskspringadvanced11.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
