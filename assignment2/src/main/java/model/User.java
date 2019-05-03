package net.codeJava.BestDealsWeb.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	@NotEmpty(message="Please provide an username")
	@Column(name = "name_user")
	private String nameUser;
	@Column
	@NotEmpty(message="Please provide an email")
	private String email;
	@Column(name = "phone_user")
	@NotEmpty(message="Please provide a phone number")
	private String phoneUser;
	@Column
	@NotEmpty(message="Please provide a password")
	private String password;
	@Column(name = "is_online")
	private int isOnline;
	@Column
	@NotEmpty(message="Please provide an address")
	private String address;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String nameUser, String email, String phoneUser,String password, String address, int isOnline) {
		this.nameUser=nameUser;
		this.email=email;
		this.phoneUser=phoneUser;
		this.password=password;
		this.address=address;
		this.isOnline=isOnline;
	}
	
	public User(String nameUser, String email, String phoneUser,String password, String address) {
		this.nameUser=nameUser;
		this.email=email;
		this.phoneUser=phoneUser;
		this.password=password;
		this.address=address;
	}
	public User() {}
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	public String getPhoneUser() {
		return phoneUser;
	}
	public void setPhoneUser(String phoneUser) {
		this.phoneUser = phoneUser;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
