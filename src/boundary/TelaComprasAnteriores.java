package boundary;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import entity.Compra;
import entity.Destino;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TelaComprasAnteriores extends TelaMaeCliente
						implements SubTela {

	@Override
	public Pane gerarTela() {
		
		BorderPane telaPrincipal = new BorderPane();
		
		TableView<Compra> table = new TableView<>(); 
		
		telaPrincipal.setCenter(table);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		// Criando a tabela ID precisamos criar as nossas
		TableColumn<Compra, Integer> colCodigo = new TableColumn<>("Codigo da Compra"); 
        colCodigo.setCellValueFactory( new PropertyValueFactory<Compra, Integer>("Codigo"));
		TableColumn<Compra, String> colDtCompra = new TableColumn<>("Data da Compra");
		colDtCompra.setCellValueFactory(
				(item) -> {return new ReadOnlyStringWrapper(item.getValue().getData_Compra().format(dtf));});		
		TableColumn<Compra, String> colClasse = new TableColumn<>("Classe");
        colClasse.setCellValueFactory( new PropertyValueFactory<Compra, String>("Classe"));
		TableColumn<Compra, String> colDestino = new TableColumn<>("Destino");
        colDestino.setCellValueFactory( new PropertyValueFactory<Compra, String>("Destino"));
		TableColumn<Compra, Double> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory( new PropertyValueFactory<Compra, Double>("Codigo"));

		
		// Colocando as colunas na table
		table.getColumns().addAll(colCodigo, colClasse, colDestino, colDtCompra, colValor);
		
		table.resizeColumn(colCodigo, 50);
		table.resizeColumn(colDtCompra, 100);
		table.resizeColumn(colDestino, 100);
		table.resizeColumn(colClasse, 100);
		table.resizeColumn(colValor, 96);
		colCodigo.setResizable(false);
		colDtCompra.setResizable(false);
		colDestino.setResizable(false);
		colClasse.setResizable(false);
		colValor.setResizable(false);
		
		//Pega a lista de contatos (observable arraylist) da control e coloca os dados na tabela
		//table.setItems(control.getLista());
		
		telaPrincipal.setLeft(super.gerarTelaEsq("ComprasAnteriores"));
		telaPrincipal.setCenter(table);
		return telaPrincipal;
	}

}
