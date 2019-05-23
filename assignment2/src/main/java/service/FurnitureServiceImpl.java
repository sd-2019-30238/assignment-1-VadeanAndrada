package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.repository.FurnitureRepository;


@Service("furnitureService")
@Transactional
public class FurnitureServiceImpl implements FurnitureService {

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

	@Override
	public void delete(int id) {
		furnitureRepository.deleteById(id);		
	}

	@Override
	public void add(Furniture f) {
		furnitureRepository.save(f);
		
	}

}
