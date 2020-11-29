package boundary;

import java.util.Date;

import entity.Compra;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

public class TelaAviao extends TelaMaeAdm implements SubTela {

    @Override
    public Pane gerarTela() {
    	
        GridPane gp = new GridPane();
        
        gp.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE,null,null)));

        TextField txtCodigo = new TextField();
        TextField txtEmpresa = new TextField();
        TextField txtModelo = new TextField();
        TextField txtQntLugares = new TextField();

        


        Button btnSalvar = new Button("Salvar Avião");

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(5);

        txtCodigo.setMinWidth(200);

        gp.add(new Label("Codigo"), 0, 0);
        gp.add(txtCodigo, 0, 1);

        gp.add(new Label("Empresa"), 0, 2);
        gp.add(txtEmpresa, 0, 3);
        
        gp.add(new Label("Modelo"), 0, 4);
        gp.add(txtModelo, 0, 5);
        
        gp.add(new Label("Quantidade de Lugares"), 0, 6);
        gp.add(txtQntLugares, 0, 7);

        btnSalvar.setPrefSize(150, 20);
        gp.add(btnSalvar, 0, 12);

        TableView<Compra> table = new TableView<>(); 

        table.setPrefWidth(362);

        TableColumn<Compra, String> colCodigo = new TableColumn<>("Codigo");
        TableColumn<Compra, String> colEmpresa = new TableColumn<>("Empresa");
        TableColumn<Compra, String> colModelo = new TableColumn<>("Modelo");
        TableColumn<Compra, String> colQtdLugares = new TableColumn<>("Qtd. Lugares");

        table.getColumns().addAll(colCodigo, colEmpresa, colModelo, colQtdLugares);

        table.resizeColumn(colCodigo, 100);
        table.resizeColumn(colEmpresa, 100);
        table.resizeColumn(colModelo, 100);
        table.resizeColumn(colQtdLugares, 100);
        colCodigo.setResizable(false);
        colEmpresa.setResizable(false);
        colModelo.setResizable(false);
        colQtdLugares.setResizable(false);

        BorderPane telaPrincipal = new BorderPane();

        telaPrincipal.setLeft(super.gerarTelaEsq("TelaAviao"));
        telaPrincipal.setCenter(gp);
        telaPrincipal.setRight(table);
        return telaPrincipal;
    }

}