package dataAcces;

public class User {
	private int idUser;
	private String nameUser;
	private String email;
	private String phoneUser;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String nameUser, String email, String phoneUser,String password) {
		this.nameUser=nameUser;
		this.email=email;
		this.phoneUser=phoneUser;
		this.password=password;
	}
	public User() {}
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
