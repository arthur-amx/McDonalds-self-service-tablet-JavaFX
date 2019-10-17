package javafx.classes;

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.domain.Phone;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.util.ArrayList;
import javafx.main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PagSeguro {

    private final String EMAIL = "arthur.araujo48@gmail.com";
    private final String PRODUCTION_TOKEN = "368343172BF64BF89DA15ABDE61407BA";
    private final String SANDBOX_TOKEN = "B1243397B9EA497E83FEB8E2C659DA4A";

    String criarPagamento(String quantidadeDeCreditos) {
        try {
            PagSeguroConfig.setSandboxEnvironment();
            PaymentRequest request = new PaymentRequest();
            request.setCurrency(Currency.BRL);
            request.setSender(getSender());

            request.addItem(getItem(quantidadeDeCreditos));

            request.setNotificationURL("https://www.google.com.br");
            request.setRedirectURL("https://www.google.com.br");

            //retorna url da venda
            return request.register(getCredentials());
        } catch (PagSeguroServiceException ex) {
            return ex.getMessage();
        }
    }

    private AccountCredentials getCredentials() throws PagSeguroServiceException {
        return new AccountCredentials(EMAIL, PRODUCTION_TOKEN, SANDBOX_TOKEN);
    }


    /* Essa função retorna um comprador teste */
    private Sender getSender() {
        Sender sender = new Sender();
        sender.setName("Arthur Lalal");
        sender.setEmail("arthur@sandbox.pagseguro.com.br");
        sender.addDocument(DocumentType.CPF, "012.345.678-90");
        sender.setPhone(new Phone("31", "988888888"));
        sender.setBornDate("12/01/1990");
        return sender;
    }

    private Item getItem(String valor) {
        Item item = new Item();
        item.setId("01");
        item.setDescription("ADICIONAR CRÉDITOS");
        item.setQuantity(1);
        double v = Double.parseDouble(valor);
        String a = String.format("%.2f", (v));
        a = a.replace(",", ".");
        item.setAmount(new BigDecimal(a));
        return item;
    }

    public boolean pagar(String quantidadeDeCreditos) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //Abre o navegador com a url da venda
        WebDriver driver = new ChromeDriver();
        driver.get(this.criarPagamento(quantidadeDeCreditos));

        String urlAtual;

        boolean entrar = true;
        boolean pago = false;

        while (entrar) {
            try {
                urlAtual = driver.getCurrentUrl();
            } catch (Exception e) {
                return false;
            }

            if (!urlAtual.contains("pagseguro")) {
                driver.quit();
                main.c.pegar().setSaldo(main.c.pegar().getSaldo() + quantidadeDeCreditos);
                pago = true;
                entrar = false;
            }
        }
        return pago;
    }
}
