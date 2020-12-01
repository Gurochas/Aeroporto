package boundary;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TelaAlterarCadastro extends TelaMaeCliente
									implements SubTela{

	@Override
	public Pane gerarTela() {
		
		GridPane gp = new GridPane();
		
		gp.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE,null,null)));
		
		TextField txtNome = new TextField();
		TextField txtSobrenome = new TextField();
		TextField txtCpf = new TextField();
		DatePicker dpNasc = new DatePicker();
		TextField txtEmail = new TextField();
		TextField txtEndereco = new TextField();
		TextField txtNumero = new TextField();
		TextField txtBairro = new TextField();
		TextField txtCep = new TextField();
		TextField txtSenha = new TextField();
		
		Button btnSalvar = new Button("Salvar Alterações");
		
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(2);
		gp.setHgap(5);
		
		txtEmail.setMinWidth(200);
		gp.add(new Label("Email"), 0, 0);
		gp.add(txtEmail, 0, 1);
		
		gp.add(new Label("Senha"), 1, 0);
		gp.add(txtSenha, 1, 1);
		
		gp.add(new Label("Nome"), 0, 2);
		gp.add(txtNome, 0, 3);
		
		gp.add(new Label("Sobrenome"), 1, 2);
		gp.add(txtSobrenome, 1, 3);
		
		gp.add(new Label("CPF"), 0, 4);
		gp.add(txtCpf, 0, 5);
		
		gp.add(new Label("Data Nascimento"), 1, 4);
		gp.add(dpNasc, 1, 5);
		
		gp.add(new Label("Endereço"), 0, 6);
		gp.add(txtEndereco, 0, 7);
		
		gp.add(new Label("Número"), 1, 6);
		gp.add(txtNumero, 1, 7);
		
		gp.add(new Label("Bairro"), 0, 8);
		gp.add(txtBairro, 0, 9);
		
		gp.add(new Label("CEP"), 1, 8);
		gp.add(txtCep, 1, 9);
		
		btnSalvar.setPrefSize(150, 20);
		gp.add(btnSalvar, 1, 15);
		
		BorderPane telaPrincipal = new BorderPane();
		telaPrincipal.setLeft(super.gerarTelaEsq("AlterarCadastro"));
		telaPrincipal.setCenter(gp);
		return telaPrincipal;
	}
	

}
