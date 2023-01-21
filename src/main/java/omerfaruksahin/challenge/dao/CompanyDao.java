package omerfaruksahin.challenge.dao;

import omerfaruksahin.challenge.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company,Long> {
}
