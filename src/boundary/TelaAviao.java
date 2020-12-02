package boundary;

import java.sql.SQLException;

import control.AviaoControl;
import entity.Aviao;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class TelaAviao extends TelaMaeAdm implements SubTela, EventHandler<ActionEvent> {

	private AviaoControl ac = new AviaoControl();

	private TableView<Aviao> table = new TableView<>();

	private TextField txtEmpresa = new TextField();
	private TextField txtModelo = new TextField();
	private TextField txtQntLugares = new TextField();
	private TextField txtPreco = new TextField();

	@Override
	public Pane gerarTela() {

		GridPane gp = new GridPane();

		gp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		
		vincularCampos();

		Button btnSalvar = new Button("Salvar Avião");

		gp.setAlignment(Pos.CENTER);
		gp.setVgap(5);

		txtEmpresa.setMinWidth(200);

		gp.add(new Label("Empresa"), 0, 0);
		gp.add(txtEmpresa, 0, 1);

		gp.add(new Label("Modelo"), 0, 2);
		gp.add(txtModelo, 0, 3);

		gp.add(new Label("Quantidade de Lugares"), 0, 4);
		gp.add(txtQntLugares, 0, 5);

		gp.add(new Label("Preco %"), 0, 6);
		gp.add(txtPreco, 0, 7);

		btnSalvar.setPrefSize(150, 20);
		gp.add(btnSalvar, 0, 12);
		
		btnSalvar.setOnAction(this);

		BorderPane telaPrincipal = new BorderPane();

		telaPrincipal.setLeft(super.gerarTelaEsq("TelaAviao"));
		telaPrincipal.setCenter(gp);
		telaPrincipal.setRight(table);
		return telaPrincipal;
	}

	private void vincularCampos() {

		StringConverter<? extends Number> integerConverter = new IntegerStringConverter();
		StringConverter<? extends Number> doubleConverter = new DoubleStringConverter();

		Bindings.bindBidirectional(txtEmpresa.textProperty(), ac.getEmpresaProperty());
		Bindings.bindBidirectional(txtModelo.textProperty(), ac.getModeloProperty());
		Bindings.bindBidirectional(txtQntLugares.textProperty(), ac.getQtd_lugaresProperty(),(StringConverter<Number>) integerConverter);
		Bindings.bindBidirectional(txtPreco.textProperty(), ac.getPrecoProperty(),(StringConverter<Number>) doubleConverter);

		TableColumn<Aviao, Integer> colCodigo = new TableColumn<>("Codigo");
		colCodigo.setCellValueFactory(new PropertyValueFactory<Aviao, Integer>("codigo"));

		TableColumn<Aviao, String> colEmpresa = new TableColumn<>("Empresa");
		colEmpresa.setCellValueFactory(new PropertyValueFactory<Aviao, String>("empresa"));

		TableColumn<Aviao, String> colModelo = new TableColumn<>("Modelo");
		colModelo.setCellValueFactory(new PropertyValueFactory<Aviao, String>("modelo"));

		TableColumn<Aviao, Integer> colQtdLugares = new TableColumn<>("Qtd. Lugares");
		colQtdLugares.setCellValueFactory(new PropertyValueFactory<Aviao, Integer>("qtd_lugares"));

		TableColumn<Aviao, Double> colPreco = new TableColumn<>("Preco");
		colPreco.setCellValueFactory(new PropertyValueFactory<Aviao, Double>("preco"));

		table.setPrefWidth(450);

		table.resizeColumn(colCodigo, 10);
		table.resizeColumn(colEmpresa, 10);
		table.resizeColumn(colModelo, 10);
		table.resizeColumn(colQtdLugares, 10);
		table.resizeColumn(colPreco, 10);
		colCodigo.setResizable(false);
		colEmpresa.setResizable(false);
		colModelo.setResizable(false);
		colQtdLugares.setResizable(false);
		colPreco.setResizable(false);

		table.getColumns().addAll(colCodigo, colEmpresa, colModelo, colQtdLugares, colPreco);

		atualizarTabela();
	}

	private void atualizarTabela() {
		try {
			table.setItems(ac.buscarAvioes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void limparCampos() {
    	txtEmpresa.clear();
    	txtModelo.clear();
    	txtQntLugares.clear();
    	txtPreco.clear();		
	}

	@Override
	public void handle(ActionEvent arg0) {
		try {
			ac.adicionar();
			Alert a = new Alert(AlertType.CONFIRMATION, "Cadastro realizado!", ButtonType.OK);
			a.show();
			limparCampos();
			atualizarTabela();
		} catch (SQLException e1) {
			Alert a = new Alert(AlertType.ERROR, "Erro ao gravar o avião", ButtonType.OK);
			a.show();
			e1.printStackTrace();
		}
	}

}