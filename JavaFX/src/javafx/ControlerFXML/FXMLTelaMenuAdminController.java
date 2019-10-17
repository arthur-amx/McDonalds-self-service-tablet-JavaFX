package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLTelaMenuAdminController implements Initializable {

    @FXML
    private ImageView IMGcadastrar;

    @FXML
    private ImageView IMGvisualizar;

    @FXML
    private ImageView IMGedicao;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView IMGexcluir;

    @FXML
    void actionAbrirTelaEdicaoAdmin(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaEdiçãoAdmin.fxml");
    }

    @FXML
    void actionAbrirTelaCadastrarAdmin(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaCadastrarAdmin.fxml");
    }

    @FXML
    void actionAbrirTelaExcluirAdmin(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaExcluirAdmin.fxml");
    }

    @FXML
    void actionAbrirTelaVisuAdmin(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaVisuAdmin.fxml");
    }

    @FXML
    void voltarTela(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaInicial.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
