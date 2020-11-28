package boundary;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaMaeDog {

	public ImageView gerarTelaEsq() {
		// Imagem viajando com cachorro
		Image image = new Image(getClass().getResourceAsStream("/Imagens/viajar-de-aviao-com-cachorro.png"));
		ImageView imgv = new ImageView(image);
		imgv.setFitHeight(600);
		imgv.setFitWidth(800);
		
		return imgv;
	}

}
