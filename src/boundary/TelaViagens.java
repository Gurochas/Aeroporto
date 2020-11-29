package boundary;

import entity.Compra;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TelaViagens extends TelaMaeAdm implements SubTela {

    @Override
    public Pane gerarTela() {
    	
        GridPane gp = new GridPane();
        
        gp.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE,null,null)));

        TextField txtData = new TextField();
        TextField txtHSaida = new TextField();
        TextField txtHChegada = new TextField();
        TextField txtCodAviao = new TextField();
        TextField txtDestino = new TextField();


        


        Button btnSalvar = new Button("Salvar Avião");

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(5);

        txtData.setMinWidth(200);

        gp.add(new Label("Data"), 0, 0);
        gp.add(txtData, 0, 1);

        gp.add(new Label("Horario saída"), 0, 2);
        gp.add(txtHSaida, 0, 3);
        
        gp.add(new Label("Horário chegada"), 0, 4);
        gp.add(txtHChegada, 0, 5);
        
        gp.add(new Label("Codigo Avião"), 0, 6);
        gp.add(txtCodAviao, 0, 7);
        
        gp.add(new Label("Destino"), 0, 8);
        gp.add(txtDestino, 0, 9);

        btnSalvar.setPrefSize(150, 20);
        gp.add(btnSalvar, 0, 14);

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
        telaPrincipal.setCenter(gp);
        telaPrincipal.setRight(table);
        return telaPrincipal;
    }

}