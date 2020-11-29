package boundary;

import javafx.scene.layout.BorderPane;

public class ControleTelas {
	
	private static ControleTelas instancia = null;
	
	private BorderPane telaPrincipal = new BorderPane();
	
	
	//Telas Secundarias
	private TelaCadastro tCadastro = new TelaCadastro();
	private TelaLogin tLogin = new TelaLogin();
	private TelaCompra tCompra = new TelaCompra();
	private TelaComprasAnteriores tComprasAnteriores = new TelaComprasAnteriores();
	private TelaAlterarCadastro tAlterarCadastro = new TelaAlterarCadastro();
	private TelaAviao tAviao = new TelaAviao();
	private TelaViagens tViagens = new TelaViagens();
	private TelaDestinos tDestinos = new TelaDestinos();
	
	public void trocarTela(String cmd) {
		
		if (cmd.equals("TelaCadastro")) {
			telaPrincipal =  (BorderPane) tCadastro.gerarTela();
			
		}else if (cmd.equals("TelaLogin")) {
			telaPrincipal =  (BorderPane) tLogin.gerarTela();
			
		}else if(cmd.equals("TelaAlterarCadastro")) {
			telaPrincipal = (BorderPane) tAlterarCadastro.gerarTela();
			
		}else if(cmd.equals("TelaCompra")) {
			telaPrincipal = (BorderPane) tCompra.gerarTela();
			
		}else if(cmd.equals("TelaComprasAnteriores")) {
			telaPrincipal = (BorderPane) tComprasAnteriores.gerarTela();
		
		}else if(cmd.equals("TelaAviao")) {
			telaPrincipal = (BorderPane) tAviao.gerarTela();
		
		}else if(cmd.equals("TelaViagens")) {
			telaPrincipal = (BorderPane) tViagens.gerarTela();
		
		}else if(cmd.equals("TelaDestinos")) {
			telaPrincipal = (BorderPane) tDestinos.gerarTela();
		}
		
		TelaPrincipal.setTelaPrincipal(telaPrincipal);
	}
	
	public static ControleTelas getControleTelas() {
		if (instancia == null) {
			instancia = new ControleTelas();
		}
		return instancia;
	}

	private ControleTelas () {
	}
	
}
