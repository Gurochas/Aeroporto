package boundary;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TelaMaeCliente {
	
	private static TelaControle tControle = TelaControle.getTelaControle();
	
    public Pane gerarTelaEsq(String tela) {
    	VBox vb = new VBox ();

        Image imagee = new Image(getClass().getResourceAsStream("/Imagens/logo poo.png"));
        ImageView logo = new ImageView(imagee);
        logo.setFitHeight(100);
        logo.setFitWidth(300);
        vb.getChildren().add(logo);
        
        vb.setPadding(new Insets(30, 0, 0, 0));
        
        vb.setBackground(new Background(new BackgroundFill( Color.ALICEBLUE,null,null)));     
        
        Image imgCompra = new Image(getClass().getResourceAsStream("/Botoes/comprinha.jpg"));
        Image imgClickedCompra = new Image(getClass().getResourceAsStream("/Botoes/comprar cliquinho.jpg"));
        ImageView imgvCompra = new ImageView(imgCompra);
        
        Image imgCompHistorico = new Image(getClass().getResourceAsStream("/Botoes/historico.jpg"));
        Image imgClickedHistorico = new Image(getClass().getResourceAsStream("/Botoes/historico clicado.jpg"));
        ImageView imgvCompHistorico = new ImageView(imgCompHistorico);
        
        Image imgAltCad = new Image(getClass().getResourceAsStream("/Botoes/cadastro.jpg"));
        Image imgClickedAltCad  = new Image(getClass().getResourceAsStream("/Botoes/cadastro clicado.jpg"));
        ImageView imgvAltCad = new ImageView(imgAltCad);
        
        Image imgSair = new Image(getClass().getResourceAsStream("/Botoes/sair.jpg"));
        ImageView imgvSair = new ImageView(imgSair);
        
        
        if (tela.equals("Compra")) {
        	botaoSelecionado(imgvCompra,imgClickedCompra);
        }else if (tela.equals("ComprasAnteriores")) {
    		botaoSelecionado(imgvCompHistorico, imgClickedHistorico);
    	}else if (tela.equals("AlterarCadastro")) {
    		botaoSelecionado(imgvAltCad, imgClickedAltCad);
    	}
        
        imgvCompra.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaCompra");
        });
        
        imgvCompHistorico.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaComprasAnteriores");
        });
        
        imgvAltCad.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaAlterarCadastro");
        });
        
        imgvSair.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaLogin");
        });
        	
        vb.getChildren().addAll(imgvCompra, imgvCompHistorico, imgvAltCad, imgvSair);

        return vb;
    }
    
    public void botaoSelecionado(ImageView im, Image nova) {
    	im.setImage(nova);
    }

}