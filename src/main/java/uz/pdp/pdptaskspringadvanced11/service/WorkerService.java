package uz.pdp.pdptaskspringadvanced11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pdptaskspringadvanced11.entity.Address;
import uz.pdp.pdptaskspringadvanced11.entity.Department;
import uz.pdp.pdptaskspringadvanced11.entity.Worker;
import uz.pdp.pdptaskspringadvanced11.payload.ApiResponse;
import uz.pdp.pdptaskspringadvanced11.payload.WorkerDto;
import uz.pdp.pdptaskspringadvanced11.repository.AddressRepository;
import uz.pdp.pdptaskspringadvanced11.repository.DepartmentRepository;
import uz.pdp.pdptaskspringadvanced11.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Worker> getWorker(){
        return workerRepository.findAll();
    }

    public ApiResponse addWorker(WorkerDto workerDto){
        Integer addressId = workerDto.getAddressId();
        Integer departmentId = workerDto.getDepartmentId();

        Worker worker = new Worker();
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            worker.setDepartment(department);
        }else return new ApiResponse(false,"department not found");

        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            worker.setAddress(address);
        }else return new ApiResponse(false,"address not found");

        workerRepository.save(worker);
        return new ApiResponse(true,"successfully saved");
    }

    public ApiResponse delete(Integer id){
        if (workerRepository.existsById(id)){
            workerRepository.deleteById(id);
            return new ApiResponse(true,"success");
        }else return new ApiResponse(false,"not found");
    }
}
