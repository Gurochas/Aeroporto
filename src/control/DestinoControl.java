package control;

import java.sql.SQLException;

import entity.Destino;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.DestinoDAO;

public class DestinoControl {
	
	private IntegerProperty codigo = new SimpleIntegerProperty();
	private StringProperty destino = new SimpleStringProperty();
	private DoubleProperty preco = new SimpleDoubleProperty();
	
	private ObservableList<Destino> lista = FXCollections.observableArrayList();
	
	public Destino getDestino() {
		Destino d = new Destino();
		d.setCodigo(this.codigo.get());
		d.setDestino(this.destino.get());
		d.setPreco(this.preco.get());
		return d;
	}
	
	public void setDestino(Destino d) {
		if (d != null) {
			this.codigo.set(d.getCodigo());
			this.destino.set(d.getDestino());
			this.preco.set(d.getPreco());
		}
	}
	
	public void adicionar() throws SQLException {
		DestinoDAO destinoDAO = new DestinoDAO();
		Destino d = getDestino();
		destinoDAO.inserirDestino(d);
	}
	
	public Destino buscarDestino (Destino d) throws SQLException {
		DestinoDAO destinoDAO = new DestinoDAO();
		d = destinoDAO.buscarDestino(d);
		return d;
	}
	
	public ObservableList<Destino> buscarDestinos() throws SQLException{
		DestinoDAO destinoDAO = new DestinoDAO();
		lista.clear();
		lista.addAll(destinoDAO.buscarDestinos());
		return lista;
	}
	
	public IntegerProperty getCodigoProperty() {
		return codigo;
	}
	public void setCodigoProperty(IntegerProperty codigo) {
		this.codigo = codigo;
	}
	public StringProperty getDestinoProperty() {
		return destino;
	}
	public void setDestinoProperty(StringProperty destino) {
		this.destino = destino;
	}
	public DoubleProperty getPrecoProperty() {
		return preco;
	}
	public void setPrecoProperty(DoubleProperty preco) {
		this.preco = preco;
	}
}
