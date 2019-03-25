package dataAcces;

public class Staff {
	private int idStff;
	private String nameStaff;
	private String role;
	private String password;
	
	public Staff(String nameStaff, String role, String pasword) {
		this.role=role;
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
	public int getIdStff() {
		return idStff;
	}
	public void setIdStff(int idStff) {
		this.idStff = idStff;
	}
	public String getNameStaff() {
		return nameStaff;
	}
	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
