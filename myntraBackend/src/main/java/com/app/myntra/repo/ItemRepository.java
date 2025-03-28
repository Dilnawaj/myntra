package com.app.myntra.repo;

import com.app.myntra.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
