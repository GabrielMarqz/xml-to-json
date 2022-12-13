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

    }

    private static void lerElementosInfCte(Document doc, Documento root) {
        NodeList ides = doc.getElementsByTagName("ide");                    //Imprimindo elementos de cada método
        lerElementosIde(ides, root);
        NodeList emits = doc.getElementsByTagName("emit");
        lerElementosEmit(emits, root);

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
}
