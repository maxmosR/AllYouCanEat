package com.portaFoglio.AllYouCanEat.repository;

import com.portaFoglio.AllYouCanEat.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
