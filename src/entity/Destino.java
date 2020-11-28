package entity;

public class Destino {
	private int codigo;
	private String loc_Destino;
	private String loc_Partida;
	private int preco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLoc_Destino() {
		return loc_Destino;
	}

	public void setLoc_Destino(String loc_Destino) {
		this.loc_Destino = loc_Destino;
	}

	public String getLoc_Partida() {
		return loc_Partida;
	}

	public void setLoc_Partida(String loc_Partida) {
		this.loc_Partida = loc_Partida;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Destino [codigo=" + codigo + ", loc_Destino=" + loc_Destino + ", loc_Partida=" + loc_Partida
				+ ", preco=" + preco + "]";
	}

}
