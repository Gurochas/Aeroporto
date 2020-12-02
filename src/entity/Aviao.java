package entity;

public class Aviao {
	
	private int codigo;
	private String empresa;
	private String modelo;
	private int qtd_lugares;
	private double preco;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getQtd_lugares() {
		return qtd_lugares;
	}

	public void setQtd_lugares(int qtd_lugares) {
		this.qtd_lugares = qtd_lugares;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Aviao [codigo=" + codigo + ", Empresa=" + empresa + ", Modelo=" + modelo + ", Qtd_lugares="
				+ qtd_lugares + ", Preco=" + preco + "]";
	}

}
