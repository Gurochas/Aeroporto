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
	
	
	
	public ObservableList<Aviao> getListaProperty() {
		return lista;
	}

	public void setListaProperty(ObservableList<Aviao> lista) {
		this.lista = lista;
	}

	public IntegerProperty getCodigoProperty() {
		return codigo;
	}





	public void setCodigoProperty(IntegerProperty codigo) {
		this.codigo = codigo;
	}





	public StringProperty getEmpresaProperty() {
		return empresa;
	}





	public void setEmpresaProperty(StringProperty empresa) {
		this.empresa = empresa;
	}





	public StringProperty getModeloProperty() {
		return modelo;
	}





	public void setModeloProperty(StringProperty modelo) {
		this.modelo = modelo;
	}





	public IntegerProperty getQtd_lugaresProperty() {
		return qtd_lugares;
	}





	public void setQtd_lugaresProperty(IntegerProperty qtd_lugares) {
		this.qtd_lugares = qtd_lugares;
	}





	public DoubleProperty getPrecoProperty() {
		return preco;
	}





	public void setPrecoProperty(DoubleProperty preco) {
		this.preco = preco;
	} 
	
	
	
	}    

