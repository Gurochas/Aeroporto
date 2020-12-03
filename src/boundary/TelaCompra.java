package boundary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import control.ClienteControl;
import control.CompraControl;
import control.LoginControl;
import javafx.beans.binding.Bindings;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TelaCompra extends TelaMaeCliente implements SubTela {
	
	Label lblTicketOrigem = new Label("São Paulo");
	Label lblTicketDestino = new Label("");
	Label lblTicketNome = new Label("Gabriel E. Vicente Darbone");
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

		gp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

		gp.setAlignment(Pos.CENTER);

		vincularCampos();
		Label lblDestino = new Label("Destino");
		Label lblIda = new Label("Ida");
		Label lblVolta = new Label("Volta");
		Label lblClasse = new Label("Classe");
		Label lblQtd = new Label("Quantidade");


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

		BorderPane telaPrincipal = new BorderPane();
		telaPrincipal.setLeft(super.gerarTelaEsq("Compra"));
		telaPrincipal.setCenter(gp);
		telaPrincipal.setRight(sp);
		return telaPrincipal;
	}
	
	
	
	private void vincularCampos() {
		ClienteControl cliControl = new ClienteControl();
		cliControl.setCliente(LoginControl.getCliente());

		Bindings.bindBidirectional(lblTicketNome.textProperty(), cliControl.getNomeProperty());
		Bindings.bindBidirectional(txtDestino.textProperty(), lblTicketDestino.textProperty());
		Bindings.bindBidirectional((txtIda).textProperty(), lblTicketDataIda.textProperty());
		Bindings.bindBidirectional((txtVolta).textProperty(), lblTicketDataVolta.textProperty());
		Bindings.bindBidirectional(cbClasse.valueProperty(), lblTicketClasse.textProperty());
		//Bindings.bindBidirectional(txtLogradouro.textProperty(), lblTicketHorarioIda.textProperty());
		
	}
	
	
	
	

}