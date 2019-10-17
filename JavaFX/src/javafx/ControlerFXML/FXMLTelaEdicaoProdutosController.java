package javafx.ControlerFXML;

import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.classes.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.excecoes.NomeUsuarioInvalidoException;
import javafx.excecoes.PrecoProdutoInvalidoException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLTelaEdicaoProdutosController implements Initializable {

    private List<Produto> List;
    private ObservableList<Produto> obsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTable();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTelaEdicaoProdutosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableProdutos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
    }

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
    private Button buttonAlterar;

    @FXML
    void alteraProduto(ActionEvent event) throws IOException, FontFormatException, PrecoProdutoInvalidoException {
        Produto produto = tableProdutos.getSelectionModel().getSelectedItem();
        if (produto.getPreco().equals("") != true) {
            if (produto != null) {
                String nome, tipo;
                nome = produto.getNome();
                tipo = produto.getTipo();
                boolean buttonAlterarClicked = showFXMLTelaCadastroProduto(produto);
                if (buttonAlterarClicked) {
                    main.c.removerProduto(nome, tipo);
                    try {
                        main.c.cadastraProduto(produto);
                    } catch (NomeUsuarioInvalidoException ex) {
                        Logger.getLogger(FXMLTelaEdicaoProdutosController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    carregarTable();
                    tableProdutos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um Produto da Tabela!!!");
            }
        } else {
            throw new PrecoProdutoInvalidoException("Erro, preço de protudo Inválido!!!");
        }

    }

    public void carregarTable() throws IOException {
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

    public boolean showFXMLTelaCadastroProduto(Produto p) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader
                .setLocation(FXMLTelaEditarProdutoController.class
                        .getResource("/javafx/viewFXML/FXMLTelaEditarProduto.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage
                .getIcons().add(new Image(main.class
                        .getResourceAsStream("/javafx/imgs/icone.png")));

        FXMLTelaEditarProdutoController controller = loader.getController();
        controller.setStage(dialogStage);
        controller.setProduto(p);

        dialogStage.showAndWait();

        return controller.isButtonConfirmarClick();

    }

}
