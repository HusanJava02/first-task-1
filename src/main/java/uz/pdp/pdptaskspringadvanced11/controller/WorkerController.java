package uz.pdp.pdptaskspringadvanced11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pdptaskspringadvanced11.entity.Worker;
import uz.pdp.pdptaskspringadvanced11.payload.ApiResponse;
import uz.pdp.pdptaskspringadvanced11.payload.WorkerDto;
import uz.pdp.pdptaskspringadvanced11.service.WorkerService;

import javax.xml.ws.Response;
import java.util.List;


@RestController
@RequestMapping(value = "/api/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    public ResponseEntity<List<Worker>> getAllWorker(){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.getWorker());
    }


    public ResponseEntity<ApiResponse> addWorker(@RequestBody WorkerDto workerDto){
        ApiResponse apiResponse = workerService.addWorker(workerDto);
        return ResponseEntity.status(apiResponse.getSucces()?HttpStatus.OK:HttpStatus.BAD_REQUEST).body(apiResponse);
    }


    @DeleteMapping
    public HttpEntity<ApiResponse> edit(@PathVariable Integer id){
        ApiResponse delete = workerService.delete(id);
        return ResponseEntity.status(delete.getSucces()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(delete);
    }

}
