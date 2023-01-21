package omerfaruksahin.challenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private Long employeeId;

    private String firstName;

    private String lastName;

    public Employee(String firstName, String lastName ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JoinColumn(name = "company_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;



}
