package org.example;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.tools.StandardLocation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Date;
import java.time.Instant;

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

        // Criando método para ler classes infquantidadeCTE e Componentesvalor

        InfQuantidadeCTe infQuantidadeCTe = new InfQuantidadeCTe();

        lerinfQuantidadeCTe(doc, infQuantidadeCTe);
        Gson gson2 = new Gson();

        System.out.println(gson2.toJson(infQuantidadeCTe));

    }

    private static void lerinfQuantidadeCTe(Document doc, InfQuantidadeCTe infQuantidadeCTe) {
        System.out.println("\n####Imprimindo informações extraídas da classe InfQuantidadeCTe:####\n");
        NodeList infQ = doc.getElementsByTagName("infQ");
        lerElementosInfQ(infQ, infQuantidadeCTe);
    }

    private static void lerElementosInfCte(Document doc, Documento root) {
        System.out.println("####Imprimindo informações extraídas da classe Documento:####\n");
        NodeList ides = doc.getElementsByTagName("ide");
        lerElementosIde(ides, root);
        NodeList emits = doc.getElementsByTagName("emit");
        lerElementosEmit(emits, root);
        NodeList toma3 = doc.getElementsByTagName("toma3");
        lerElementosToma3(toma3, root);
        NodeList chCte = doc.getElementsByTagName("chCte");
        lerElementosChCte(chCte, root);
        NodeList cst = doc.getElementsByTagName("cst");
        lerElementosCST(cst, root);
        NodeList pICMS = doc.getElementsByTagName("picms");
        lerElementosPICMS(pICMS, root);
//        NodeList vCarga = doc.getElementsByTagName("vCarga");
//        lerElementosVCarga(vCarga, root);             ***********esta com erro
        NodeList vTPres = doc.getElementsByTagName("vTPres");
        lerElementosVTPrest(vTPres, root);
//        NodeList vBC = doc.getElementsByTagName("vBC");
//        lerElementosVBC(vBC, root);                 ***********esta com erro
//        NodeList vICMS = doc.getElementsByTagName("vICMS");
//        lerElementosVICMS(vICMS, root);              ***********esta com erro


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

    private static void lerElementosToma3(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noToma3 = elementos.item(temp);
            if (noToma3.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement =  (Element) noToma3;
                  documento.setTomador(Integer.parseInt(eElement.getElementsByTagName("toma").item(temp).getTextContent()));

            }
        }
    }

    private static void lerElementosChCte(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noChCte = elementos.item(temp);
            if (noChCte.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noChCte;
                documento.setTipoDoc("cte"); //Como vai ser sempre CTE..
                documento.setChave(eElement.getElementsByTagName("chCte").item(temp).getTextContent());

            }
        }
    }

    private static void lerElementosCST (NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noCST = elementos.item(temp);
            if (noCST.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noCST;
                documento.setTipoTributacao(eElement.getElementsByTagName("CST").item(temp).getTextContent());

            }
        }
    }

    private static void lerElementosPICMS (NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noPICMS = elementos.item(temp);
            if (noPICMS.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noPICMS;
                documento.setAliquotaIcms(Double.parseDouble(eElement.getElementsByTagName("pICMS").item(temp).getTextContent()));
            }
        }
    }

    private static void lerElementosVCarga (NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVCarga = elementos.item(temp);
            if (noVCarga.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noVCarga;
                documento.setValorNotas(Double.parseDouble(eElement.getElementsByTagName("vCarga").item(temp).getTextContent()));
            }
        }
    }

    private static void lerElementosVTPrest (NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVTPrest = elementos.item(temp);
            if (noVTPrest.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noVTPrest;
                documento.setFreteTransp(Double.parseDouble(eElement.getElementsByTagName("vTPrest").item(temp).getTextContent()));
            }
        }
    }

    private static void lerElementosVBC (NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVBC = elementos.item(temp);
            if (noVBC.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noVBC;
                documento.setBaseCalculoIcms(Double.parseDouble(eElement.getElementsByTagName("vBC").item(temp).getTextContent()));
            }
        }
    }

    private static void lerElementosVICMS (NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVICMS = elementos.item(temp);
            if (noVICMS.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noVICMS;
                documento.setValorIcms(Double.parseDouble(eElement.getElementsByTagName("vICMS").item(temp).getTextContent()));
            }
        }
    }

    private static void lerElementosInfQ (NodeList elementos, InfQuantidadeCTe documento) {
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
}
