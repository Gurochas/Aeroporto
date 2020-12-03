package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import control.ClienteControl;
import control.CompraControl;
import control.LoginControl;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TelaCompra extends TelaMaeCliente implements SubTela {
	
	Label lblTicketOrigem = new Label("São Paulo");
	Label lblTicketDestino = new Label("");
	Label lblTicketDataIda = new Label("");
	Label lblTicketHorarioIda = new Label("");
	Label lblTicketClasse = new Label("");
	Label lblTicketDataVolta = new Label("");

	ChoiceBox<String> cbClasse = new ChoiceBox<>();
	TextField txtQtd = new TextField();
	TextField txtDestino = new TextField();
	TextField txtIda = new TextField();
	TextField txtVolta = new TextField();
	@Override
	public Pane gerarTela() {

		GridPane gp = new GridPane();
		GridPane gpTicket = new GridPane();
		StackPane sp = new StackPane();
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(55);
		gpTicket.getColumnConstraints().addAll(col1);

		gp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

		gp.setAlignment(Pos.CENTER);
		
		vincularCampos();
		Label lblDestino = new Label("Destino");
		Label lblIda = new Label("Ida");
		Label lblVolta = new Label("Volta");
		Label lblClasse = new Label("Classe");
		Label lblQtd = new Label("Quantidade");	
		
		

		Label lblTicketNome = new Label(LoginControl.getCliente().getNome() + " " + LoginControl.getCliente().getSobrenome());

		CheckBox cb = new CheckBox();
		cb.setText("Ida e volta");




		Button btnFinalizar = new Button("Finalizar Compra");

		cbClasse.getItems().addAll("Economica", "Executiva", "Primeira");

//		btnFinalizar.setOnAction((e) -> {
//			if(cbClasse.getValue().equals("Executiva")) {
//				System.out.println(cbClasse.getValue());
//			}
//		});

		gp.setVgap(10);
		gp.setHgap(30);

		gp.add(lblDestino, 0, 0);
		gp.add(txtDestino, 0, 1);

		gp.add(lblQtd, 1, 0);
		gp.add(txtQtd, 1, 1);

		gp.add(cb, 0, 2);

		gp.add(lblIda, 0, 3);
		gp.add(txtIda, 0, 4);

		gp.add(lblVolta, 1, 3);
		gp.add(txtVolta, 1, 4);

		lblVolta.setVisible(false);
		txtVolta.setVisible(false);

		cb.setOnAction((e) -> {
			if (cb.isSelected()) {
				lblVolta.setVisible(true);
				txtVolta.setVisible(true);
			} else {
				lblVolta.setVisible(false);
				txtVolta.setVisible(false);
			}
		});

		if (cb.isSelected()) {
			lblVolta.setVisible(false);
			txtVolta.setVisible(false);
			gp.add(lblVolta, 1, 4);
			gp.add(txtVolta, 1, 4);
		}

		gp.add(lblClasse, 0, 5);
		gp.add(cbClasse, 0, 6);
	
		
		gp.add(btnFinalizar, 1, 6);
		lblTicketOrigem.setFont(new Font("Arial", 16));
		lblTicketOrigem.setTextFill(Color.WHITE);
		lblTicketDestino.setFont(new Font("Arial", 16));
		lblTicketDestino.setTextFill(Color.WHITE);
		lblTicketNome.setFont(new Font("Arial", 16));
		lblTicketNome.setTextFill(Color.WHITE);
		lblTicketDataIda.setFont(new Font("Arial", 16));
		lblTicketDataIda.setTextFill(Color.WHITE);
		lblTicketDataVolta.setFont(new Font("Arial", 16));
		lblTicketDataVolta.setTextFill(Color.WHITE);
		lblTicketHorarioIda.setFont(new Font("Arial", 16));
		lblTicketHorarioIda.setTextFill(Color.WHITE);
		lblTicketClasse.setFont(new Font("Arial", 16));
		lblTicketClasse.setTextFill(Color.WHITE);

		Image imgTicket = new Image(getClass().getResourceAsStream("/Imagens/ticket clicao.jpg"));
		ImageView imgvTicket = new ImageView(imgTicket);

		sp.getChildren().addAll(imgvTicket, gpTicket);
		gpTicket.setVgap(5);
		gpTicket.setPadding(new Insets(140, 30, 30, 60));
		gpTicket.add(lblTicketOrigem, 0, 0);
		gpTicket.add(lblTicketDestino, 1, 0);
		gpTicket.add(lblTicketNome, 0, 26);
		gpTicket.add(lblTicketDataIda, 0, 46);
		gpTicket.add(lblTicketDataVolta, 1, 46);
		gpTicket.add(lblTicketHorarioIda, 0, 55);
		gpTicket.add(lblTicketClasse, 1, 55);
		
		dateField(txtIda);
		dateField(txtVolta);

		BorderPane telaPrincipal = new BorderPane();
		telaPrincipal.setLeft(super.gerarTelaEsq("Compra"));
		telaPrincipal.setCenter(gp);
		telaPrincipal.setRight(sp);
		return telaPrincipal;
	}
	
	
	private void vincularCampos() {
		ClienteControl cliControl = new ClienteControl();
		cliControl.setCliente(LoginControl.getCliente());

		Bindings.bindBidirectional(txtDestino.textProperty(), lblTicketDestino.textProperty());
		Bindings.bindBidirectional((txtIda).textProperty(), lblTicketDataIda.textProperty());
		Bindings.bindBidirectional((txtVolta).textProperty(), lblTicketDataVolta.textProperty());
		Bindings.bindBidirectional(cbClasse.valueProperty(), lblTicketClasse.textProperty());
		//Bindings.bindBidirectional(txtLogradouro.textProperty(), lblTicketHorarioIda.textProperty());
		
	}
	
	private static void maxField(final TextField textField, final Integer length) {
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				if (newValue.length() > length)
					textField.setText(oldValue);
			}
		});
	}

	private static void positionCaret(final TextField textField) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				textField.positionCaret(textField.getText().length());
			}
		});
	}

	public static void dateField(final TextField textField) {
		maxField(textField, 10);

		textField.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() < 11) {
					String value = textField.getText();
					value = value.replaceAll("[^0-9]", "");
					value = value.replaceFirst("(\\d{2})(\\d)", "$1/$2");
					value = value.replaceFirst("(\\d{2})\\/(\\d{2})(\\d)", "$1/$2/$3");
					textField.setText(value);
					positionCaret(textField);
				}
			}
		});
	}
	
	
	
	

}