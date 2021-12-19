package uz.pdp.pdptaskspringadvanced11.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import uz.pdp.pdptaskspringadvanced11.entity.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class CompanyDto {
    @NotBlank(message = "director name must not be null and empty")
    private String DirectorName;

    @NotBlank(message = "street name must not be null and empty")
    private String streetName;

    private Integer homeNumber;
}
