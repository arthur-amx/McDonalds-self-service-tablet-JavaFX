package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.main;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class FXMLTelaEdicaoUserController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            load("/javafx/viewFXML/FXMLTelaTrocarSenha.fxml");
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaEdicaoUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private Button buttonSeguranca;

    @FXML
    private Button buttonContato;

    @FXML
    private ImageView logo;

    @FXML
    private HBox box;

    @FXML
    void actionAbrirTelaContato(ActionEvent event) throws IOException {
        load("/javafx/viewFXML/FXMLTelaContato.fxml");
    }

    @FXML
    void actionAbrirTelaTrocarSenha(ActionEvent event) throws IOException {
        load("/javafx/viewFXML/FXMLTelaTrocarSenha.fxml");
    }

    @FXML
    void voltarTela(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaMenuUser.fxml");
    }

    private void load(String s) throws IOException {
        box.getChildren().clear();
        box.setAlignment(Pos.CENTER);
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(s));
        box.getChildren().add(root);
    }

}
