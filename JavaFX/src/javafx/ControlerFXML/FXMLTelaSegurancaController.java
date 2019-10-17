package javafx.ControlerFXML;

import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.Cadastro;
import javafx.event.ActionEvent;
import javafx.excecoes.NomeUsuarioInvalidoException;
import javafx.excecoes.SenhaInvalidaException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;

public class FXMLTelaSegurancaController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private PasswordField adminSenha;

    @FXML
    private Button buttonConfirmar;

    @FXML
    void actionConfirmarTrocaSenha(ActionEvent event) throws FontFormatException, IOException, NomeUsuarioInvalidoException, SenhaInvalidaException {
        if (adminSenha.getText().equals("") != true) {
            Cadastro c = new Cadastro();
            c.cadastra(adminSenha.getText());
            adminSenha.setText("");

        } else {
            throw new SenhaInvalidaException("Erro, senha Inválida!!!");
        }

    }

}
