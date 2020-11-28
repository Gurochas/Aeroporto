package boundary;

import java.util.Date;

import entity.Compra;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TelaDestinos extends TelaMaeAdm implements SubTela {

    @Override
    public Pane gerarTela() {
        GridPane gp = new GridPane();

        TextField txtOrigem = new TextField();
        TextField txtDestino = new TextField();


        Button btnSalvar = new Button("Salvar Destino");

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(5);

        txtOrigem.setMinWidth(200);

        gp.add(new Label("Origem"), 0, 0);
        gp.add(txtOrigem, 0, 1);

        gp.add(new Label("Destino"), 0, 2);
        gp.add(txtDestino, 0, 3);

        btnSalvar.setPrefSize(150, 20);
        gp.add(btnSalvar, 0, 8);

        TableView<Compra> table = new TableView<>(); 

        table.setPrefWidth(362);

        TableColumn<Compra, String> colOrigem = new TableColumn<>("Origem");
        TableColumn<Compra, String> colDestino = new TableColumn<>("Destino");

        table.getColumns().addAll(colOrigem, colDestino);

        table.resizeColumn(colDestino, 100);
        table.resizeColumn(colOrigem, 100);
        colDestino.setResizable(false);
        colOrigem.setResizable(false);

        BorderPane telaPrincipal = new BorderPane();

        telaPrincipal.setLeft(super.gerarTelaEsq("TelaDestinos"));
        telaPrincipal.setCenter(gp);
        telaPrincipal.setRight(table);
        return telaPrincipal;
    }

}