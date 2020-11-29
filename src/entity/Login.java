package entity;

public class Login {
	
	private String user;
	private String pass;
	private int permisson;
	
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
	public int getPermisson() {
		return permisson;
	}
	public void setPermisson(int permisson) {
		this.permisson = permisson;
	}
	
	@Override
	public String toString() {
		return "Login [user=" + user + ", pass=" + pass + ", permisson=" + permisson + "]";
	}

}
