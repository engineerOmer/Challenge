package omerfaruksahin.challenge.service;

import lombok.RequiredArgsConstructor;
import omerfaruksahin.challenge.converter.EmployeeConverter;
import omerfaruksahin.challenge.dao.CompanyDao;
import omerfaruksahin.challenge.dao.EmployeeDao;
import omerfaruksahin.challenge.dto.request.SaveEmployeeRequestDto;
import omerfaruksahin.challenge.dto.response.EmployeeResponseDto;
import omerfaruksahin.challenge.model.Company;
import omerfaruksahin.challenge.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;
    private final ModelMapper modelMapper;
    private final EmployeeConverter employeeConverter;
    private final CompanyService companyService;

    public EmployeeResponseDto saveEmployee(SaveEmployeeRequestDto saveEmployeeRequestDto) {
        Employee employee = employeeConverter.saveEmployeeRequestDtoToEmployee(saveEmployeeRequestDto);
        Company company = companyService.findById(saveEmployeeRequestDto.getCompanyId());
        employee.setCompany(company);
        employeeDao.save(employee);
        return modelMapper.map(employee,EmployeeResponseDto.class);
    }

    public boolean deleteEmployee(long employeeId) {
        Employee employee = employeeDao.findById(employeeId).orElseThrow();
        employeeDao.delete(employee);
        return !employeeDao.existsById(employeeId);
    }

    public List<EmployeeResponseDto> getEmployee() {
        return employeeDao.findAll().stream().map(item->modelMapper.map(item,EmployeeResponseDto.class)).toList();
    }
}
