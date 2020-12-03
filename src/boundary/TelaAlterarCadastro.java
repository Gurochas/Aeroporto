package boundary;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import control.ClienteControl;
import control.LoginControl;
import entity.Login;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class TelaAlterarCadastro extends TelaMaeCliente implements SubTela, EventHandler<ActionEvent> {

	TextField txtNome = new TextField();
	TextField txtSobrenome = new TextField();
	TextField txtCpf = new TextField();
	TextField txtNasc = new TextField();
	TextField txtEmail = new TextField();
	TextField txtLogradouro = new TextField();
	TextField txtNumero = new TextField();
	TextField txtBairro = new TextField();
	TextField txtCep = new TextField();
	TextField txtSenha = new TextField();

	ClienteControl clienteControl = new ClienteControl();
	LoginControl loginControl = new LoginControl();

	@Override
	public Pane gerarTela() {

		GridPane gp = new GridPane();

		gp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

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
		gp.add(txtNasc, 1, 5);

		gp.add(new Label("Endereço"), 0, 6);
		gp.add(txtLogradouro, 0, 7);

		gp.add(new Label("Número"), 1, 6);
		gp.add(txtNumero, 1, 7);

		gp.add(new Label("Bairro"), 0, 8);
		gp.add(txtBairro, 0, 9);

		gp.add(new Label("CEP"), 1, 8);
		gp.add(txtCep, 1, 9);

		btnSalvar.setPrefSize(150, 20);
		gp.add(btnSalvar, 1, 15);

		btnSalvar.setOnAction(this);

		dateField(txtNasc);
		
		loginControl.setLogin(LoginControl.getLoginG());
		clienteControl.setCliente(LoginControl.getCliente());
		vincularCampos();

		BorderPane telaPrincipal = new BorderPane();
		telaPrincipal.setLeft(super.gerarTelaEsq("AlterarCadastro"));
		telaPrincipal.setCenter(gp);
		return telaPrincipal;
	}

	private void vincularCampos() {
		StringConverter<? extends Number> converter = new IntegerStringConverter();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringConverter<LocalDate> dateConverter = new LocalDateStringConverter(dtf, dtf);
		
		Bindings.bindBidirectional(txtSenha.textProperty(), loginControl.getPassProperty());
		Bindings.bindBidirectional(txtCpf.textProperty(), clienteControl.getCpfProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), clienteControl.getNomeProperty());
		Bindings.bindBidirectional(txtSobrenome.textProperty(), clienteControl.getSobrenomeProperty());
		Bindings.bindBidirectional(txtEmail.textProperty(), clienteControl.getEmailProperty());
		Bindings.bindBidirectional(txtEmail.textProperty(), loginControl.getUserProperty());
		Bindings.bindBidirectional(txtLogradouro.textProperty(), clienteControl.getLogradouroProperty());
		Bindings.bindBidirectional(txtNumero.textProperty(), clienteControl.getNumeroProperty(),
				(StringConverter<Number>) converter);
		
		
		Bindings.bindBidirectional(txtNasc.textProperty(), clienteControl.getData_NascProperty(),
				dateConverter);
		
		Bindings.unbindBidirectional(txtNasc.textProperty(), clienteControl.getData_NascProperty());
		
		Bindings.bindBidirectional(txtBairro.textProperty(), clienteControl.getBairroProperty());
		Bindings.bindBidirectional(txtCep.textProperty(), clienteControl.getCepProperty());
		Bindings.bindBidirectional(txtSenha.textProperty(), loginControl.getPassProperty());

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
	public void handle(ActionEvent arg0) {
		try {
			regData();
			clienteControl.atualizar();
			loginControl.atualizar();
			Alert a = new Alert(AlertType.CONFIRMATION, "Cadastro realizado!", ButtonType.OK);
			a.show();
			limparCampos();
		} catch (SQLException e1) {
			Alert a = new Alert(AlertType.ERROR, "Erro ao atualizar o cadastro", ButtonType.OK);
			a.show();
			e1.printStackTrace();
		}
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

}
