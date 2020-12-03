package control;

import java.sql.SQLException;

import entity.Classe;
import entity.Cliente;
import entity.Compra;
import entity.Destino;
import entity.Passagem;
import entity.Viagem;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.PassagemDAO;

public class PassagemControl {
	
	private IntegerProperty codigo = new SimpleIntegerProperty();
	private DoubleProperty preco_Total = new SimpleDoubleProperty();
	private IntegerProperty portao = new SimpleIntegerProperty();
	private IntegerProperty lugar = new SimpleIntegerProperty();
	private StringProperty tipo_viagem = new SimpleStringProperty();
	private ObjectProperty<Cliente> cliente  = new SimpleObjectProperty<>();
	private ObjectProperty<Viagem> viagem = new SimpleObjectProperty<>();
	private ObjectProperty<Compra> compra  = new SimpleObjectProperty<>();
	private ObjectProperty<Classe> classe  = new SimpleObjectProperty<>();
	
	private ObservableList<Passagem> lista = FXCollections.observableArrayList();
	
	public Passagem getPassagem() {
		Passagem d = new Passagem();
		d.setCodigo(this.codigo.get());
		return d;
	}
	
	public void setPassagem(Passagem p) {
		if (p != null) {
			this.codigo.set(p.getCodigo());
			this.preco_Total.set(p.getPreco_Total());
			this.portao.set(p.getPortao());
			this.lugar.set(p.getLugar());
			this.tipo_viagem.set(p.getTipo_viagem());
			this.cliente.set(p.getCliente());
			this.viagem.set(p.getViagem());
			this.compra.set(p.getCompra());
			this.classe.set(p.getClasse());
		}
	}
	
	public void adicionar() throws SQLException {
		PassagemDAO destinoDAO = new PassagemDAO();
		Passagem d = getPassagem();
		destinoDAO.inserirPassagem(d);
	}
	
	public Passagem buscarPassagem (Passagem d) throws SQLException {
		PassagemDAO destinoDAO = new PassagemDAO();
		d = destinoDAO.buscarPassagem(d);
		return d;
	}
	
	public ObservableList<Passagem> buscarPassagems() throws SQLException{
		PassagemDAO passagemDAO = new PassagemDAO();
		lista.clear();
		lista.addAll(passagemDAO.buscarPassagens(getPassagem()));
		return lista;
	}
	
	public IntegerProperty getCodigoProperty() {
		return codigo;
	}
	public void setCodigoProperty(IntegerProperty codigo) {
		this.codigo = codigo;
	}
	public DoubleProperty getPreco_TotalProperty() {
		return preco_Total;
	}
	public void setPreco_TotalProperty(DoubleProperty preco_Total) {
		this.preco_Total = preco_Total;
	}
	public IntegerProperty getPortaoProperty() {
		return portao;
	}
	public void setPortaoProperty(IntegerProperty portao) {
		this.portao = portao;
	}
	public IntegerProperty getLugarProperty() {
		return lugar;
	}
	public void setLugarProperty(IntegerProperty lugar) {
		this.lugar = lugar;
	}
	public StringProperty getTipo_viagemProperty() {
		return tipo_viagem;
	}
	public void setTipo_viagemProperty(StringProperty tipo_viagem) {
		this.tipo_viagem = tipo_viagem;
	}
	public ObjectProperty<Cliente> getClienteProperty() {
		return cliente;
	}
	public void setClienteProperty(ObjectProperty<Cliente> cliente) {
		this.cliente = cliente;
	}
	public ObjectProperty<Viagem> getViagemProperty() {
		return viagem;
	}
	public void setViagemProperty(ObjectProperty<Viagem> viagem) {
		this.viagem = viagem;
	}
	public ObjectProperty<Compra> getCompraProperty() {
		return compra;
	}
	public void setCompraProperty(ObjectProperty<Compra> compra) {
		this.compra = compra;
	}
	public ObjectProperty<Classe> getClasseProperty() {
		return classe;
	}
	public void setClasseProperty(ObjectProperty<Classe> classe) {
		this.classe = classe;
	}
	
}
