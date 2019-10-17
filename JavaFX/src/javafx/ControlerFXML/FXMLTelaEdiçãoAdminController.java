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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class FXMLTelaEdiçãoAdminController implements Initializable {
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            load("/javafx/viewFXML/FXMLTelaSeguranca.fxml");
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaEdiçãoAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private AnchorPane borderpane;

    @FXML
    private Button buttonSeguranca;

    @FXML
    private Button buttonDados;

    @FXML
    private ImageView logo;

    @FXML
    private HBox box;

    @FXML
    void actionAbrirTelaEditarProdutos(ActionEvent event) throws IOException {
        load("/javafx/viewFXML/FXMLTelaEdicaoProdutos.fxml");
    }

    @FXML
    void actionAbrirTelaSeguranca(ActionEvent event) throws IOException {
        load("/javafx/viewFXML/FXMLTelaSeguranca.fxml");
    }

    @FXML
    void voltarTela(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaMenuAdmin.fxml");
    }

    private void load(String s) throws IOException {
        box.getChildren().clear();
        box.setAlignment(Pos.CENTER);
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(s));
        box.getChildren().add(root);
    }

}
