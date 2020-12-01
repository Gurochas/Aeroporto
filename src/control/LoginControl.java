package control;

import java.sql.SQLException;

import entity.Login;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import persistence.LoginDAO;

public class LoginControl {
	
	private StringProperty user = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();
	private IntegerProperty permission = new SimpleIntegerProperty();
	
	private Login getLogin() {
		Login l = new Login();
		l.setUser(this.user.get());
		l.setPass(this.pass.get());
		l.setPermission(1);
		return l;
	}
	
	private void setLogin(Login l) {
		if(l == null) {
			this.user.set(l.getUser());
			this.pass.set(l.getPass());
			this.permission.set(1);
		}
	}
	
	public void adicionar() throws SQLException{
		LoginDAO loginDAO = new LoginDAO();
		Login l = getLogin();
		loginDAO.inserirLogin(l);
	}
	
	public StringProperty getUserProperty() {
		return user;
	}
	public void setUserProperty(StringProperty user) {
		this.user = user;
	}
	public StringProperty getPassProperty() {
		return pass;
	}
	public void setPassProperty(StringProperty pass) {
		this.pass = pass;
	}
	public IntegerProperty getPermissionProperty() {
		return permission;
	}
	public void setPermissionProperty(IntegerProperty permission) {
		permission = permission;
	}
	

}
