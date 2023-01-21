package omerfaruksahin.challenge.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveEmployeeRequestDto {

    private String firstName;

    private String lastName;

    private Long companyId;
}
