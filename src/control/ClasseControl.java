package control;

import entity.Classe;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClasseControl {

	private StringProperty tipo = new SimpleStringProperty();
	private DoubleProperty preco = new SimpleDoubleProperty();
	
	
	public Classe getClasse(){
		Classe c = new Classe();
		c.setTipo(this.tipo.get());
		c.setPreco(this.preco.get());
		return c;
	}
	
	public void setClasse(Classe c){
		if (c != null) {
			this.tipo.set(c.getTipo());
			this.preco.set(c.getPreco());
		}
	}
	
	public StringProperty getTipo() {
		return tipo;
	}
	public void setTipo(StringProperty tipo) {
		this.tipo = tipo;
	}
	public DoubleProperty getPreco() {
		return preco;
	}
	public void setPreco(DoubleProperty preco) {
		this.preco = preco;
	}
	
}
