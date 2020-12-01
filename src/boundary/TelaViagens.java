package boundary;

import entity.Compra;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TelaViagens extends TelaMaeAdm implements SubTela {

    @Override
    public Pane gerarTela() {
    	
        TableView<Compra> table = new TableView<>(); 

        table.setPrefWidth(362);

        TableColumn<Compra, String> colData = new TableColumn<>("Data");
        TableColumn<Compra, String> colHChegada = new TableColumn<>("Horário Chegada");
        TableColumn<Compra, String> colHSaida = new TableColumn<>("Horário Saída");
        TableColumn<Compra, String> colCodAviao = new TableColumn<>("Cod. Avião");
        TableColumn<Compra, String> colDestino = new TableColumn<>("Destino");


        table.getColumns().addAll(colData, colHChegada, colHSaida, colCodAviao, colDestino);

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

}