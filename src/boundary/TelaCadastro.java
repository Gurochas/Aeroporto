package boundary;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import control.ClienteControl;
import control.LoginControl;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class TelaCadastro extends TelaMaeDog
				implements SubTela, EventHandler<ActionEvent> {
	
	private TextField txtNome = new TextField();
	private TextField txtSobrenome = new TextField();
	private TextField txtCpf = new TextField();
	private TextField txtNasc = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtLogradouro = new TextField();
	private TextField txtNumero = new TextField();
	private TextField txtBairro = new TextField();
	private TextField txtCep = new TextField();
	private TextField txtSenha = new TextField();
	
	private Button btnVoltar = new Button("Voltar");
	private Button btnCadastro = new Button("Cadastrar");
	
	private ClienteControl clienteControl = new ClienteControl();
	private LoginControl loginControl = new LoginControl();

	@Override
	public Pane gerarTela() {
		StackPane sp = new StackPane();
		GridPane gp = new GridPane();
		gp.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE,null,null)));
		
		btnVoltar.setPrefSize(90, 50);
		
		vincularCampos();
		dateField(txtNasc);
		
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
		gp.add(txtLogradouro, 1, 11);
		gp.add(new Label("Número"), 1, 12);
		gp.add(txtNumero, 1, 13);
		gp.add(new Label("Bairro"), 1, 14);
		gp.add(txtBairro, 1, 15);
		gp.add(new Label("CEP"), 1, 16);
		gp.add(txtCep, 1, 17);
		gp.add(new Label("Senha"), 1, 18);
		gp.add(txtSenha, 1, 19);
		gp.add(btnCadastro, 1, 22);
		
		
		btnCadastro.setOnAction(this);
		
		sp.getChildren().setAll(super.gerarTelaEsq(),btnVoltar);
		sp.setAlignment(btnVoltar, Pos.BOTTOM_LEFT);
		
		btnVoltar.setOnAction(this);
		
		BorderPane telaPrincipal = new BorderPane();
		telaPrincipal.setLeft(sp);
		telaPrincipal.setCenter(gp);
		
		return telaPrincipal;

	}
	
	private void vincularCampos() {
		StringConverter<? extends Number> converter = new IntegerStringConverter();
		
		Bindings.bindBidirectional(txtCpf.textProperty(), clienteControl.getCpfProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), clienteControl.getNomeProperty());
		Bindings.bindBidirectional(txtSobrenome.textProperty(), clienteControl.getSobrenomeProperty());
		Bindings.bindBidirectional(txtEmail.textProperty(), clienteControl.getEmailProperty());
		Bindings.bindBidirectional(txtEmail.textProperty(), loginControl.getUserProperty());
		Bindings.bindBidirectional(txtLogradouro.textProperty(), clienteControl.getLogradouroProperty());
		Bindings.bindBidirectional(txtNumero.textProperty(), clienteControl.getNumeroProperty(), (StringConverter<Number>)converter);
		Bindings.bindBidirectional(txtBairro.textProperty(), clienteControl.getBairroProperty());
		Bindings.bindBidirectional(txtCep.textProperty(), clienteControl.getCepProperty());
		Bindings.bindBidirectional(txtSenha.textProperty(), loginControl.getPassProperty());
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
	
	private void regData() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(txtNasc.getText(), dtf);
		clienteControl.getData_NascProperty().set(ld);
	}
	
	private void limparCampos() {
		txtNome.clear();
		txtSobrenome.clear();
		txtCpf.clear();
		txtNasc.clear();
		txtEmail.clear();
		txtLogradouro.clear();
		txtNumero.clear(); 
		txtBairro.clear();
		txtCep.clear();
		txtSenha.clear();
	}

	@Override
	public void handle(ActionEvent e) {
		ControleTelas tControl = ControleTelas.getControleTelas();
		if (e.getTarget() == btnCadastro) {
			try {
				regData();
				clienteControl.adicionar();
				loginControl.adicionar();
				Alert a = new Alert(AlertType.CONFIRMATION, "Cadastro realizado!", ButtonType.OK);
				a.show();
				limparCampos();
			} catch (SQLException e1) {
				Alert a = new Alert(AlertType.ERROR, "Erro ao gravar o contato", ButtonType.OK);
				a.show();
				e1.printStackTrace();
			}
		}else {
			tControl.trocarTela("TelaLogin");
			limparCampos();
		}
		
	}

}
