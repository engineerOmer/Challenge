package omerfaruksahin.challenge.service;

import lombok.RequiredArgsConstructor;
import omerfaruksahin.challenge.dao.CompanyDao;
import omerfaruksahin.challenge.dto.request.SaveCompanyRequestDto;
import omerfaruksahin.challenge.dto.response.CompanyHaveEmployeeResponseDto;
import omerfaruksahin.challenge.dto.response.CompanyResponseDto;
import omerfaruksahin.challenge.dto.response.EmployeeResponseDto;
import omerfaruksahin.challenge.model.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyDao companyDao;
    private final ModelMapper modelMapper;

    public CompanyResponseDto saveCompany(SaveCompanyRequestDto saveCompanyRequestDto){
        Company company = modelMapper.map(saveCompanyRequestDto,Company.class);
        companyDao.save(company);
        return modelMapper.map(company,CompanyResponseDto.class);
    }

    public boolean deleteCompany(Long companyId) {
        Company company = companyDao.findById(companyId).orElseThrow();
        companyDao.delete(company);
        return !companyDao.existsById(companyId);
    }

    public List<CompanyResponseDto> getAllCompany() {
        return companyDao.findAll().stream().map(item ->modelMapper.map(item,CompanyResponseDto.class)).toList();
    }

    public String updateCompany(Long companyId, String companyName) {
        Company company = companyDao.findById(companyId).orElseThrow();
        company.setCompanyName(companyName);
        companyDao.save(company);
        String message = "Sirket ismi basariyla guncellendi";
        return message + "\n " +companyName;
    }

    public List<CompanyHaveEmployeeResponseDto> getListOfEmployeesInACompany(){
        return companyDao.findAll().stream().map(
                company -> CompanyHaveEmployeeResponseDto.builder()
                        .companyName(company.getCompanyName())
                        .employeeResponseDtos(company.getEmployees().stream().map(item ->modelMapper.map(item, EmployeeResponseDto.class)).toList()
                        ).build()
        ).toList();
    }

    public Company findById(Long id){
        return companyDao.findById(id).orElseThrow();
    }
}
