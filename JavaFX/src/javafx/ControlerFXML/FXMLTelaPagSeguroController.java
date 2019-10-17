package javafx.ControlerFXML;

import java.io.IOException;
import javafx.classes.PagSeguro;
import javafx.fxml.FXML;
import javafx.main;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLTelaPagSeguroController {

    @FXML
    private ImageView logo;

    @FXML
    private Button buttonPronto;

    @FXML
    private TextField textValor;

    @FXML
    void voltarTela(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaMenuUser.fxml");
    }

    @FXML
    public void abrirPagSeguro() {
        PagSeguro ps = new PagSeguro();

        ps.pagar(textValor.getText());
    }
}
