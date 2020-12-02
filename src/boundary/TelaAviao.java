package boundary;

import java.sql.SQLException;

import control.AviaoControl;
import entity.Aviao;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

        TableView<Aviao> table = new TableView<>(); 

        table.setPrefWidth(362);

        TableColumn<Aviao, Integer> colCodigo = new TableColumn<>("Codigo");
        colCodigo.setCellValueFactory(new PropertyValueFactory<Aviao, Integer>("Codigo"));
        TableColumn<Aviao, String> colEmpresa = new TableColumn<>("Empresa");
        colEmpresa.setCellValueFactory(new PropertyValueFactory<Aviao, String>("Empresa"));
        TableColumn<Aviao, String> colModelo = new TableColumn<>("Modelo");
        colEmpresa.setCellValueFactory(new PropertyValueFactory<Aviao, String>("Modelo"));
        TableColumn<Aviao, Integer> colQtdLugares = new TableColumn<>("Qtd. Lugares");
        colQtdLugares.setCellValueFactory(new PropertyValueFactory<Aviao, Integer>("Qtd. Lugares"));
        
    	AviaoControl ac = new AviaoControl();

        table.getColumns().addAll(colCodigo, colEmpresa, colModelo, colQtdLugares);
        
        try {
			table.setItems(ac.buscarAvioes());
		} catch (SQLException e) {
			e.printStackTrace();
		}

        
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