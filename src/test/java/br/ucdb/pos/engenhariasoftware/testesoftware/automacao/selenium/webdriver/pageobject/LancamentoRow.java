package br.ucdb.pos.engenhariasoftware.testesoftware.automacao.selenium.webdriver.pageobject;

import org.openqa.selenium.WebElement;

public class LancamentoRow {

    private String descricao;
    private String categoria;
    private String dataLancamento;
    private String valor;
    private String tipo;
    private WebElement botoes;

    public LancamentoRow(String descricao, String categoria, String dataLancamento, String valor, String tipo, WebElement botoes) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
        this.tipo = tipo;
        this.botoes = botoes;
    }

    public LancamentoRow() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public WebElement getBotoes() {
        return botoes;
    }

    public void setBotoes(WebElement botoes) {
        this.botoes = botoes;
    }
}
