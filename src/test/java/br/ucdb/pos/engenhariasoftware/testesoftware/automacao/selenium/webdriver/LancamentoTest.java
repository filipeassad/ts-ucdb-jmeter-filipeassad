package br.ucdb.pos.engenhariasoftware.testesoftware.automacao.selenium.webdriver;

import br.ucdb.pos.engenhariasoftware.testesoftware.automacao.selenium.webdriver.pageobject.Categoria;
import br.ucdb.pos.engenhariasoftware.testesoftware.automacao.selenium.webdriver.pageobject.LancamentoPage;
import br.ucdb.pos.engenhariasoftware.testesoftware.automacao.selenium.webdriver.pageobject.ListaLancamentosPage;
import br.ucdb.pos.engenhariasoftware.testesoftware.automacao.selenium.webdriver.pageobject.TipoLancamento;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LancamentoTest {

    private WebDriver driver;
    private ListaLancamentosPage listaLancamentosPage;
    private LancamentoPage lancamentoPage;

    @BeforeClass
    private void inicialliza() {
        boolean windows = System.getProperty("os.name").toUpperCase().contains("WIN");
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/src/test/resources/drivers/" +
                        "/geckodriver" + (windows ? ".exe" : ""));
        driver = new FirefoxDriver();
        listaLancamentosPage = new ListaLancamentosPage(driver);
        lancamentoPage = new LancamentoPage(driver);
    }

    @Test
    public void criaLancamento(){
        listaLancamentosPage.acessa();
        listaLancamentosPage.novoLancamento();

        LocalDateTime dataHora = getDataAleatorios();
        DateTimeFormatter formatoLancamento = DateTimeFormatter.ofPattern("dd.MM.yy");
        final String descricaoLancamento = "Lançando saída automatizada " + dataHora.format(formatoLancamento);
        final BigDecimal valor = getValorLancamento();

        Categoria categoria = lancamentoPage.obterOptionParaSelecionar();
        lancamentoPage.cria(descricaoLancamento, valor, dataHora, TipoLancamento.SAIDA, categoria);

        assertTrue(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, TipoLancamento.SAIDA));
    }

    @Test
    public void fluxo1(){

        listaLancamentosPage.acessa();
        listaLancamentosPage.novoLancamento();

        LocalDateTime dataHora = getDataAleatorios();
        DateTimeFormatter formatoLancamento = DateTimeFormatter.ofPattern("dd.MM.yy");
        TipoLancamento tipoLancamento = getTipoLancamentoAleatorios();
        final String descricaoLancamento = "Lançando saída automatizada " + dataHora.format(formatoLancamento);
        final BigDecimal valor = getValorLancamento();

        Categoria categoria = lancamentoPage.obterOptionParaSelecionar();
        lancamentoPage.cria(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);

        assertTrue(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, tipoLancamento));
    }

    @Test
    public void fluxo2(){

        listaLancamentosPage.acessa();
        listaLancamentosPage.novoLancamento();

        LocalDateTime dataHora = getDataAleatorios();
        DateTimeFormatter formatoLancamento = DateTimeFormatter.ofPattern("dd.MM.yy");
        TipoLancamento tipoLancamento = getTipoLancamentoAleatorios();
        String descricaoLancamento = "Lançando saída automatizada " + dataHora.format(formatoLancamento);
        BigDecimal valor = getValorLancamento();

        Categoria categoria = lancamentoPage.obterOptionParaSelecionar();

        lancamentoPage.cria(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);
        assertTrue(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, tipoLancamento));

        lancamentoPage.acessarEditar(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);

        descricaoLancamento = "Lançamento editado. " + dataHora.format(formatoLancamento);

        lancamentoPage.cria(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);

        assertTrue(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, tipoLancamento));

    }

    @Test
    public void fluxo3(){

        listaLancamentosPage.acessa();
        listaLancamentosPage.novoLancamento();

        LocalDateTime dataHora = getDataAleatorios();
        DateTimeFormatter formatoLancamento = DateTimeFormatter.ofPattern("dd.MM.yy");
        TipoLancamento tipoLancamento = getTipoLancamentoAleatorios();
        String descricaoLancamento = "Lançando saída automatizada " + dataHora.format(formatoLancamento);
        BigDecimal valor = getValorLancamento();

        Categoria categoria = lancamentoPage.obterOptionParaSelecionar();

        lancamentoPage.cria(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);
        assertTrue(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, tipoLancamento));

        lancamentoPage.acessarEditar(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);

        descricaoLancamento = "Lançamento editado. " + dataHora.format(formatoLancamento);

        lancamentoPage.cria(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);
        assertTrue(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, tipoLancamento));

        lancamentoPage.excluirLancamento(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);

        assertFalse(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, tipoLancamento));

    }

    @Test
    public void fluxo4(){

        listaLancamentosPage.acessa();
        listaLancamentosPage.novoLancamento();

        LocalDateTime dataHora = getDataAleatorios();
        DateTimeFormatter formatoLancamento = DateTimeFormatter.ofPattern("dd.MM.yy");
        TipoLancamento tipoLancamento = getTipoLancamentoAleatorios();
        String descricaoLancamento = "Lançando saída automatizada " + dataHora.format(formatoLancamento);
        BigDecimal valor = getValorLancamento();

        Categoria categoria = lancamentoPage.obterOptionParaSelecionar();

        lancamentoPage.cria(descricaoLancamento, valor, dataHora, tipoLancamento, categoria);
        assertTrue(listaLancamentosPage.existeLancamento(descricaoLancamento, valor, dataHora, tipoLancamento));

        HashMap<String, BigDecimal> totaisCalculados = lancamentoPage.calcularTotais();
        HashMap<String, BigDecimal> totaisObtidos = lancamentoPage.totalEntradaSaida();

        boolean totaisEntradaIguais = totaisCalculados.get("total-entrada")
                .compareTo(totaisObtidos.get("total-entrada")) == 0;
        boolean totaisSaidaIguais = totaisCalculados.get("total-saida")
                .compareTo(totaisObtidos.get("total-saida")) == 0;

        assertTrue(totaisEntradaIguais, "Totais de entrada estão diferentes.");
        assertTrue(totaisSaidaIguais , "Totais de saida estão diferentes.");

        lancamentoPage.acessarRelatorios();

        assertTrue(listaLancamentosPage.acessouRelatorio(), "Não conseguiu acessar a tela de relatórios.");

    }

    @Test
    public void fluxo5(){

        listaLancamentosPage.acessa();
        listaLancamentosPage.novoLancamento();

        driver.findElement(By.id("btnSalvar")).click();

        assertTrue(lancamentoPage.validaAlerta(),
                "Não está validando os campos ou está faltando alguma validação.");

        driver.findElement(By.id("cancelar")).click();
        driver.findElement(By.id("recarregar")).click();

    }

    @AfterClass
    private void finaliza(){
        driver.quit();
    }

    private BigDecimal getValorLancamento() {

        boolean  aplicaVariante = (System.currentTimeMillis() % 3) == 0;
        int fator = 10;
        long mim = 30;
        long max = 900;
        if(aplicaVariante){
            mim /= fator;
            max /= fator;
        }
        return new BigDecimal(( 1 + (Math.random() * (max - mim)))).setScale(2, RoundingMode.HALF_DOWN);
    }

    private LocalDateTime getDataAleatorios(){
        LocalDateTime dataHora = LocalDateTime.now();
        Random random = new Random();
        int diaAleatorio = random.nextInt(25) + 1;

        return LocalDateTime.of(dataHora.getYear(), dataHora.getMonth(),diaAleatorio,0,0);
    }

    private TipoLancamento getTipoLancamentoAleatorios(){
        return new Random().nextBoolean() ? TipoLancamento.SAIDA : TipoLancamento.ENTRADA;
    }
    
}


