package net.codeJava.BestDealsWeb;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.codeJava.BestDealsWeb.model.Staff;
import net.codeJava.BestDealsWeb.repository.StaffRepository;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StaffRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private StaffRepository staffRepsitory;
	
	@Test
	public void whenFindByNameStaff_thenReturnStaff() {
		Staff staff= new Staff("AnaPopescu", "parola");
		
		entityManager.persist(staff);
		entityManager.flush();
		
		Staff foundStaff=staffRepsitory.findUserByNameStaff(staff.getNameStaff()).get();
		
		assertThat(foundStaff.getNameStaff().equals(staff.getNameStaff()));
		
	}
	

}
