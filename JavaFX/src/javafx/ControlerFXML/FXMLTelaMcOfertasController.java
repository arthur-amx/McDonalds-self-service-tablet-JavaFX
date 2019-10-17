/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.ControlerFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.classes.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class FXMLTelaMcOfertasController implements Initializable {

    ArrayList<Produto> pedido = main.p.produtos;
    double valor;
    int cont;
    private List<Produto> List;
    private ObservableList<Produto> obsList;

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
    private TableColumn<Produto, String> tableTipo;

    @FXML
    private ImageView imgProduto;

    @FXML
    private Button buttonAdicionar;

    @FXML
    void actionAdiciona(ActionEvent event) {
        Produto produto = tableProdutos.getSelectionModel().getSelectedItem();
        if (produto != null) {
            cont = produto.getQtd();
            for (int i = 0; i < pedido.size(); i++) {
                if (pedido.get(i).getNome().equals(produto.getNome())) {
                    cont = pedido.get(i).getQtd();
                    pedido.remove(i);
                    cont++;
                }
            }
            if (cont == 0) {
                cont++;
            }
            produto.setQtd(cont);
            pedido.add(produto);
            JOptionPane.showMessageDialog(null, produto.getNome() + " adicionado ao carrinho!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um Produto da Tabela!!!");
        }

    }

    public void carregarTable() {
        tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tablePreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        List = main.c.listar();

        obsList = FXCollections.observableArrayList(List);
        tableProdutos.setItems(obsList);
    }

    public void selecionarItem(Produto p) {
        if (p != null) {
            Image i = new Image(getClass().getResourceAsStream("/javafx/imgs/" + p.getImg()));
            imgProduto.setImage(i);
        } else {
            Image i = new Image(getClass().getResourceAsStream("/javafx/imgs/null.png"));
            imgProduto.setImage(i);
        }

    }

}
