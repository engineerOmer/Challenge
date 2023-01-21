package omerfaruksahin.challenge.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "company_id")
    private Long companyId;

    private String companyName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "company")
    @JsonManagedReference
    private List<Employee> employees;

}
