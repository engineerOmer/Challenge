package omerfaruksahin.challenge.converter;

import omerfaruksahin.challenge.dto.request.SaveEmployeeRequestDto;
import omerfaruksahin.challenge.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public Employee saveEmployeeRequestDtoToEmployee(SaveEmployeeRequestDto saveEmployeeRequestDto){
        return new Employee(
                saveEmployeeRequestDto.getFirstName(),
                saveEmployeeRequestDto.getLastName());
    }

}
