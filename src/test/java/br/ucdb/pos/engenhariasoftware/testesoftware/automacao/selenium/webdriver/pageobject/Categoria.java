package br.ucdb.pos.engenhariasoftware.testesoftware.automacao.selenium.webdriver.pageobject;

public class Categoria {

    private int posicao;
    private String texto;

    public Categoria() {
    }

    public Categoria(int posicao, String texto) {
        this.posicao = posicao;
        this.texto = texto;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
