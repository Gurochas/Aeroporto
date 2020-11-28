package entity;

public class Classe {
	private String tipo;
	private double preco;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Classe [tipo=" + tipo + ", preco=" + preco + "]";
	}

}
