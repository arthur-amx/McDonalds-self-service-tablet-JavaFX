package javafx.ControlerFXML;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.classes.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class FXMLTelaVisuAdminController implements Initializable {

    private List<Produto> List;
    private ObservableList<Produto> obsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarTable();
        tableProdutos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
    }

    @FXML
    private AnchorPane borderpane;

    @FXML
    private ImageView logo;

    @FXML
    private HBox box;

    @FXML
    private TableView<Produto> tableProdutos;

    @FXML
    private TableColumn<Produto, String> tableNome;

    @FXML
    private TableColumn<Produto, String> tablePreco;

    @FXML
    private ImageView imgProduto;

    @FXML
    private Label nomeProduto;

    @FXML
    private Label tipoProduto;

    @FXML
    private Label precoProduto;

    @FXML
    void voltarTela(MouseEvent event) throws IOException {
        main.exibirTela("/javafx/viewFXML/FXMLTelaMenuAdmin.fxml");
    }

    public void carregarTable() {
        tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tablePreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        List = main.c.listar();

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
