/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.ControlerFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.classes.JavaMailApp;
import javafx.event.ActionEvent;
import javafx.excecoes.EmailException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class FXMLTelaContatoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private TextField labelEmail;

    @FXML
    private Button buttonEnviar;

    @FXML
    private TextArea labelMensagem;

    @FXML
    private PasswordField labelSenha;

    @FXML
    void actionEnviarEmail(ActionEvent event) throws EmailException {
        if (labelEmail.getText().equals("") != true) {
            JavaMailApp email = new JavaMailApp();
            email.setAssunto("Contato de " + main.c.pegar().getNome());
            email.setMsg(labelMensagem.getText());
            email.setPwd(labelSenha.getText());
            email.setSender(labelEmail.getText());

            email.enviar();

            labelEmail.setText("");
            labelMensagem.setText("");
            labelSenha.setText("");
        } else {
            throw new EmailException("Erro, email inválido!!!");
        }
    }
}
