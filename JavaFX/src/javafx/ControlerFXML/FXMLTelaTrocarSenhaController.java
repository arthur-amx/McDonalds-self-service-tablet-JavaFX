package javafx.ControlerFXML;

import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.classes.Usuario;
import javafx.event.ActionEvent;
import javafx.excecoes.NomeUsuarioInvalidoException;
import javafx.excecoes.SenhaInvalidaException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;

public class FXMLTelaTrocarSenhaController implements Initializable {

    Usuario u = main.c.pegar();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private PasswordField novaSenha;

    @FXML
    private Button buttonConfirmar;

    @FXML
    void actionConfirmarTrocaSenha(ActionEvent event) throws FontFormatException, IOException, SenhaInvalidaException {
        if (novaSenha.getText().equals("") != true) {
            u.setSenha(novaSenha.getText());
            main.c.atualizar();
            novaSenha.setText("");
            if (u.getSenha() != null) {
                JOptionPane.showMessageDialog(null, "Senha Alterada com sucesso!!!");
            }
        } else {
            throw new SenhaInvalidaException("Erro, senha Inválida!!!");
        }

    }

}
