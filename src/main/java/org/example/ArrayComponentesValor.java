package org.example;

public class ArrayComponentesValor {

    public ArrayComponentesValor() {
    }

    public ArrayComponentesValor(String campo, double valor) {
        this.campo = campo;
        this.valor = valor;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String campo;
    public double valor;
}
