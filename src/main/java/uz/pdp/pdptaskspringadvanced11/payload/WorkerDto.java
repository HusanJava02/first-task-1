package uz.pdp.pdptaskspringadvanced11.payload;

import lombok.Data;
import uz.pdp.pdptaskspringadvanced11.entity.Address;
import uz.pdp.pdptaskspringadvanced11.entity.Department;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
public class WorkerDto {
    @NotNull(message = "phone number must not be null")
    private String phoneNumber;

    @NotNull(message = "address id must not null")
    private Integer addressId;

    @NotNull(message = "department id must not null")
    private Integer departmentId;
}
