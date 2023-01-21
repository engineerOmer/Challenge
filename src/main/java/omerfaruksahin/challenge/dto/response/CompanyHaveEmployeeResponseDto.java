package omerfaruksahin.challenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyHaveEmployeeResponseDto {

    private String companyName;
    private List<EmployeeResponseDto> employeeResponseDtos;
}
