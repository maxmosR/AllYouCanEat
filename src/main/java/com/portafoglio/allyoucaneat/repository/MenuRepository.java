package com.portafoglio.allyoucaneat.repository;

import com.portafoglio.allyoucaneat.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
