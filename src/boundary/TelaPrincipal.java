package boundary;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
Tela -
	Cliente - 
		Tela Compra
		Tela Compras anteriores
		Tela Alteração de cadastro
		Tela Passagem
	
	Admin -
		Tela Cadastro de destinos
		Tela Cadastro de viagens
		Tela Cadastro avião

DAO - 
	Dao Destinos
	Dao Viagens
	Dao Avião 
	Dao Cliente 
	
Entidades - 
	Cliente
	Passagem
	Avião
	Tipo_Viagem
	Destino
	Classe
	Compra
	
*/

public class TelaPrincipal extends Application{

	private ControleTelas tControl = ControleTelas.getControleTelas();
	
	private StackPane sp = new StackPane();
	private static BorderPane telaPrincipal = new BorderPane();

	@Override
	public void start(Stage stage) {
		Scene scn = new Scene(sp, 1150, 600);

		tControl.trocarTela("TelaCompra");
		
		Label version = new Label("Version 1.7.89");
		sp.getChildren().addAll(telaPrincipal, version);
		StackPane.setAlignment(version, Pos.BOTTOM_RIGHT);
				
		Image icon = new Image(getClass().getResourceAsStream("/Imagens/logo with love.png"));
		stage.getIcons().add(icon);
		
		stage.setScene(scn);
		stage.setTitle("ATOG - Airplane Travelling With Dogs");
		stage.show();
	}
	
	public static void setTelaPrincipal(BorderPane novaTela) {
		telaPrincipal.setCenter(novaTela);
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal.class, args);
	}
	
}