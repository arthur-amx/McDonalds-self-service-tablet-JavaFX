/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class FXMLTelaFinalizaCompraController implements Initializable {

    Random gerador = new Random();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private ImageView buttonDinheiro;

    @FXML
    private ImageView buttonCreditos;

    @FXML
    private ImageView logo;

    @FXML
    void voltaTela(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FxmlTelaCarrinho.fxml");
    }

    @FXML
    void actionPagarCreditos(MouseEvent event) throws IOException {
        String saldo = main.c.pegar().getSaldo();
        double s = Double.parseDouble(saldo);
        double valor = main.p.getValor();
        if (s >= valor) {
            s = s - valor;
            String saldoAtual = Double.toString(s);
            main.c.pegar().setSaldo(saldoAtual);
            main.c.atualizar();
            String msg = main.c.pegar().getNome() + " seu pedido esta sendo preparado\n";
            int senha = gerador.nextInt(99);
            JOptionPane.showMessageDialog(null, msg + "Senha: " + senha);
            main.p.produtos.clear();
            main.p.setValor(0);
            main.exibirTela("/javafx/viewFXML/FXMLTelaMenuUser.fxml");
        } else {
            String msg = main.c.pegar().getNome() + " seu saldo é insuficiente para realizar a compra\n";
            JOptionPane.showMessageDialog(null, msg + "Saldo: " + saldo);
        }
    }

    @FXML
    void actionPagarDinheiro(MouseEvent event) throws IOException {
        String msg = main.c.pegar().getNome() + " seu pedido esta sendo preparado\n";
        int senha = gerador.nextInt(99);
        main.p.produtos.clear();
        main.p.setValor(0);
        JOptionPane.showMessageDialog(null, msg + "Senha: " + senha);
        main.exibirTela("/javafx/viewFXML/FXMLTelaMenuUser.fxml");
    }

}
