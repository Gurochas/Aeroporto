package entity;

import java.util.Date;

public class Viagem {
	
	private int codigo;
	private Date data;
	private Date hora;
	private Aviao aviao;
	private Destino destino;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date setHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}


	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

}
