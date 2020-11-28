package entity;

public class Tipo_Viagem {
	private String tipo;
	private int preco;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Tipo_viagem [tipo=" + tipo + ", preco=" + preco + "]";
	}
}
