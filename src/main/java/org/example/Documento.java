package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Documento {
    public String tipoDoc;
    public String chave;
    public String numero;
    public String serie;

    public String dataEmissao;
    public String tipoServico;
    public Object chaveDocComp;
    public Object chaveDocSub;
    public int tomador;
    public String tipoCte;
    public List<NotaFiscal> notasFiscais;
    public String cnpjEmissor;
    public String nomeEmissor;
    public int ibgeEmissor;
    public String cidadeEmissor;
    public String ufEmissor;
    public String inscricaoEstadualEmissor;
    public String enderecoEmissor;
    public String numeroEmissor;
    public String bairroEmissor;
    public String cepEmissor;
    public String emailEmissor;
    public String telefoneEmissor;
    public String cnpjCpfDestinatario;
    public String inscricaoEstadualDestinatario;
    public String nomeDestinatario;
    public int ibgeDestinatario;
    public String cidadeDestinatario;
    public String ufDestinatario;
    public String cepDestinatario;
    public String enderecoDestinatario;
    public String numeroDestinatario;
    public String bairroDestinatario;
    public Object telefoneDestinatario;
    public String emailDestinatario;
    public String cnpjCpfRementente;
    public String inscricaoEstadualRementente;
    public String nomeRementente;
    public Object nomeFantasiaRemetente;
    public int ibgeRementente;
    public String cidadeRementente;
    public String ufRementente;
    public String cepRementente;
    public String enderecoRementente;
    public String numeroRementente;
    public String bairroRementente;
    public Object telefoneRementente;
    public Object emailRementente;
    public Object cnpjCpfExpedidor;
    public Object inscricaoEstadualExpedidor;
    public Object nomeExpedidor;
    public Object ibgeExpedidor;
    public Object cidadeExpedidor;
    public Object ufExpedidor;
    public Object cepExpedidor;
    public Object enderecoExpedidor;
    public Object numeroExpedidor;
    public Object bairroExpedidor;
    public Object telefoneExpedidor;
    public Object emailExpedidor;
    public Object cnpjCpfToma4;
    public Object nomeToma4;
    public Object cnpjCpfRecebedor;
    public Object inscricaoEstadualRecebedor;
    public Object cidadeRecebedor;
    public Object nomeRecebedor;
    public Object enderecoRecebedor;
    public Object numeroRecebedor;
    public Object bairroRecebedor;
    public Object ufRecebedor;
    public Object emailRecebedor;
    public Object telefoneRecebedor;
    public Object ibgeRecebedor;
    public Object cepRecebedor;
    public int ibgeInicioOperacao;
    public String cidadeInicioOperacao;
    public String ufInicioOperacao;
    public int ibgeFimOperacao;
    public String cidadeFimOperacao;
    public String ufFimOperacao;
    public Object pesoCubado;
    public Object peso;
    public Object volumes;
    public double valorNotas;
    public double freteTransp;
    public Object m3;
    public double valorIcms;
    public double baseCalculoIcms;
    public double aliquotaIcms;
    public Object percRedBaseCalculoIcms;
    public String tipoTributacao;

    public int cfop;
    public String protocoloCte;
    public String dataProtocoloCte;
    public String modal;
    public List<ComponentesValor> componentesValor;
    public List<InfQuantidadeCTe> infQuantidadeCTe;

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Object getChaveDocComp() {
        return chaveDocComp;
    }

    public void setChaveDocComp(Object chaveDocComp) {
        this.chaveDocComp = chaveDocComp;
    }

    public Object getChaveDocSub() {
        return chaveDocSub;
    }

    public void setChaveDocSub(Object chaveDocSub) {
        this.chaveDocSub = chaveDocSub;
    }

    public int getTomador() {
        return tomador;
    }

    public void setTomador(int tomador) {
        this.tomador = tomador;
    }

    public String getTipoCte() {
        return tipoCte;
    }

    public void setTipoCte(String tipoCte) {
        this.tipoCte = tipoCte;
    }

    public List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(List<NotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

    public String getCnpjEmissor() {
        return cnpjEmissor;
    }

    public void setCnpjEmissor(String cnpjEmissor) {
        this.cnpjEmissor = cnpjEmissor;
    }

    public String getNomeEmissor() {
        return nomeEmissor;
    }

    public void setNomeEmissor(String nomeEmissor) {
        this.nomeEmissor = nomeEmissor;
    }

    public int getIbgeEmissor() {
        return ibgeEmissor;
    }

    public void setIbgeEmissor(int ibgeEmissor) {
        this.ibgeEmissor = ibgeEmissor;
    }

    public String getCidadeEmissor() {
        return cidadeEmissor;
    }

    public void setCidadeEmissor(String cidadeEmissor) {
        this.cidadeEmissor = cidadeEmissor;
    }

    public String getUfEmissor() {
        return ufEmissor;
    }

    public void setUfEmissor(String ufEmissor) {
        this.ufEmissor = ufEmissor;
    }

    public String getInscricaoEstadualEmissor() {
        return inscricaoEstadualEmissor;
    }

    public void setInscricaoEstadualEmissor(String inscricaoEstadualEmissor) {
        this.inscricaoEstadualEmissor = inscricaoEstadualEmissor;
    }

    public String getEnderecoEmissor() {
        return enderecoEmissor;
    }

    public void setEnderecoEmissor(String enderecoEmissor) {
        this.enderecoEmissor = enderecoEmissor;
    }

    public String getNumeroEmissor() {
        return numeroEmissor;
    }

    public void setNumeroEmissor(String numeroEmissor) {
        this.numeroEmissor = numeroEmissor;
    }

    public String getBairroEmissor() {
        return bairroEmissor;
    }

    public void setBairroEmissor(String bairroEmissor) {
        this.bairroEmissor = bairroEmissor;
    }

    public String getCepEmissor() {
        return cepEmissor;
    }

    public void setCepEmissor(String cepEmissor) {
        this.cepEmissor = cepEmissor;
    }

    public Object getEmailEmissor() {
        return emailEmissor;
    }

    public void setEmailEmissor(String emailEmissor) {
        this.emailEmissor = emailEmissor;
    }

    public Object getTelefoneEmissor() {
        return telefoneEmissor;
    }

    public void setTelefoneEmissor(String telefoneEmissor) {
        this.telefoneEmissor = telefoneEmissor;
    }

    public String getCnpjCpfDestinatario() {
        return cnpjCpfDestinatario;
    }

    public void setCnpjCpfDestinatario(String cnpjCpfDestinatario) {
        this.cnpjCpfDestinatario = cnpjCpfDestinatario;
    }

    public String getInscricaoEstadualDestinatario() {
        return inscricaoEstadualDestinatario;
    }

    public void setInscricaoEstadualDestinatario(String inscricaoEstadualDestinatario) {
        this.inscricaoEstadualDestinatario = inscricaoEstadualDestinatario;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public int getIbgeDestinatario() {
        return ibgeDestinatario;
    }

    public void setIbgeDestinatario(int ibgeDestinatario) {
        this.ibgeDestinatario = ibgeDestinatario;
    }

    public String getCidadeDestinatario() {
        return cidadeDestinatario;
    }

    public void setCidadeDestinatario(String cidadeDestinatario) {
        this.cidadeDestinatario = cidadeDestinatario;
    }

    public String getUfDestinatario() {
        return ufDestinatario;
    }

    public void setUfDestinatario(String ufDestinatario) {
        this.ufDestinatario = ufDestinatario;
    }

    public String getCepDestinatario() {
        return cepDestinatario;
    }

    public void setCepDestinatario(String cepDestinatario) {
        this.cepDestinatario = cepDestinatario;
    }

    public String getEnderecoDestinatario() {
        return enderecoDestinatario;
    }

    public void setEnderecoDestinatario(String enderecoDestinatario) {
        this.enderecoDestinatario = enderecoDestinatario;
    }

    public String getNumeroDestinatario() {
        return numeroDestinatario;
    }

    public void setNumeroDestinatario(String numeroDestinatario) {
        this.numeroDestinatario = numeroDestinatario;
    }

    public String getBairroDestinatario() {
        return bairroDestinatario;
    }

    public void setBairroDestinatario(String bairroDestinatario) {
        this.bairroDestinatario = bairroDestinatario;
    }

    public Object getTelefoneDestinatario() {
        return telefoneDestinatario;
    }

    public void setTelefoneDestinatario(Object telefoneDestinatario) {
        this.telefoneDestinatario = telefoneDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getCnpjCpfRementente() {
        return cnpjCpfRementente;
    }

    public void setCnpjCpfRementente(String cnpjCpfRementente) {
        this.cnpjCpfRementente = cnpjCpfRementente;
    }

    public String getInscricaoEstadualRementente() {
        return inscricaoEstadualRementente;
    }

    public void setInscricaoEstadualRementente(String inscricaoEstadualRementente) {
        this.inscricaoEstadualRementente = inscricaoEstadualRementente;
    }

    public String getNomeRementente() {
        return nomeRementente;
    }

    public void setNomeRementente(String nomeRementente) {
        this.nomeRementente = nomeRementente;
    }

    public Object getNomeFantasiaRemetente() {
        return nomeFantasiaRemetente;
    }

    public void setNomeFantasiaRemetente(Object nomeFantasiaRemetente) {
        this.nomeFantasiaRemetente = nomeFantasiaRemetente;
    }

    public int getIbgeRementente() {
        return ibgeRementente;
    }

    public void setIbgeRementente(int ibgeRementente) {
        this.ibgeRementente = ibgeRementente;
    }

    public String getCidadeRementente() {
        return cidadeRementente;
    }

    public void setCidadeRementente(String cidadeRementente) {
        this.cidadeRementente = cidadeRementente;
    }

    public String getUfRementente() {
        return ufRementente;
    }

    public void setUfRementente(String ufRementente) {
        this.ufRementente = ufRementente;
    }

    public String getCepRementente() {
        return cepRementente;
    }

    public void setCepRementente(String cepRementente) {
        this.cepRementente = cepRementente;
    }

    public String getEnderecoRementente() {
        return enderecoRementente;
    }

    public void setEnderecoRementente(String enderecoRementente) {
        this.enderecoRementente = enderecoRementente;
    }

    public String getNumeroRementente() {
        return numeroRementente;
    }

    public void setNumeroRementente(String numeroRementente) {
        this.numeroRementente = numeroRementente;
    }

    public String getBairroRementente() {
        return bairroRementente;
    }

    public void setBairroRementente(String bairroRementente) {
        this.bairroRementente = bairroRementente;
    }

    public Object getTelefoneRementente() {
        return telefoneRementente;
    }

    public void setTelefoneRementente(Object telefoneRementente) {
        this.telefoneRementente = telefoneRementente;
    }

    public Object getEmailRementente() {
        return emailRementente;
    }

    public void setEmailRementente(Object emailRementente) {
        this.emailRementente = emailRementente;
    }

    public Object getCnpjCpfExpedidor() {
        return cnpjCpfExpedidor;
    }

    public void setCnpjCpfExpedidor(Object cnpjCpfExpedidor) {
        this.cnpjCpfExpedidor = cnpjCpfExpedidor;
    }

    public Object getInscricaoEstadualExpedidor() {
        return inscricaoEstadualExpedidor;
    }

    public void setInscricaoEstadualExpedidor(Object inscricaoEstadualExpedidor) {
        this.inscricaoEstadualExpedidor = inscricaoEstadualExpedidor;
    }

    public Object getNomeExpedidor() {
        return nomeExpedidor;
    }

    public void setNomeExpedidor(Object nomeExpedidor) {
        this.nomeExpedidor = nomeExpedidor;
    }

    public Object getIbgeExpedidor() {
        return ibgeExpedidor;
    }

    public void setIbgeExpedidor(Object ibgeExpedidor) {
        this.ibgeExpedidor = ibgeExpedidor;
    }

    public Object getCidadeExpedidor() {
        return cidadeExpedidor;
    }

    public void setCidadeExpedidor(Object cidadeExpedidor) {
        this.cidadeExpedidor = cidadeExpedidor;
    }

    public Object getUfExpedidor() {
        return ufExpedidor;
    }

    public void setUfExpedidor(Object ufExpedidor) {
        this.ufExpedidor = ufExpedidor;
    }

    public Object getCepExpedidor() {
        return cepExpedidor;
    }

    public void setCepExpedidor(Object cepExpedidor) {
        this.cepExpedidor = cepExpedidor;
    }

    public Object getEnderecoExpedidor() {
        return enderecoExpedidor;
    }

    public void setEnderecoExpedidor(Object enderecoExpedidor) {
        this.enderecoExpedidor = enderecoExpedidor;
    }

    public Object getNumeroExpedidor() {
        return numeroExpedidor;
    }

    public void setNumeroExpedidor(Object numeroExpedidor) {
        this.numeroExpedidor = numeroExpedidor;
    }

    public Object getBairroExpedidor() {
        return bairroExpedidor;
    }

    public void setBairroExpedidor(Object bairroExpedidor) {
        this.bairroExpedidor = bairroExpedidor;
    }

    public Object getTelefoneExpedidor() {
        return telefoneExpedidor;
    }

    public void setTelefoneExpedidor(Object telefoneExpedidor) {
        this.telefoneExpedidor = telefoneExpedidor;
    }

    public Object getEmailExpedidor() {
        return emailExpedidor;
    }

    public void setEmailExpedidor(Object emailExpedidor) {
        this.emailExpedidor = emailExpedidor;
    }

    public Object getCnpjCpfToma4() {
        return cnpjCpfToma4;
    }

    public void setCnpjCpfToma4(Object cnpjCpfToma4) {
        this.cnpjCpfToma4 = cnpjCpfToma4;
    }

    public Object getNomeToma4() {
        return nomeToma4;
    }

    public void setNomeToma4(Object nomeToma4) {
        this.nomeToma4 = nomeToma4;
    }

    public Object getCnpjCpfRecebedor() {
        return cnpjCpfRecebedor;
    }

    public void setCnpjCpfRecebedor(Object cnpjCpfRecebedor) {
        this.cnpjCpfRecebedor = cnpjCpfRecebedor;
    }

    public Object getInscricaoEstadualRecebedor() {
        return inscricaoEstadualRecebedor;
    }

    public void setInscricaoEstadualRecebedor(Object inscricaoEstadualRecebedor) {
        this.inscricaoEstadualRecebedor = inscricaoEstadualRecebedor;
    }

    public Object getCidadeRecebedor() {
        return cidadeRecebedor;
    }

    public void setCidadeRecebedor(Object cidadeRecebedor) {
        this.cidadeRecebedor = cidadeRecebedor;
    }

    public Object getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(Object nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }

    public Object getEnderecoRecebedor() {
        return enderecoRecebedor;
    }

    public void setEnderecoRecebedor(Object enderecoRecebedor) {
        this.enderecoRecebedor = enderecoRecebedor;
    }

    public Object getNumeroRecebedor() {
        return numeroRecebedor;
    }

    public void setNumeroRecebedor(Object numeroRecebedor) {
        this.numeroRecebedor = numeroRecebedor;
    }

    public Object getBairroRecebedor() {
        return bairroRecebedor;
    }

    public void setBairroRecebedor(Object bairroRecebedor) {
        this.bairroRecebedor = bairroRecebedor;
    }

    public Object getUfRecebedor() {
        return ufRecebedor;
    }

    public void setUfRecebedor(Object ufRecebedor) {
        this.ufRecebedor = ufRecebedor;
    }

    public Object getEmailRecebedor() {
        return emailRecebedor;
    }

    public void setEmailRecebedor(Object emailRecebedor) {
        this.emailRecebedor = emailRecebedor;
    }

    public Object getTelefoneRecebedor() {
        return telefoneRecebedor;
    }

    public void setTelefoneRecebedor(Object telefoneRecebedor) {
        this.telefoneRecebedor = telefoneRecebedor;
    }

    public Object getIbgeRecebedor() {
        return ibgeRecebedor;
    }

    public void setIbgeRecebedor(Object ibgeRecebedor) {
        this.ibgeRecebedor = ibgeRecebedor;
    }

    public Object getCepRecebedor() {
        return cepRecebedor;
    }

    public void setCepRecebedor(Object cepRecebedor) {
        this.cepRecebedor = cepRecebedor;
    }

    public int getIbgeInicioOperacao() {
        return ibgeInicioOperacao;
    }

    public void setIbgeInicioOperacao(int ibgeInicioOperacao) {
        this.ibgeInicioOperacao = ibgeInicioOperacao;
    }

    public String getCidadeInicioOperacao() {
        return cidadeInicioOperacao;
    }

    public void setCidadeInicioOperacao(String cidadeInicioOperacao) {
        this.cidadeInicioOperacao = cidadeInicioOperacao;
    }

    public String getUfInicioOperacao() {
        return ufInicioOperacao;
    }

    public void setUfInicioOperacao(String ufInicioOperacao) {
        this.ufInicioOperacao = ufInicioOperacao;
    }

    public int getIbgeFimOperacao() {
        return ibgeFimOperacao;
    }

    public void setIbgeFimOperacao(int ibgeFimOperacao) {
        this.ibgeFimOperacao = ibgeFimOperacao;
    }

    public String getCidadeFimOperacao() {
        return cidadeFimOperacao;
    }

    public void setCidadeFimOperacao(String cidadeFimOperacao) {
        this.cidadeFimOperacao = cidadeFimOperacao;
    }

    public String getUfFimOperacao() {
        return ufFimOperacao;
    }

    public void setUfFimOperacao(String ufFimOperacao) {
        this.ufFimOperacao = ufFimOperacao;
    }

    public Object getPesoCubado() {
        return pesoCubado;
    }

    public void setPesoCubado(Object pesoCubado) {
        this.pesoCubado = pesoCubado;
    }

    public Object getPeso() {
        return peso;
    }

    public void setPeso(Object peso) {
        this.peso = peso;
    }

    public Object getVolumes() {
        return volumes;
    }

    public void setVolumes(Object volumes) {
        this.volumes = volumes;
    }

    public double getValorNotas() {
        return valorNotas;
    }

    public void setValorNotas(double valorNotas) {
        this.valorNotas = valorNotas;
    }

    public double getFreteTransp() {
        return freteTransp;
    }

    public void setFreteTransp(double freteTransp) {
        this.freteTransp = freteTransp;
    }

    public Object getM3() {
        return m3;
    }

    public void setM3(Object m3) {
        this.m3 = m3;
    }

    public double getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(double valorIcms) {
        this.valorIcms = valorIcms;
    }

    public double getBaseCalculoIcms() {
        return baseCalculoIcms;
    }

    public void setBaseCalculoIcms(double baseCalculoIcms) {
        this.baseCalculoIcms = baseCalculoIcms;
    }

    public double getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(double aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public Object getPercRedBaseCalculoIcms() {
        return percRedBaseCalculoIcms;
    }

    public void setPercRedBaseCalculoIcms(Object percRedBaseCalculoIcms) {
        this.percRedBaseCalculoIcms = percRedBaseCalculoIcms;
    }

    public String getTipoTributacao() {
        return tipoTributacao;
    }

    public void setTipoTributacao(String tipoTributacao) {
        this.tipoTributacao = tipoTributacao;
    }

    public int getCfop() {
        return cfop;
    }

    public void setCfop(int cfop) {
        this.cfop = cfop;
    }

    public String getProtocoloCte() {
        return protocoloCte;
    }

    public void setProtocoloCte(String protocoloCte) {
        this.protocoloCte = protocoloCte;
    }

    public String getDataProtocoloCte() {
        return dataProtocoloCte;
    }

    public void setDataProtocoloCte(String dataProtocoloCte) {this.dataProtocoloCte = dataProtocoloCte;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public List<ComponentesValor> getComponentesValor() {
        return componentesValor;
    }

    public void setComponentesValor(List<ComponentesValor> componentesValor) {
        this.componentesValor = componentesValor;
    }

    public List<InfQuantidadeCTe> getInfQuantidadeCTe() {
        return infQuantidadeCTe;
    }

    public void setInfQuantidadeCTe(List<InfQuantidadeCTe> infQuantidadeCTe) {
        this.infQuantidadeCTe = infQuantidadeCTe;
    }
}

