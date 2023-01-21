package omerfaruksahin.challenge.controllers;

import lombok.RequiredArgsConstructor;
import omerfaruksahin.challenge.dto.request.SaveCompanyRequestDto;
import omerfaruksahin.challenge.dto.response.CompanyHaveEmployeeResponseDto;
import omerfaruksahin.challenge.dto.response.CompanyResponseDto;
import omerfaruksahin.challenge.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyControllers {
    private final CompanyService companyService;

    @PostMapping("/saveCompany")
    public ResponseEntity<CompanyResponseDto> saveCompany(@RequestBody SaveCompanyRequestDto saveCompanyRequestDto){
        return new ResponseEntity<>(companyService.saveCompany(saveCompanyRequestDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteCompany")
    public ResponseEntity<Boolean> deleteCompany(@RequestParam long companyId){
        return new ResponseEntity<>(companyService.deleteCompany(companyId),HttpStatus.OK);
    }

    @GetMapping("/companyList")
    public ResponseEntity<List<CompanyResponseDto>> getCompanyList(){
        return new ResponseEntity<>(companyService.getAllCompany(),HttpStatus.OK);
    }

    @PutMapping("/companyUpdate")
    public ResponseEntity<String> updateCompany(@RequestParam Long companyId, @RequestParam String companyName){
        return new ResponseEntity<>(companyService.updateCompany(companyId,companyName),HttpStatus.OK);
    }

    @GetMapping("/ListOfEmployeesInACompany")
    public ResponseEntity<List<CompanyHaveEmployeeResponseDto>> getAllEmployeeInACompany(){
        return new ResponseEntity<>(companyService.getListOfEmployeesInACompany(),HttpStatus.OK);
    }
}
