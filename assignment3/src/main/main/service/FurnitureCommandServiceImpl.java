package net.codeJava.BestDealsWeb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.repository.FurnitureRepository;

@Service
@Transactional
public class FurnitureCommandServiceImpl implements FurnitureCommandService {
	@Autowired
	private FurnitureRepository furnitureRepository;
	
	@Override
	public void delete(int id) {
		furnitureRepository.deleteById(id);		
	}

	@Override
	public void add(Furniture f) {
		furnitureRepository.save(f);
		
	}

}
