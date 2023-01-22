package org.example;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        lerXML();

    }

    private static void lerXML() throws Exception {
        File fXmlFile = new File("C:\\CTe-41221085393783000254570010000113651000085803.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        Documento documento = new Documento();

        lerElementosInfCte(doc, documento);
        Gson gson = new Gson();

        System.out.println(gson.toJson(documento));

        // Criando método para ler classe infquantidadeCTE

        InfQuantidadeCTe infQuantidadeCTe = new InfQuantidadeCTe();

        lerInfQuantidadeCTe(doc, infQuantidadeCTe);
        Gson gson2 = new Gson();

        System.out.println(gson2.toJson(infQuantidadeCTe));

        // Criando método para ler classe Componentesvalor

        ComponentesValor componentesValor = new ComponentesValor();

        lerComponentesValor(doc, documento);
        Gson gson3 = new Gson();

        System.out.println(gson3.toJson(documento.getComponentesValor()));

        // Criando método para ler classe NotasFiscais

        NotasFiscais notasFiscais =  new NotasFiscais();

        lerNotasFiscais(doc, notasFiscais);
        Gson gson4 = new Gson();

        System.out.println(gson4.toJson(notasFiscais));

    }

    //                                 precisa ver como adicionar os outros valores
    private static void lerComponentesValor(Document doc, Documento documento) {
        System.out.println("\n####Imprimindo informações extraídas da classe ComponentesValor:####\n");
//        NodeList vPrest = doc.getElementsByTagName("vPrest");
//        lerElementosVPrest(vPrest, componentesValor);

        NodeList comp = doc.getElementsByTagName("Comp");
        lerElementosComp(comp,documento);
    }

    private static void lerInfQuantidadeCTe(Document doc, InfQuantidadeCTe infQuantidadeCTe) {
        System.out.println("\n####Imprimindo informações extraídas da classe InfQuantidadeCTe:####\n");
        NodeList infQ = doc.getElementsByTagName("infQ");
        lerElementosInfQ(infQ, infQuantidadeCTe);
    }

    private static void lerNotasFiscais (Document doc, NotasFiscais notasFiscais)   {
        System.out.println("\n####Imprimindo informações extraídas da classe NotasFiscais:####\n");
        NodeList infNFe = doc.getElementsByTagName("infNFe");
        lerElementosInfNFe(infNFe, notasFiscais);
    }

    private static void lerElementosInfCte(Document doc, Documento root) {
        System.out.println("\n####Imprimindo informações extraídas da classe Documento:####\n");
        NodeList ides = doc.getElementsByTagName("ide");
        lerElementosIde(ides, root);
        NodeList emits = doc.getElementsByTagName("emit");
        lerElementosEmit(emits, root);
        NodeList dest = doc.getElementsByTagName("dest");
        lerElementosDest(dest, root);
        NodeList rem = doc.getElementsByTagName("rem");
        lerElementosRem(rem, root);
        NodeList toma3 = doc.getElementsByTagName("toma3");
        lerElementosToma3(toma3, root);
        NodeList infCarga = doc.getElementsByTagName("infCarga");
        lerElementosInfCarga(infCarga, root);
        NodeList ICMS = doc.getElementsByTagName("ICMS");
        lerElementosICMS(ICMS, root);
        NodeList vPrest = doc.getElementsByTagName("vPrest");
        lerElementosVTPrest(vPrest, root);
        NodeList enderEmit = doc.getElementsByTagName("enderEmit");
        lerElementosEnderEmit(enderEmit, root);
        NodeList enderDest = doc.getElementsByTagName("enderDest");
        lerElementosEnderDest(enderDest, root);
        NodeList enderReme = doc.getElementsByTagName("enderReme");
        lerElementosEnderReme(enderReme, root);
        NodeList protCTe = doc.getElementsByTagName("protCTe");
        lerElementosProtCTe(protCTe, root);


    }

    private static void lerElementosIde(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noIde = elementos.item(temp);
            if (noIde.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noIde;
                documento.setNumero(eElement.getElementsByTagName("nCT").item(temp).getTextContent());
                documento.setSerie(eElement.getElementsByTagName("cCT").item(temp).getTextContent());
                documento.setTipoServico(eElement.getElementsByTagName("tpServ").item(temp).getTextContent());
                documento.setDataEmissao(Date.from(Instant.parse(eElement.getElementsByTagName("dhEmi").item(temp).getTextContent())));
                documento.setTipoCte(eElement.getElementsByTagName("tpCTe").item(temp).getTextContent());
                documento.setIbgeInicioOperacao(Integer.parseInt(eElement.getElementsByTagName("cMunIni").item(temp).getTextContent()));
                documento.setCidadeInicioOperacao(eElement.getElementsByTagName("xMunIni").item(temp).getTextContent());
                documento.setUfInicioOperacao(eElement.getElementsByTagName("UFIni").item(temp).getTextContent());
                documento.setIbgeFimOperacao(Integer.parseInt(eElement.getElementsByTagName("cMunFim").item(temp).getTextContent()));
                documento.setCidadeFimOperacao(eElement.getElementsByTagName("xMunFim").item(temp).getTextContent());
                documento.setUfFimOperacao(eElement.getElementsByTagName("UFFim").item(temp).getTextContent());
                documento.setCfop(Integer.parseInt(eElement.getElementsByTagName("CFOP").item(temp).getTextContent()));
                documento.setModal(eElement.getElementsByTagName("modal").item(temp).getTextContent());

            }
        }
    }


    private static void lerElementosEmit(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noEmit = elementos.item(temp);
            if (noEmit.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noEmit;
                documento.setCnpjEmissor(eElement.getElementsByTagName("CNPJ").item(temp).getTextContent());
                documento.setNomeEmissor(eElement.getElementsByTagName("xNome").item(temp).getTextContent());
                documento.setInscricaoEstadualEmissor(eElement.getElementsByTagName("IE").item(temp).getTextContent());
            }
        }
    }
    private static void lerElementosDest(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noDest = elementos.item(temp);
            if (noDest.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noDest;
                documento.setCnpjCpfDestinatario(eElement.getElementsByTagName("CNPJ").item(temp).getTextContent());
                documento.setNomeDestinatario(eElement.getElementsByTagName("xNome").item(temp).getTextContent());
                documento.setInscricaoEstadualDestinatario(eElement.getElementsByTagName("IE").item(temp).getTextContent());
            }
        }
    }
    private static void lerElementosRem(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noRem = elementos.item(temp);
            if (noRem.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noRem;
                documento.setCnpjCpfRementente(eElement.getElementsByTagName("CNPJ").item(temp).getTextContent());
                documento.setNomeRementente(eElement.getElementsByTagName("xNome").item(temp).getTextContent());
                documento.setInscricaoEstadualRementente(eElement.getElementsByTagName("IE").item(temp).getTextContent());
            }
        }
    }

    private static void lerElementosToma3(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noToma3 = elementos.item(temp);
            if (noToma3.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noToma3;
                documento.setTomador(Integer.parseInt(eElement.getElementsByTagName("toma").item(temp).getTextContent()));

            }
        }
    }

    private static void lerElementosProtCTe(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noProtCTe = elementos.item(temp);
            if (noProtCTe.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noProtCTe;
                documento.setTipoDoc("cte"); //Como vai ser sempre CTE..
               documento.setChave(eElement.getElementsByTagName("chCTe").item(temp).getTextContent());
               documento.setProtocoloCte(eElement.getElementsByTagName("nProt").item(temp).getTextContent());
               documento.setDataProtocoloCte(Date.from(Instant.parse(eElement.getElementsByTagName("dhRecbto").item(temp).getTextContent())));

            }
        }
    }

    private static void lerElementosInfCarga(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noInfCarga = elementos.item(temp);
            if (noInfCarga.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noInfCarga;
                documento.setValorNotas(Double.parseDouble(eElement.getElementsByTagName("vCarga").item(temp).getTextContent()));
            }
        }
    }

    private static void lerElementosVPrest(NodeList elementos, ComponentesValor documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVPrest = elementos.item(temp);
            if (noVPrest.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noVPrest;
               documento.setCampo(eElement.getElementsByTagName("xNome").item(temp).getTextContent());
               documento.setValor(Double.parseDouble(eElement.getElementsByTagName("vComp").item(temp).getTextContent()));

            }
        }
    }
    private static void lerElementosComp(NodeList elementos, Documento documento) {
        List<ComponentesValor> componentesValors = new ArrayList<>();
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVPrest = elementos.item(temp);
            if (noVPrest.getNodeType() == Node.ELEMENT_NODE) {
                ComponentesValor componentesValor = new ComponentesValor();
                Element eElement = (Element) noVPrest;
                componentesValor.setCampo(eElement.getElementsByTagName("xNome").item(0).getTextContent());
                componentesValor.setValor(Double.parseDouble(eElement.getElementsByTagName("vComp").item(0).getTextContent()));
                componentesValors.add(componentesValor);
            }
        }
        documento.setComponentesValor(componentesValors);
    }

    private static void lerElementosVTPrest(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVTPrest = elementos.item(temp);
            if (noVTPrest.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noVTPrest;
                documento.setFreteTransp(Double.parseDouble(eElement.getElementsByTagName("vTPrest").item(temp).getTextContent()));
            }
        }
    }

    private static void lerElementosICMS(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noICMS = elementos.item(temp);
            if (noICMS.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noICMS;
                documento.setValorIcms(Double.parseDouble(eElement.getElementsByTagName("vICMS").item(temp).getTextContent()));
                documento.setBaseCalculoIcms(Double.parseDouble(eElement.getElementsByTagName("vBC").item(temp).getTextContent()));
                documento.setAliquotaIcms(Double.parseDouble(eElement.getElementsByTagName("pICMS").item(temp).getTextContent()));
                documento.setTipoTributacao(eElement.getElementsByTagName("CST").item(temp).getTextContent());
            }
        }
    }

    private static void lerElementosInfQ(NodeList elementos, InfQuantidadeCTe documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noInfQ = elementos.item(temp);
            if (noInfQ.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noInfQ;
                documento.setCodigoUnidadeMedida(eElement.getElementsByTagName("cUnid").item(temp).getTextContent());
                documento.setMedida(eElement.getElementsByTagName("tpMed").item(temp).getTextContent());
                documento.setQuantidade(Double.parseDouble(eElement.getElementsByTagName("qCarga").item(temp).getTextContent()));

            }
        }
    }

    private static void lerElementosInfNFe (NodeList elementos, NotasFiscais documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noInfNFe = elementos.item(temp);
            if (noInfNFe.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noInfNFe;
                documento.setChave(eElement.getElementsByTagName("chave").item(temp).getTextContent());
                documento.setNumero(Integer.parseInt(eElement.getElementsByTagName("chave").item(temp).getTextContent().substring(25, 34)));
                documento.setSerie(Integer.parseInt(eElement.getElementsByTagName("chave").item(temp).getTextContent().substring(22, 25)));
                documento.setCnpjEmissor(eElement.getElementsByTagName("chave").item(temp).getTextContent().substring(6, 20));

            }
        }
    }

    private static void lerElementosEnderEmit(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noEnderEmit = elementos.item(temp);
            if (noEnderEmit.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noEnderEmit;
                documento.setIbgeEmissor(Integer.parseInt(eElement.getElementsByTagName("cMun").item(temp).getTextContent()));
                documento.setCidadeEmissor(eElement.getElementsByTagName("xMun").item(temp).getTextContent());
                documento.setUfEmissor(eElement.getElementsByTagName("UF").item(temp).getTextContent());
                documento.setEnderecoEmissor(eElement.getElementsByTagName("xLgr").item(temp).getTextContent());
                documento.setNumeroEmissor(eElement.getElementsByTagName("nro").item(temp).getTextContent());
                documento.setBairroEmissor(eElement.getElementsByTagName("xBairro").item(temp).getTextContent());
                documento.setCepEmissor(eElement.getElementsByTagName("CEP").item(temp).getTextContent());

            }
        }
    }

    private static void lerElementosEnderDest(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noEnderDest = elementos.item(temp);
            if (noEnderDest.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noEnderDest;
                documento.setIbgeDestinatario(Integer.parseInt(eElement.getElementsByTagName("cMun").item(temp).getTextContent()));
                documento.setCidadeDestinatario(eElement.getElementsByTagName("xMun").item(temp).getTextContent());
                documento.setUfDestinatario(eElement.getElementsByTagName("UF").item(temp).getTextContent());
                documento.setEnderecoDestinatario(eElement.getElementsByTagName("xLgr").item(temp).getTextContent());
                documento.setNumeroDestinatario(eElement.getElementsByTagName("nro").item(temp).getTextContent());
                documento.setBairroDestinatario(eElement.getElementsByTagName("xBairro").item(temp).getTextContent());
                documento.setCepDestinatario(eElement.getElementsByTagName("CEP").item(temp).getTextContent());
            }
        }
    }
    private static void lerElementosEnderReme(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noEnderReme = elementos.item(temp);
            if (noEnderReme.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noEnderReme;
                documento.setIbgeRementente(Integer.parseInt(eElement.getElementsByTagName("cMun").item(temp).getTextContent()));
                documento.setCidadeRementente(eElement.getElementsByTagName("xMun").item(temp).getTextContent());
                documento.setUfRementente(eElement.getElementsByTagName("UF").item(temp).getTextContent());
                documento.setEnderecoRementente(eElement.getElementsByTagName("xLgr").item(temp).getTextContent());
                documento.setNumeroRementente(eElement.getElementsByTagName("nro").item(temp).getTextContent());
                documento.setBairroRementente(eElement.getElementsByTagName("xBairro").item(temp).getTextContent());
                documento.setCepRementente(eElement.getElementsByTagName("CEP").item(temp).getTextContent());
            }
        }
    }

}
