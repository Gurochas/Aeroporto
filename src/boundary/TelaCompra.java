package boundary;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TelaCompra extends TelaMaeCliente 
							implements SubTela{
	

	@Override
	public Pane gerarTela() {
		
		GridPane gp = new GridPane();
		
		gp.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE,null,null)));
		
		gp.setAlignment(Pos.CENTER);
		
		Label lblOrigem = new Label("Origem");
		Label lblDestino = new Label("Destino");
		Label lblIda = new Label("Ida");
		Label lblVolta = new Label("Volta");
		Label lblClasse = new Label("Classe");
		
		TextField txtOrigem = new TextField();
		TextField txtDestino = new TextField();
		
		CheckBox cb = new CheckBox();
		cb.setText("Ida e volta");
		
		DatePicker dpIda = new DatePicker();
		DatePicker dpVolta = new DatePicker();
	
		ChoiceBox<String> cbClasse = new ChoiceBox<>();
		
		Button btnFinalizar = new Button("Finalizar Compra");
		
		
		cbClasse.getItems().addAll("Economica", "Executiva", "Primeira Classe");
		
//		btnFinalizar.setOnAction((e) -> {
//			if(cbClasse.getValue().equals("Executiva")) {
//				System.out.println(cbClasse.getValue());
//			}
//		});
		
		gp.setVgap(10);
		gp.setHgap(30);
		
		gp.add(lblOrigem, 0, 0);
		gp.add(txtOrigem, 0, 1);
		
		gp.add(lblDestino, 1, 0);
		gp.add(txtDestino, 1, 1);
		
		gp.add(cb, 0, 2);
		
		gp.add(lblIda, 0, 3);
		gp.add(dpIda, 0, 4);

		gp.add(lblVolta, 1, 3);
		gp.add(dpVolta, 1, 4);
		
		lblVolta.setVisible(false);
		dpVolta.setVisible(false);
		
		cb.setOnAction((e) -> {
			if (cb.isSelected()) {
				lblVolta.setVisible(true);
				dpVolta.setVisible(true);
			}else {
				lblVolta.setVisible(false);
				dpVolta.setVisible(false);
			}
		});
			
		if (cb.isSelected()) {
			lblVolta.setVisible(false);
			dpVolta.setVisible(false);
			gp.add(lblVolta, 1, 4);
			gp.add(dpVolta, 1, 4);
		}
		
		gp.add(lblClasse, 0, 5);
		gp.add(cbClasse, 0, 6);
		
		gp.add(btnFinalizar, 1, 6);
		
		
		BorderPane telaPrincipal = new BorderPane();
		telaPrincipal.setLeft(super.gerarTelaEsq("Compra"));
		telaPrincipal.setCenter(gp);
		return telaPrincipal;
	}


}