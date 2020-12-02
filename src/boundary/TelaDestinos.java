package boundary;

import entity.Compra;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TelaDestinos extends TelaMaeAdm implements SubTela, EventHandler<ActionEvent> {

	TableView<Compra> table = new TableView<>(); 
	
	TableColumn<Compra, String> colID = new TableColumn<>("ID");
    TableColumn<Compra, String> colDestino = new TableColumn<>("Destino");
    TableColumn<Compra, Double> colPreco = new TableColumn<>("Preco");
	
    @Override
    public Pane gerarTela() {
        GridPane gp = new GridPane();

        gp.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE,null,null)));
        
        TextField txtOrigem = new TextField();
        TextField txtDestino = new TextField();
        TextField txtPreco = new TextField();

        Button btnSalvar = new Button("Salvar Destino");
        
        btnSalvar.setOnAction(this);

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(5);

        txtOrigem.setMinWidth(200);

        gp.add(new Label("Destino"), 0, 0);
        gp.add(txtDestino, 0, 1);

        gp.add(new Label("Preco"), 0, 2);
        gp.add(txtPreco, 0, 3);
        

        btnSalvar.setPrefSize(150, 20);
        gp.add(btnSalvar, 0, 8);


        table.setPrefWidth(362);

        table.getColumns().addAll(colID, colDestino, colPreco);

        table.resizeColumn(colID, 10);
        table.resizeColumn(colDestino, 80);
        table.resizeColumn(colPreco, 30);
        colID.setResizable(false);
        colDestino.setResizable(false);
        colPreco.setResizable(false);

        BorderPane telaPrincipal = new BorderPane();

        telaPrincipal.setLeft(super.gerarTelaEsq("TelaDestinos"));
        telaPrincipal.setCenter(gp);
        telaPrincipal.setRight(table);
        
        return telaPrincipal;
    }
    
    private void vincularCampos() {
    	TableColumn<Compra, String> colID = new TableColumn<>("Origem");
        TableColumn<Compra, String> colDestino = new TableColumn<>("Destino");    	
        TableColumn<Compra, Double> colPreco = new TableColumn<>("Preco");

        
//        colOrigem.setCellValueFactory( new PropertyValueFactory<Contato, String> ("Origem"));
//        private int codigo;
//    	private String Destino;
//    	private double preco;
//        
//        colDestino
//    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

	@Override
	public void handle(ActionEvent e) {
		
	}
    
}