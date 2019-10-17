package javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.classes.Admin;
import javafx.classes.Pedido;
import javafx.fxml.FXMLLoader;
import static javafx.main.stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application {

    public static Stage stage;
    public static Admin a = new Admin();
    public static Cadastro c = new Cadastro();
    public static Pedido p = new Pedido();

    @Override
    public void start(Stage stage) throws Exception {
        main.stage = stage;

        ManipularArquivo.lerSenha();
        ManipularArquivo.lerUsuario();
        ManipularArquivo.lerProduto();
        exibirTela("viewFXML/FXMLTelaInicial.fxml");

    }

    public static void exibirTela(String link) throws IOException {
        Class cls = main.class;
        Parent root = FXMLLoader.load(cls.getResource(link));

        Scene scene = new Scene(root);

        stage.getIcons().add(new Image(main.class.getResourceAsStream("imgs/icone.png")));
        stage.close();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
