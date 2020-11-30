package entity;

public class Login {
	
	private String user;
	private String pass;
	private int Permission;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getPermission() {
		return Permission;
	}
	public void setPermission(int Permission) {
		this.Permission = Permission;
	}
	
	@Override
	public String toString() {
		return "Login [user=" + user + ", pass=" + pass + ", Permission=" + Permission + "]";
	}

}
