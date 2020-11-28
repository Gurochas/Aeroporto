package entity;

import java.util.Date;

public class Compra {
	private int codigo;
	private Date data_Compra;
	private Cliente cliente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData_Compra() {
		return data_Compra;
	}

	public void setData_Compra(Date data_Compra) {
		this.data_Compra = data_Compra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", data_Compra=" + data_Compra + ", cliente=" + cliente + "]";
	}

}
