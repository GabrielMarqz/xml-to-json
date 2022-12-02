package org.example;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception{
        lerXML();
    }

    private static void lerXML() throws Exception{
        File fXmlFile = new File("C:\\CTe-41221085393783000254570010000113651000085803.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        Documento documento = new Documento();

        lerElementosInfCte(doc, documento);
        Gson gson = new Gson();

        System.out.println(gson.toJson(documento));

    }

    private static void lerElementosIde(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noIde = elementos.item(temp);
            if (noIde.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noIde;
                documento.setNumero(eElement.getElementsByTagName("nCT").item(temp).getTextContent());
                documento.setSerie(eElement.getElementsByTagName("cCT").item(temp).getTextContent());
                documento.setTipoServico(eElement.getElementsByTagName("tpServ").item(temp).getTextContent());
            }
        }
    }

    private static void lerElementosInfCte(Document doc, Documento root) {
        NodeList ides = doc.getElementsByTagName("ide");
        lerElementosIde(ides, root);
    }
}
