package omerfaruksahin.challenge.controllers;

import lombok.RequiredArgsConstructor;
import omerfaruksahin.challenge.dto.request.SaveEmployeeRequestDto;
import omerfaruksahin.challenge.dto.response.CompanyResponseDto;
import omerfaruksahin.challenge.dto.response.EmployeeResponseDto;
import omerfaruksahin.challenge.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeControllers {
    private final EmployeeService employeeService;

    @PostMapping("saveEmployee")
    public ResponseEntity<EmployeeResponseDto> saveEmployee(@RequestBody SaveEmployeeRequestDto saveEmployeeRequestDto){
        return new ResponseEntity<>(employeeService.saveEmployee(saveEmployeeRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteEmployee")
    public ResponseEntity<Boolean> deleteCompany(@RequestParam long employeeId){
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeId),HttpStatus.OK);
    }

    @GetMapping("/employeeList")
    public ResponseEntity<List<EmployeeResponseDto>> getEmployeeList(){
        return new ResponseEntity<>(employeeService.getEmployee(),HttpStatus.OK);
    }

}
