package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLTelaInicialController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView IMGadmin;

    @FXML
    private ImageView IMGuser;

    @FXML
    private Label LabelAdmin;

    @FXML
    private Label LabelUser;

    @FXML
    void actionAbrirTelaLoginAdmin(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaLoginAdmin.fxml");
    }

    @FXML
    void actionAbrirTelaLoginUser(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaLoginUser.fxml");
    }

}
