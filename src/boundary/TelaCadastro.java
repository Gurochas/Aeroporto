package boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TelaCadastro extends TelaMaeDog
				implements SubTela, EventHandler<ActionEvent> {


	@Override
	public Pane gerarTela() {
		
		// Pane Principal - Retorno
		BorderPane telaPrincipal = new BorderPane();
				
		GridPane gp = new GridPane();
		Button btnCadastro = new Button("Cadastrar");

		TextField txtNome = new TextField();
		TextField txtSobrenome = new TextField();
		TextField txtCpf = new TextField();
		TextField txtNasc = new TextField();
		TextField txtEmail = new TextField();
		TextField txtEndereco = new TextField();
		TextField txtNumero = new TextField();
		TextField txtBairro = new TextField();
		TextField txtCep = new TextField();
		
		gp.setPadding(new Insets(60, 105, 10, 70));
		gp.setVgap(2);
		gp.setHgap(5);
		gp.add(new Label("Nome"), 1, 0);
		gp.add(txtNome, 1, 1);
		gp.add(new Label("Sobrenome"), 1, 2);
		gp.add(txtSobrenome, 1, 3);
		gp.add(new Label("CPF"), 1, 4);
		gp.add(txtCpf, 1, 5);
		gp.add(new Label("Data Nascimento"), 1, 6);
		gp.add(txtNasc, 1, 7);
		gp.add(new Label("Email"), 1, 8);
		gp.add(txtEmail, 1, 9);
		gp.add(new Label("Endereço"), 1, 10);
		gp.add(txtEndereco, 1, 11);
		gp.add(new Label("Número"), 1, 12);
		gp.add(txtNumero, 1, 13);
		gp.add(new Label("Bairro"), 1, 14);
		gp.add(txtBairro, 1, 15);
		gp.add(new Label("CEP"), 1, 16);
		gp.add(txtCep, 1, 17);
		gp.add(btnCadastro, 1, 22);

		btnCadastro.setOnAction(this);
		
		telaPrincipal.setLeft(super.gerarTelaEsq());
		telaPrincipal.setRight(gp);
		
		return telaPrincipal;

	}

	@Override
	public void handle(ActionEvent e) {
		TelaControle tControl = TelaControle.getTelaControle();
		tControl.trocarTela("");
	}

}
