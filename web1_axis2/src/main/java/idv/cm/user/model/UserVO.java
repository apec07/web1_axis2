package idv.cm.user.model;

public class UserVO implements java.io.Serializable {
	
	private Integer no;
	private String name;
	private String password;
	private String email;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserVO [no=" + no + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
	
	

}
