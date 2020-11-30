package entity;

public class Aviao {
	private int codigo;
	private String Empresa;
	private String Modelo;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public int getQtd_lugares() {
		return Qtd_lugares;
	}

	public void setQtd_lugares(int qtd_lugares) {
		Qtd_lugares = qtd_lugares;
	}

	public Double getPreco() {
		return Preco;
	}

	public void setPreco(Double preco) {
		Preco = preco;
	}

	private int Qtd_lugares;
	private Double Preco;

	@Override
	public String toString() {
		return "Aviao [codigo=" + codigo + ", Empresa=" + Empresa + ", Modelo=" + Modelo + ", Qtd_lugares="
				+ Qtd_lugares + ", Preco=" + Preco + "]";
	}

}
