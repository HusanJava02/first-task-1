package uz.pdp.pdptaskspringadvanced11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pdptaskspringadvanced11.controller.CompanyController;
import uz.pdp.pdptaskspringadvanced11.entity.Address;
import uz.pdp.pdptaskspringadvanced11.entity.Company;
import uz.pdp.pdptaskspringadvanced11.payload.ApiResponse;
import uz.pdp.pdptaskspringadvanced11.payload.CompanyDto;
import uz.pdp.pdptaskspringadvanced11.repository.AddressRepository;
import uz.pdp.pdptaskspringadvanced11.repository.CompanyRepository;

import javax.validation.Valid;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AddressRepository addressRepository;


    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public ApiResponse addCompanyService(CompanyDto companyDto) {
        Company company = new Company();
        Address address = new Address(null,companyDto.getStreetName(),companyDto.getHomeNumber());
        Address savedAddress = addressRepository.save(address);
        company.setAddress(savedAddress);
        company.setDirectorName(companyDto.getDirectorName());
        companyRepository.save(company);
        return new ApiResponse(true,"successfully saved");
    }

    public ApiResponse deleteCompany(Integer id) {
        if (companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            addressRepository.deleteById(id);
            return new ApiResponse(true,"succesffully deleted");
        }else return new ApiResponse(false,"not found comoanny with given id");
    }
}
