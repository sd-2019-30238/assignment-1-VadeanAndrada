package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.repository.FurnitureRepository;

@Service
@Transactional
public class FurnitureQueryServiceImpl implements FurnitureQueryService {
	@Autowired
	private FurnitureRepository furnitureRepository;
	
	@Override
	public Iterable<Furniture> findAll() {
		return furnitureRepository.findAll();
	}

	@Override
	public Optional<Furniture> find(int id) {
		return furnitureRepository.findById(id);
	}
}
