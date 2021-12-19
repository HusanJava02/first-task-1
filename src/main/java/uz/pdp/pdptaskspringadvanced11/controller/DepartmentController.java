package uz.pdp.pdptaskspringadvanced11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdptaskspringadvanced11.entity.Department;
import uz.pdp.pdptaskspringadvanced11.payload.ApiResponse;
import uz.pdp.pdptaskspringadvanced11.payload.DepartmentDto;
import uz.pdp.pdptaskspringadvanced11.service.DepartmentService;

import javax.xml.ws.Response;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public HttpEntity<List<Department>> getDepartments(){
        return ResponseEntity.ok(departmentService.getDepartments());
    }

    @PostMapping
    public HttpEntity<ApiResponse> addDepartment(@RequestBody DepartmentDto departmentDto){
        ApiResponse apiResponse = departmentService.addDepartment(departmentDto);
        return ResponseEntity.status(apiResponse.getSucces()? HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @PutMapping
    public HttpEntity<ApiResponse> edit(@RequestBody DepartmentDto departmentDto,@PathVariable Integer id){
        ApiResponse apiResponse = departmentService.editDepartment(departmentDto, id);
        return ResponseEntity.status(apiResponse.getSucces()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse);
    }
    @DeleteMapping
    public HttpEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse apiResponse = departmentService.deleteDepartment(id);
        return ResponseEntity.status(apiResponse.getSucces()?200:404).body(apiResponse);
    }
}
