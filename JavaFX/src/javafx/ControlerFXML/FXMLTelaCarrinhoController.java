/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.classes.Pedido;
import javafx.classes.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import static javafx.main.p;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class FXMLTelaCarrinhoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private List<Produto> List;
    private ObservableList<Produto> obsList;
    double valor = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarTable();
        tableProdutos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
    }

    @FXML
    private TableView<Produto> tableProdutos;

    @FXML
    private TableColumn<Produto, String> tableNome;

    @FXML
    private TableColumn<Produto, String> tablePreco;

    @FXML
    private TableColumn<Produto, Integer> tableQtd;

    @FXML
    private ImageView imgProduto;

    @FXML
    private Label nomeProduto;

    @FXML
    private Label tipoProduto;

    @FXML
    private Label precoProduto;

    @FXML
    private Button buttonFinalizar;

    @FXML
    private Button buttonRemover;

    @FXML
    void removerPedido(ActionEvent event) {
        Produto produto = tableProdutos.getSelectionModel().getSelectedItem();
        if (produto != null) {
            for (int i = 0; i < main.p.produtos.size(); i++) {
                if (main.p.produtos.get(i).getNome().equals(produto.getNome())) {
                    if (main.p.produtos.get(i).getQtd() == 1) {
                        main.p.produtos.remove(i);
                        carregarTable();
                        tableProdutos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
                    } else {
                        int qtd = main.p.produtos.get(i).getQtd();
                        qtd--;
                        main.p.produtos.get(i).setQtd(qtd);
                        carregarTable();
                        tableProdutos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um Produto da Tabela!!!");
        }
    }

    @FXML
    void finalizaPedido(ActionEvent event) throws IOException {
        if (main.p.produtos.size() != 0) {
            for (int i = 0; i < main.p.produtos.size(); i++) {
                valor += Double.parseDouble(main.p.produtos.get(i).getPreco()) * main.p.produtos.get(i).getQtd();
                System.out.println(main.p.produtos.get(i).getNome() + " -> " + main.p.produtos.get(i).getQtd() + " no valor de R$" + valor);
            }
            main.p.setValor(valor);
            main.p.setCliente(main.c.pegar());
            main.c.cadastraPedido(p);
            main.exibirTela("/javafx/viewFXML/FXMLTelaFinalizaCompra.fxml");
        } else {
            JOptionPane.showMessageDialog(null, "Pedido vazio!!!");
        }
    }

    public void carregarTable() {
        tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tablePreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableQtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        List = main.c.listarPedido(main.p);

        obsList = FXCollections.observableArrayList(List);
        tableProdutos.setItems(obsList);
    }

    public void selecionarItem(Produto p) {
        if (p != null) {
            nomeProduto.setText(p.getNome());
            precoProduto.setText("R$" + p.getPreco());
            tipoProduto.setText(p.getTipo());
            Image i = new Image(getClass().getResourceAsStream("/javafx/imgs/" + p.getImg()));
            imgProduto.setImage(i);
        } else {
            nomeProduto.setText("");
            precoProduto.setText("");
            tipoProduto.setText("");
            Image i = new Image(getClass().getResourceAsStream("/javafx/imgs/null.png"));
            imgProduto.setImage(i);
        }

    }
}
