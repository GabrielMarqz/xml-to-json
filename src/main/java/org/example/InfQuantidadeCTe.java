package org.example;

public class InfQuantidadeCTe {
    public String codigoUnidadeMedida;

    public String medida;
    public double quantidade;

//    public InfQuantidadeCTe(String codigoUnidadeMedida, String medida, double quantidade) {
//        this.codigoUnidadeMedida = codigoUnidadeMedida;
//        this.medida = medida;
//        this.quantidade = quantidade;
//    }

    public String getCodigoUnidadeMedida() {
        return codigoUnidadeMedida;
    }

    public void setCodigoUnidadeMedida(String codigoUnidadeMedida) {
        this.codigoUnidadeMedida = codigoUnidadeMedida;
    }
    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
