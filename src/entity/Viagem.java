package entity;

import java.util.Date;

public class Viagem {
	
	private int codigo;
	private Date data;
	private Date horario_Saida;
	private Date horario_Chegada;
	private Aviao aviao;
	private Destino destino;
	private Tipo_Viagem tipo_viagem;

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

	public Date getHorario_Saida() {
		return horario_Saida;
	}

	public void setHorario_Saida(Date horario_Saida) {
		this.horario_Saida = horario_Saida;
	}

	public Date getHorario_Chegada() {
		return horario_Chegada;
	}

	public void setHorario_Chegada(Date horario_Chegada) {
		this.horario_Chegada = horario_Chegada;
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

	public Tipo_Viagem getTipo_viagem() {
		return tipo_viagem;
	}

	public void setTipo_viagem(Tipo_Viagem tipo_viagem) {
		this.tipo_viagem = tipo_viagem;
	}

	@Override
	public String toString() {
		return "Viagem [codigo=" + codigo + ", data=" + data + ", horario_Saida=" + horario_Saida + ", horario_Chegada="
				+ horario_Chegada + ", aviao=" + aviao + ", destino=" + destino + ", tipo_viagem=" + tipo_viagem + "]";
	}

}
