package com.shakirali.rental.repository;

import com.shakirali.rental.entity.RentDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentDepositRepository extends JpaRepository<RentDeposit, Long> {
}
