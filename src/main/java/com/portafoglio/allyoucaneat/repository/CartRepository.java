package com.portafoglio.allyoucaneat.repository;

import com.portafoglio.allyoucaneat.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
