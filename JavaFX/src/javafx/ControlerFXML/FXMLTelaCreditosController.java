package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.classes.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.main;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLTelaCreditosController implements Initializable {

    Usuario u = main.c.pegar();
    double saldo = Double.parseDouble(u.getSaldo());

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciar();
    }

    @FXML
    private ImageView logo;

    @FXML
    private Label labelPreço;

    @FXML
    private ImageView buttonCartao;

    @FXML
    private ImageView buttonBoleto;

    @FXML
    void voltarTela(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaMenuUser.fxml");
    }

    private void iniciar() {
        labelPreço.setText("R$" + saldo);
    }

    @FXML
    void pagarBoleto(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaAdicionarCreditos.fxml");
    }

    @FXML
    void pagarCartao(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaPagSeguro.fxml");
    }

}
