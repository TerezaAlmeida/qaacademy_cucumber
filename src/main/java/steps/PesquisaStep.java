package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PesquisaPage;

public class PesquisaStep {
    WebDriver driver;
    PesquisaPage pesquisaPage;

    @Dado("que o usuario esta em {string}")
    public void que_o_usuario_esta_em(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }
    @Quando("pesquisa por {string}")
    public void pesquisa_por(String palavraDaPesquisa) {
        pesquisaPage = new PesquisaPage();
        driver.findElement(By.id(pesquisaPage.barraDePesquisa)).sendKeys(palavraDaPesquisa);
        driver.findElement(By.id(pesquisaPage.barraDePesquisa)).sendKeys(Keys.ENTER);
    }
    @Entao("retorna um link relacionado a pesquisa")
    public void retorna_um_link_relacionado_a_pesquisa() {
        driver.findElement(By.xpath(pesquisaPage.linkPesquisa)).isDisplayed();
    }
}


