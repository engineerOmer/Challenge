package com.omerfaruksahin.Challenge.repository;

import com.omerfaruksahin.Challenge.model.Campaign;
import com.omerfaruksahin.Challenge.model.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeLogRepository extends JpaRepository<ChangeLog,Integer> {
    List<ChangeLog> findByCampaign(Campaign campaign);
}
