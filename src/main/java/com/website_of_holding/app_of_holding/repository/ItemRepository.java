package com.website_of_holding.app_of_holding.repository;

import com.website_of_holding.app_of_holding.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findItemByName(String name);
    Optional<Item> findItemById(Long id);
}
