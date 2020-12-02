package control;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Aviao;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.AviaoDAO;

public class AviaoControl {

	private IntegerProperty codigo = new SimpleIntegerProperty();
	private StringProperty empresa = new SimpleStringProperty();
	private StringProperty modelo = new SimpleStringProperty();
	private IntegerProperty qtd_lugares = new SimpleIntegerProperty();
	private DoubleProperty preco = new SimpleDoubleProperty();
	
	
	
private ObservableList<Aviao> lista = FXCollections.observableArrayList();


	public Aviao getAviao() {
		Aviao a = new Aviao();
		a.setCodigo(this.codigo.get());
		a.setEmpresa(this.empresa.get());
		a.setModelo(this.modelo.get());
		a.setQtd_lugares(this.qtd_lugares.get());
		a.setPreco(this.preco.get());
		return a;
	}

	public void setAviao(Aviao a) {
		if (a != null) {
			this.codigo.set(a.getCodigo());
			this.empresa.set(a.getEmpresa());
			this.modelo.set(a.getModelo());
			this.qtd_lugares.set(a.getQtd_lugares());
			this.preco.set(a.getPreco());
		}
		
	}
	
	
	public void adicionar () throws SQLException {
		AviaoDAO aviaoDao = new AviaoDAO();
		Aviao a = getAviao();
		aviaoDao.inserirAviao(a);
	}

	public Aviao buscarAviao (Aviao a) throws SQLException{
		AviaoDAO aviaoDAO = new AviaoDAO();
		a = aviaoDAO.buscarAviao(a);
		return a;
	}

	
	public ObservableList<Aviao> buscarAvioes() throws SQLException{
		AviaoDAO aviaoDAO = new AviaoDAO();
		lista.clear();
		lista.addAll(aviaoDAO.buscarAvioes());
		return lista;
	}
	
	
	
	public ObservableList<Aviao> getLista() {
		return lista;
	}

	public void setLista(ObservableList<Aviao> lista) {
		this.lista = lista;
	}

	public IntegerProperty getCodigo() {
		return codigo;
	}





	public void setCodigo(IntegerProperty codigo) {
		this.codigo = codigo;
	}





	public StringProperty getEmpresa() {
		return empresa;
	}





	public void setEmpresa(StringProperty empresa) {
		this.empresa = empresa;
	}





	public StringProperty getModelo() {
		return modelo;
	}





	public void setModelo(StringProperty modelo) {
		this.modelo = modelo;
	}





	public IntegerProperty getQtd_lugares() {
		return qtd_lugares;
	}





	public void setQtd_lugares(IntegerProperty qtd_lugares) {
		this.qtd_lugares = qtd_lugares;
	}





	public DoubleProperty getPreco() {
		return preco;
	}





	public void setPreco(DoubleProperty preco) {
		this.preco = preco;
	} 
	
	
	
	}    

