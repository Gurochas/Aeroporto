package control;

import java.time.LocalDate;

import entity.Cliente;
import entity.Compra;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class CompraControl {

	private IntegerProperty codigo;
	private ObjectProperty<LocalDate> data_Compra;
	private ObjectProperty<Cliente> cliente;
	
	public Compra getCompra() {
		Compra c = new Compra();
		c.setCodigo(this.codigo.get());
		c.setData_Compra(this.data_Compra.get());
		c.setCliente(this.cliente.get());
		return c;
	}
	
	public void setCompra(Compra c) {
		if(c == null) {
			this.codigo.set(c.getCodigo());
			this.data_Compra.set(c.getData_Compra());
			this.cliente.set(c.getCliente());
		}
	}
	
	public void adicionar () {
		
	}
	
	public IntegerProperty getCodigo() {
		return codigo;
	}
	public void setCodigo(IntegerProperty codigo) {
		this.codigo = codigo;
	}
	public ObjectProperty<LocalDate> getData_Compra() {
		return data_Compra;
	}
	public void setData_Compra(ObjectProperty<LocalDate> data_Compra) {
		this.data_Compra = data_Compra;
	}
	public ObjectProperty<Cliente> getCliente() {
		return cliente;
	}
	public void setCliente(ObjectProperty<Cliente> cliente) {
		this.cliente = cliente;
	}
	
}
