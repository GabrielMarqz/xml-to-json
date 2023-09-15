package org.example;

public class ArrayInfQuantidadeCTe {
    public Integer codigoUnidadeMedida;

    public String medida;
    public double quantidade;

//    public InfQuantidadeCTe(Integer codigoUnidadeMedida, String medida, double quantidade) {
//        this.codigoUnidadeMedida = codigoUnidadeMedida;
//        this.medida = medida;
//        this.quantidade = quantidade;
//    }

    public Integer getCodigoUnidadeMedida() {
        return codigoUnidadeMedida;
    }

    public void setCodigoUnidadeMedida(Integer codigoUnidadeMedida) {
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
