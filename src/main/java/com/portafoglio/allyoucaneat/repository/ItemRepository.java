package com.portafoglio.allyoucaneat.repository;

import com.portafoglio.allyoucaneat.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
