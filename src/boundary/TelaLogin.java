package boundary;

import java.sql.SQLException;

import control.ClienteControl;
import control.LoginControl;
import entity.Cliente;
import entity.Login;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class TelaLogin extends TelaMaeDog implements SubTela, EventHandler<ActionEvent> {

	private Button btnLogin = new Button("Entrar");
	private Button btnCadastro = new Button("Cadastre-se");

	private TextField txtUsuario = new TextField();
	private TextField txtSenha = new TextField();
	
	private LoginControl loginControl = new LoginControl();
	private ClienteControl clienteControl = new ClienteControl();

	@Override
	public Pane gerarTela() {
		// Pane Principal - Retorno
		BorderPane telaPrincipal = new BorderPane();

		// Imagem logo
		Image imagee = new Image(getClass().getResourceAsStream("/Imagens/logo poo.png"));
		ImageView logo = new ImageView(imagee);

		// Propriedades Flow Pane
		FlowPane fp = new FlowPane();
		fp.setVgap(-100);
		fp.setPadding(new Insets(50, 20, 10, 10));

		// Propriedades Grip Pane
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(220, 105, 10, 70));
		gp.setVgap(10);
		gp.setHgap(5);

		// Adicionando texts no Grid Pane
		gp.add(new Label("Usuario"), 0, 0);
		gp.add(txtUsuario, 0, 1);
		gp.add(new Label("Senha"), 0, 2);
		gp.add(txtSenha, 0, 3);

		// Adicionando botões no Grid Pane
		btnLogin.setPrefSize(200, 0);
		btnLogin.setFont(new Font("Arial", 12));
		btnLogin.setOnAction(this);
		gp.add(btnLogin, 0, 4);
		btnCadastro.setPrefSize(200, 0);
		btnCadastro.setFont(new Font("Arial", 12));
		btnCadastro.setOnAction(this);
		gp.add(btnCadastro, 0, 5);

		// Alinhar elementos no Grid
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.CENTER);
		gp.getColumnConstraints().addAll(col1);

		// Adicionando Grid e logo no Flow Pane
		fp.getChildren().addAll(logo, gp);
		
		//Adicionando campos observáveis
		vincularCampos();
		
		// Adicionando imagem (Viajando com cachorro) e Flow Pane no pane principal
		telaPrincipal.setLeft(super.gerarTelaEsq());
		telaPrincipal.setRight(fp);

		return telaPrincipal;
	}
	
	private void vincularCampos() {
		Bindings.bindBidirectional(txtUsuario.textProperty(), loginControl.getUserProperty());
		Bindings.bindBidirectional(txtSenha.textProperty(), loginControl.getPassProperty());
	}

	@Override
	public void handle(ActionEvent e) {
		ControleTelas tControl = ControleTelas.getControleTelas();
		if (e.getTarget() == btnCadastro) {
			tControl.trocarTela("TelaCadastro");
		} else if (e.getTarget() == btnLogin) {
			try {
				Login l = loginControl.buscar();
				if(l.getPermission() == 1) {
					tControl.trocarTela("TelaCompra");
				} else if (l.getPermission() == 2){
					tControl.trocarTela("TelaDestinos");
				} else {
					Alert a = new Alert(AlertType.ERROR, "Usuario ou Senha inválidos");
					a.show();
				}
				
				Cliente c = new Cliente();
				c.setEmail(txtUsuario.getText());
				c = clienteControl.buscar(c);
				LoginControl.setCliente(c);
				
			} catch (SQLException e1) {
				Alert a = new Alert(AlertType.ERROR, "Error");
				a.show();
				e1.printStackTrace();
			}
			limparCampos();
		}
	}

	private void limparCampos() {
		txtUsuario.clear();
		txtSenha.clear();
	}
}