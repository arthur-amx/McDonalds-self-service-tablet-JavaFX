package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.Cadastro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLTelaMenuUserController implements Initializable {

    @FXML
    private ImageView IMGloja;

    @FXML
    private ImageView IMGcredito;

    @FXML
    private ImageView IMGedicao;

    @FXML
    private ImageView logo;

    @FXML
    void VoltarPage(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaInicial.fxml");
    }

    @FXML
    void actionAbrirTelaCreditos(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaCreditos.fxml");
    }

    @FXML
    void actionAbrirTelaEdicaoLoja(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaCompras.fxml");
    }

    @FXML
    void actionAbrirTelaEdicaoUser(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaEdicaoUser.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
