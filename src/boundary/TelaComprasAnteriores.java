package boundary;

import java.util.Date;

import entity.Compra;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TelaComprasAnteriores extends TelaMaeCliente
						implements SubTela {

	@Override
	public Pane gerarTela() {
		
		BorderPane telaPrincipal = new BorderPane();
		
		TableView<Compra> table = new TableView<>(); 
		
		telaPrincipal.setCenter(table);

		// Criando a tabela ID precisamos criar as nossas
		TableColumn<Compra, Integer> colCodigo = new TableColumn<>("Codigo da Compra"); 
		TableColumn<Compra, Date> colDtCompra = new TableColumn<>("Data da Compra");
		TableColumn<Compra, String> colOrigem = new TableColumn<>("Origem");
		TableColumn<Compra, String> colDestino = new TableColumn<>("Destino");
		TableColumn<Compra, Double> colValor = new TableColumn<>("Valor");
		
		// Colocando as colunas na table
		table.getColumns().addAll(colCodigo, colOrigem, colDestino, colDtCompra, colValor);
		
		table.resizeColumn(colCodigo, 50);
		table.resizeColumn(colDtCompra, 100);
		table.resizeColumn(colDestino, 100);
		table.resizeColumn(colOrigem, 100);
		table.resizeColumn(colValor, 96);
		colCodigo.setResizable(false);
		colDtCompra.setResizable(false);
		colDestino.setResizable(false);
		colOrigem.setResizable(false);
		colValor.setResizable(false);
		
		//Pega a lista de contatos (observable arraylist) da control e coloca os dados na tabela
		//table.setItems(control.getLista());
		
		telaPrincipal.setLeft(super.gerarTelaEsq("ComprasAnteriores"));
		telaPrincipal.setCenter(table);
		return telaPrincipal;
	}

}
