package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.Cadastro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class FXMLTelaLoginAdminController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private PasswordField adminSenha;

    @FXML
    private ImageView logo;

    @FXML
    private Button buttonAcessar;

    @FXML
    void VoltarPage(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaInicial.fxml");
    }

    @FXML
    void acessarAdmin(ActionEvent event) throws IOException {
        Cadastro c = new Cadastro();
        if (c.verifica(adminSenha.getText()) == true) {
            main.exibirTela("/javafx/viewFXML/FXMLTelaMenuAdmin.fxml");
        } else {
            JOptionPane.showMessageDialog(null, "Erro, senha incorreta!!!");
            adminSenha.setText("");
        }
    }

}
