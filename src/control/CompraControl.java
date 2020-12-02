package control;

import java.time.LocalDate;

import entity.Cliente;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class CompraControl {

	private IntegerProperty codigo;
	private ObjectProperty<LocalDate> data_Compra;
	private ObjectProperty<Cliente> cliente;
	
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
