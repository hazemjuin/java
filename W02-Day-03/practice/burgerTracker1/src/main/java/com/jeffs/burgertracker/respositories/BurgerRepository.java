package com.jeffs.burgertracker.respositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeffs.burgertracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	//Find all burgers
	List<Burger> findAll();
	//Find an individual burger by ID
	Optional<Burger> findById(Long search);

}
