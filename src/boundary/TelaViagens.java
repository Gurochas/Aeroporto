package boundary;

import java.sql.SQLException;

import control.DestinoControl;
import control.ViagemControl;
import entity.Viagem;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TelaViagens extends TelaMaeAdm implements SubTela {
	
    TableView<Viagem> table = new TableView<>(); 
	ViagemControl vControl= new ViagemControl();


    @Override
    public Pane gerarTela() {
    	
        table.setPrefWidth(362);

        vincularCampos();

//        table.resizeColumn(colData, 100);
//        table.resizeColumn(colHChegada, 100);
//        table.resizeColumn(colHSaida, 100);
//        table.resizeColumn(colCodAviao, 100);
//        table.resizeColumn(colDestino, 100);
//
//        colData.setResizable(false);
//        colHChegada.setResizable(false);
//        colHSaida.setResizable(false);
//        colCodAviao.setResizable(false);
//        colDestino.setResizable(false);

        BorderPane telaPrincipal = new BorderPane();

        telaPrincipal.setLeft(super.gerarTelaEsq("TelaViagens"));
        telaPrincipal.setCenter(table);
        return telaPrincipal;
    }
    
    private void vincularCampos() {
    	
    	TableColumn<Viagem, Integer> colID = new TableColumn<>("ID");
        colID.setCellValueFactory( new PropertyValueFactory<Viagem, Integer>("Codigo"));
        
        TableColumn<Viagem, String> colData = new TableColumn<>("Data");    	
        colData.setCellValueFactory( new PropertyValueFactory<Viagem, String>("Data"));
        
        TableColumn<Viagem, Double> colHora = new TableColumn<>("Hora");
        colHora.setCellValueFactory(new PropertyValueFactory<Viagem, Double>("Hora"));
        
        TableColumn<Viagem, Double> colAviao = new TableColumn<>("Avião");
        colAviao.setCellValueFactory(new PropertyValueFactory<Viagem, Double>("Avião"));
        
        TableColumn<Viagem, Double> colDestino = new TableColumn<>("Destino");
        colDestino.setCellValueFactory(new PropertyValueFactory<Viagem, Double>("Destino"));
        
        table.setPrefWidth(362);

        table.getColumns().addAll(colID,colData,colHora,colAviao, colDestino);
        
        /*
        table.resizeColumn(colID, 10);
        table.resizeColumn(colDestino, 80);
        table.resizeColumn(colPreco, 30);
        colID.setResizable(false);
        colDestino.setResizable(false);
        colPreco.setResizable(false);
        */
        
        atualizarTabela();
    }
    
    public void atualizarTabela() {
    	try {
			table.setItems(vControl.buscarViagens());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}