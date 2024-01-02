package com.portafoglio.allyoucaneat.repository;

import com.portafoglio.allyoucaneat.model.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressRepository extends JpaRepository<OrderAddress, Long> {
}
