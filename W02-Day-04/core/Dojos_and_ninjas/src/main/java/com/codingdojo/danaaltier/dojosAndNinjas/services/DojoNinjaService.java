package com.codingdojo.danaaltier.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.danaaltier.dojosAndNinjas.models.Dojo;
import com.codingdojo.danaaltier.dojosAndNinjas.models.Ninja;
import com.codingdojo.danaaltier.dojosAndNinjas.repositories.DojoRepository;
import com.codingdojo.danaaltier.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class DojoNinjaService {

	// Adding the ninja and dojo repositories as  dependencies
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	
	// Constructor
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	
	// Get all ninjas
	public List<Ninja> getAllNinjas() {
		return ninjaRepo.findAll();
	}
	// Get all dojos
	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	
	
	// Find dojo by Id
	public Dojo findDojoById(Long id) {
		Optional<Dojo> aDojo = dojoRepo.findById(id);
		if(aDojo.isPresent()) {
			return aDojo.get();
		} else {
			return null;
		}
	}
	
	
	// Find ninja by Id
	public Ninja findNinja(Long id) {
		Optional<Ninja> aNinja = ninjaRepo.findById(id);
		if(aNinja.isPresent()) {
			return aNinja.get();
		} else {
			return null;
		}
	}
	
	
	// Create ninja
	public void createNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	// Create dojo
	public void createDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
}
