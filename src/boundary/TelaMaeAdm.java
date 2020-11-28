package boundary;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TelaMaeAdm {
	
	private static TelaControle tControle = TelaControle.getTelaControle();
	
	public Pane gerarTelaEsq(String tela) {
    	VBox vb = new VBox ();

        Image imagee = new Image(getClass().getResourceAsStream("/Imagens/logo poo.png"));
        ImageView logo = new ImageView(imagee);
        logo.setFitHeight(100);
        logo.setFitWidth(300);
        vb.getChildren().add(logo);
        
        vb.setPadding(new Insets(30, 0, 0, 0));
        
        vb.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,null,null)));     
        
        Image imgDestino = new Image(getClass().getResourceAsStream("/Botoes/destino.jpg"));
        Image imgClickedDestino = new Image(getClass().getResourceAsStream("/Botoes/destino clicao.jpg"));
        ImageView imgvViagem = new ImageView(imgDestino);
        
        Image imgViagem = new Image(getClass().getResourceAsStream("/Botoes/viagem.jpg"));
        Image imgClickedViagem = new Image(getClass().getResourceAsStream("/Botoes/viagem clicao.jpg"));
        ImageView imgvCompViagem = new ImageView(imgViagem);
        
        Image imgAviao = new Image(getClass().getResourceAsStream("/Botoes/aviao.jpg"));
        Image imgClickedAviao  = new Image(getClass().getResourceAsStream("/Botoes/aviao clicao.jpg"));
        ImageView imgvAviao = new ImageView(imgAviao);
        
        Image imgSair = new Image(getClass().getResourceAsStream("/Botoes/sair.jpg"));
        ImageView imgvSair = new ImageView(imgSair);
        
        
        if (tela.equals("Destinos")) {
        	botaoSelecionado(imgvViagem,imgClickedDestino);
        }else if (tela.equals("Viagens")) {
    		botaoSelecionado(imgvCompViagem, imgClickedViagem);
    	}else if (tela.equals("Avião")) {
    		botaoSelecionado(imgvAviao, imgClickedAviao);
    	}
        
        imgvViagem.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaDestinos");
        });
        
        imgvCompViagem.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaViagens");
        });
        
        imgvAviao.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaAvião");
        });
        
        imgvSair.setOnMouseClicked((e) -> {
        	tControle.trocarTela("TelaLogin");
        });
        	
        vb.getChildren().addAll(imgvViagem, imgvCompViagem, imgvAviao, imgvSair);

        return vb;
    }
    
    public void botaoSelecionado(ImageView im, Image nova) {
    	im.setImage(nova);
    }

	

}
