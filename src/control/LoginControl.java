package control;

import java.sql.SQLException;

import entity.Cliente;
import entity.Login;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import persistence.LoginDAO;

public class LoginControl {
	
	private static Cliente cliente;
	private static Login login;
	
	private StringProperty user = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();
	private IntegerProperty permission = new SimpleIntegerProperty();
	
	public Login getLogin() {
		Login l = new Login();
		l.setUser(this.user.get());
		l.setPass(this.pass.get());
		l.setPermission(this.permission.get());
		return l;
	}
	
	public void setLogin(Login l) {
		if(l != null) {
			this.user.set(l.getUser());
			this.pass.set(l.getPass());
			this.permission.set(l.getPermission());
		}
	}
	
	public void buscar () throws SQLException {
		LoginDAO loginDAO = new LoginDAO();
		setLogin(loginDAO.buscarLogin(getLogin()));
	}
	
	public void atualizar() throws SQLException {
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.atualizarLogin(getLogin());
		LoginControl.setLoginG(getLogin());
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
		this.permission = permission;
	}
	
	public static Cliente getCliente() {
		return LoginControl.cliente;
	}
	public static void setCliente(Cliente cliente) {
		LoginControl.cliente = cliente;
	}
	
	public static Login getLoginG() {
		return LoginControl.login;
	}
	public static void setLoginG(Login login) {
		LoginControl.login = login;
	}

}
