package javafx.ControlerFXML;

import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.Cadastro;
import javafx.event.ActionEvent;
import javafx.excecoes.NomeUsuarioInvalidoException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class FXMLTelaCadastroController implements Initializable {

    @FXML
    private PasswordField usuarioSenha;

    @FXML
    private TextField usuarioNome;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private ImageView logo;

    @FXML
    void VoltarPage(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaInicial.fxml");
    }

    @FXML
    void actionAbrirTelaMenuUser(ActionEvent event) throws IOException, FontFormatException, NomeUsuarioInvalidoException {
        Cadastro c = new Cadastro();
        if (c.verifica(usuarioNome.getText(), usuarioSenha.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Erro, usuario já cadastrado!!!");
            usuarioSenha.setText("");
            usuarioNome.setText("");
        } else {
            try {
                c.cadastra(usuarioNome.getText(), usuarioSenha.getText());
                c.setar(c.retorno(usuarioNome.getText(), usuarioSenha.getText()));
                main.exibirTela("/javafx/viewFXML/FXMLTelaMenuUser.fxml");
            } catch (NomeUsuarioInvalidoException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
