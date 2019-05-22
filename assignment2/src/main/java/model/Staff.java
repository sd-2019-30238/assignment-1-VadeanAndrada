package net.codeJava.BestDealsWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="staff")
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	@NotEmpty(message="Please provide an username")
	private String nameStaff;
	@NotEmpty(message="Please provide a password")
	private String password;
	
	public Staff(String nameStaff, String role, String password) {
		this.nameStaff=nameStaff;
		this.password=password;
	}
	public Staff() {}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdStff() {
		return id;
	}
	public void setIdStff(Integer idStff) {
		id= idStff;
	}
	public String getNameStaff() {
		return nameStaff;
	}
	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}


}