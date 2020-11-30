package entity;

public class Destino {
	private int codigo;
	private String Destino;
	private double preco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String Destino) {
		this.Destino = Destino;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Destino [codigo=" + codigo + ", Destino=" + Destino + ", preco=" + preco + "]";
	}

}
