package uz.pdp.pdptaskspringadvanced11.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDto {
    @NotBlank(message = "department name should be not blank")
    private String name;

    @Size(message = "company id min = 1",min = 1)
    private Integer companyId;
}
