package javafx.ControlerFXML;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.classes.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.main;
import static javafx.main.stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLTelaCadastroProdutoController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Stage stage;
    private boolean buttonConfirmarClick = false;
    private Produto produto;

    @FXML
    private TextField nomeNvProduto;

    @FXML
    private TextField precoNvProduto;

    @FXML
    private TextField tipoNvProduto;

    @FXML
    private TextField imgNvProduto;

    @FXML
    private Button buttonConfirmar;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView buttonPasta;

    @FXML
    void pegarImagem(MouseEvent event) {
        FileChooser fc = new FileChooser();
        File sf = fc.showOpenDialog(stage);

        if (sf != null) {
            imgNvProduto.setText(sf.getName());
        }
    }

    @FXML
    void voltarTela(MouseEvent event) {
        stage.close();
    }

    @FXML
    void confirmaCadastro(ActionEvent event) {
        produto.setNome(nomeNvProduto.getText());
        produto.setPreco(precoNvProduto.getText());
        produto.setTipo(tipoNvProduto.getText());
        produto.setImg(imgNvProduto.getText());

        buttonConfirmarClick = true;
        stage.close();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isButtonConfirmarClick() {
        return buttonConfirmarClick;
    }

    public void setButtonConfirmarClick(boolean buttonConfirmarClick) {
        this.buttonConfirmarClick = buttonConfirmarClick;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
