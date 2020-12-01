package entity;

public class Passagem {
	private int codigo;
	private double preco_Total;
	private int portao;
	private int lugar;
	private Cliente cliente;
	private Viagem viagem;
	private Compra compra;
	private Classe classe;
	private String tipo_viagem;

	public String getTipo_viagem() {
		return tipo_viagem;
	}

	public void setTipo_viagem(String tipo_viagem) {
		this.tipo_viagem = tipo_viagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco_Total() {
		return preco_Total;
	}

	public void setPreco_Total(double preco_Total) {
		this.preco_Total = preco_Total;
	}

	public int getPortao() {
		return portao;
	}

	public void setPortao(int portao) {
		this.portao = portao;
	}

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Passagem [codigo=" + codigo + ", preco_Total=" + preco_Total + ", portao=" + portao + ", lugar=" + lugar
				+ ", cliente=" + cliente + ", viagem=" + viagem + ", compra=" + compra + ", classe=" + classe + "]";
	}

}
