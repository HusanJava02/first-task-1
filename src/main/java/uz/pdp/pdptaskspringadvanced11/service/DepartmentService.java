package uz.pdp.pdptaskspringadvanced11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pdptaskspringadvanced11.entity.Company;
import uz.pdp.pdptaskspringadvanced11.entity.Department;
import uz.pdp.pdptaskspringadvanced11.payload.ApiResponse;
import uz.pdp.pdptaskspringadvanced11.payload.DepartmentDto;
import uz.pdp.pdptaskspringadvanced11.repository.CompanyRepository;
import uz.pdp.pdptaskspringadvanced11.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public ApiResponse addDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            department.setCompany(company);
            return new ApiResponse(true, "saved successfully");
        } else return new ApiResponse(false, "company not found with given id");
    }

    public ApiResponse editDepartment(DepartmentDto departmentDto, Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(department.getName());
            Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
            if (!optionalCompany.isPresent()) {
                return new ApiResponse(false,"not found company");
            }
            Company company = optionalCompany.get();
            department.setCompany(company);
            return new ApiResponse(true,"successfully edited");
        }else return new ApiResponse(false,"not found department with given id");
    }

    public ApiResponse deleteDepartment(Integer departmentId){
        if (departmentRepository.existsById(departmentId)){
            departmentRepository.deleteById(departmentId);
            return new ApiResponse(true,"successfully deleted");
        }else return new ApiResponse(false,"not found");
    }
}
