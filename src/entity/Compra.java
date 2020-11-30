package entity;

import java.time.LocalDate;

public class Compra {
	private int codigo;
	private LocalDate data_Compra;
	private Cliente cliente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData_Compra() {
		return data_Compra;
	}

	public void setData_Compra(LocalDate data_Compra) {
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
