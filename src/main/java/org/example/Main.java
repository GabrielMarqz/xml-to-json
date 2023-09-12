package org.example;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String retornoDaJanela = lerXML();
        JanelaSistema janela = new JanelaSistema(retornoDaJanela);
    }

            public static String lerXML () throws Exception { //transformei em public, tirei o void e coloquei string e no final return armazena
                String stringDeRetorno = "Valor de retorno";

// Descobrindo nome do arquivo e validando a quantidade de arquivos no diretório
                File diretorioDeCTES = new File("C:\\XMLSoprano\\");
                File[] listaDeCTES = diretorioDeCTES.listFiles();
                String nomeDoArquivo = null;
                for (File cteInvidual : listaDeCTES) {
                    nomeDoArquivo = cteInvidual.getName();
                }

                if (listaDeCTES.length >= 2) {
                    System.out.println("\nNao foi possivel enviar - Adicione um CTE por vez na pasta XMLSOPRANO.\n");
                    stringDeRetorno = ("\nNao foi possivel enviar - Adicione um CTE por vez na pasta XMLSOPRANO.\n");
                   return stringDeRetorno;

                } else if  (nomeDoArquivo == null){
                    System.out.println("\nNao foi possivel enviar - A pasta XMLSOPRANO esta vazia.\n");
                    stringDeRetorno = ("\nNao foi possivel enviar - A pasta XMLSOPRANO esta vazia.\n");
                   return stringDeRetorno;
        }
//  Mostrando o caminho do arquivo
                File fXmlFile = new File("C:\\XMLSoprano\\".concat(nomeDoArquivo));
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                Gson gson = new Gson();
                Documento documento = new Documento();
                InfQuantidadeCTe infQuantidadeCTe = new InfQuantidadeCTe();
                ComponentesValor componentesValor = new ComponentesValor();
                NotaFiscal notaFiscal = new NotaFiscal();

                lerElementosInfCte(doc, documento);
                lerInfQuantidadeCTe(doc, documento);
                lerComponentesValor(doc, documento);
                lerNotasFiscais(doc, documento);

// Criando método para ler o JSON COMPLETO
                System.out.println("\n####Imprimindo JSON:####\n");
                System.out.println(gson.toJson(documento));

// Connectando com o servidor
                try {
                    String urlSoprano = "http://soprano.mosistemas.com/app/api/track/conhecimentos";
                    String apikeySoprano = "1ee266e4-7b8b-4fa2-a01d-602b9cfd57f7";

                    URL urlDoServidor = new URL(urlSoprano);
                    HttpURLConnection conexaoComOServidor = (HttpURLConnection) urlDoServidor.openConnection();
                    conexaoComOServidor.setRequestMethod("POST");
                    conexaoComOServidor.setRequestProperty("Content-Type", "application/json");
                    conexaoComOServidor.setRequestProperty("API-KEY", apikeySoprano);

// Enviando o JSON
                    conexaoComOServidor.setDoOutput(true);
                    OutputStream os = conexaoComOServidor.getOutputStream();
                    os.write(gson.toJson(documento).getBytes());
                    os.flush();
                    os.close();

// Verificando o código de resposta
                    int codigoResposta = conexaoComOServidor.getResponseCode();
                    System.out.println("\nCodigo de resposta: " + codigoResposta);
                    if (codigoResposta >= 200 && codigoResposta <= 299)  {
                        System.out.println("\nCTE enviado com sucesso!");
                        stringDeRetorno = ("\nCTE enviado com sucesso!");
                    } else if (codigoResposta >= 400 && codigoResposta <= 499) {
                        System.out.println("\nCTE incorreto ou ja cadastrado pela transportadora.");
                        stringDeRetorno = ("\nCTE incorreto ou ja cadastrado pela transportadora.");
                    } else {
                        System.out.println("\nNao foi possivel enviar o CTE, contate o suporte.");
                        stringDeRetorno = ("\nNao foi possivel enviar o CTE, contate o suporte.");
                    }

                } catch (Exception e) {
                    System.out.println("\nNao foi possivel connectar com o banco de dados do cliente, contate o suporte: " + e);
                    stringDeRetorno = ("\nNao foi possivel connectar com o banco de dados do cliente, contate o suporte: " + e);
                }
                return stringDeRetorno;
            }


// Aqui esta pegando as informações que foram extraidas e adicionando dentro dos respectivos metodos ( componentes valor, infquantidadeCTE e notafiscais que tem array, e elementosincte que são todas as tags que utilizamos para pegar os sem sem array)

    private static void lerComponentesValor(Document doc, Documento documento) {
        NodeList comp = doc.getElementsByTagName("Comp");
        lerElementosComp(comp,documento);
    }

    private static void lerInfQuantidadeCTe(Document doc, Documento documento) {
        NodeList infQ = doc.getElementsByTagName("infQ");
        lerElementosInfQ(infQ, documento);
    }

    private static void lerNotasFiscais (Document doc, Documento documento)   {
        NodeList infNFe = doc.getElementsByTagName("infNFe");
        lerElementosInfNFe(infNFe, documento);
    }

    private static void lerElementosInfCte(Document doc, Documento root) {
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

// Aqui começa a extrair informações de todas as tags do xml
// renomear estes metodos para "extrairelementos..."  e separar na classe "extrairelementos" para deixar a main mais clean

    private static void lerElementosIde(NodeList elementos, Documento documento) {
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noIde = elementos.item(temp);
            if (noIde.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) noIde;
                documento.setNumero(Integer.parseInt(eElement.getElementsByTagName("nCT").item(temp).getTextContent()));
                documento.setSerie(eElement.getElementsByTagName("serie").item(temp).getTextContent());
                documento.setTipoServico(eElement.getElementsByTagName("tpServ").item(temp).getTextContent());
                if (documento.getTipoServico().equals("0")) {documento.setTipoServico("NORMAL");}

                documento.setDataEmissao(eElement.getElementsByTagName("dhEmi").item(temp).getTextContent().substring(0, 19) + ".000Z");
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//                Calendar cal = Calendar.getInstance();
//                String new_pat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
//                sdf.applyPattern(new_pat);
//                String curr_date = sdf.format(documento.getDataEmissao());
//                sdf.toPattern();
//                documento.setDataEmissao(curr_date);
//            String data = (2021/01/25 10:43)               sdf.format(data);
//                sdf.format(new java.util.Date());
//              sdf.(data);
//                documento.setDataEmissao(curr_date);

                documento.setTipoCte(eElement.getElementsByTagName("tpCTe").item(temp).getTextContent());
                if (documento.getTipoCte().equals("0")) {documento.setTipoCte("NORMAL");}

                documento.setIbgeInicioOperacao(Integer.parseInt(eElement.getElementsByTagName("cMunIni").item(temp).getTextContent()));
                documento.setCidadeInicioOperacao(eElement.getElementsByTagName("xMunIni").item(temp).getTextContent());
                documento.setUfInicioOperacao(eElement.getElementsByTagName("UFIni").item(temp).getTextContent());
                documento.setIbgeFimOperacao(Integer.parseInt(eElement.getElementsByTagName("cMunFim").item(temp).getTextContent()));
                documento.setCidadeFimOperacao(eElement.getElementsByTagName("xMunFim").item(temp).getTextContent());
                documento.setUfFimOperacao(eElement.getElementsByTagName("UFFim").item(temp).getTextContent());
                documento.setCfop(Integer.parseInt(eElement.getElementsByTagName("CFOP").item(temp).getTextContent()));
                documento.setModal(eElement.getElementsByTagName("modal").item(temp).getTextContent());
                if (documento.getModal().equals("01")) {documento.setModal("RODOVIARIO");}
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
                documento.setTipoDoc("CONHECIMENTO"); //Como vai ser sempre CTE..
               documento.setChave(eElement.getElementsByTagName("chCTe").item(temp).getTextContent());
               documento.setProtocoloCte(eElement.getElementsByTagName("nProt").item(temp).getTextContent());
               documento.setDataProtocoloCte(eElement.getElementsByTagName("dhRecbto").item(temp).getTextContent().substring(0, 19) + ".000Z");
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//                String data = eElement.getElementsByTagName("dhRecbto").item(temp).getTextContent();
//                data = sdf.format(new java.util.Date());
//                documento.setDataProtocoloCte(data);
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
                documento.setTipoTributacao(eElement.getElementsByTagName("CST").item(temp).getTextContent());
                if (documento.getTipoTributacao().equals("00")) {documento.setTipoTributacao("NORMAL");
                documento.setValorIcms(Double.parseDouble(eElement.getElementsByTagName("vICMS").item(temp).getTextContent()));
                documento.setBaseCalculoIcms(Double.parseDouble(eElement.getElementsByTagName("vBC").item(temp).getTextContent()));
                documento.setAliquotaIcms(Double.parseDouble(eElement.getElementsByTagName("pICMS").item(temp).getTextContent()));}
                else if (documento.getTipoTributacao().equals("40")) {documento.setTipoTributacao("OUTROS");}
            }
        }
    }


    private static void lerElementosInfQ(NodeList elementos, Documento documento) {
        List<InfQuantidadeCTe> infQuantidadeCTes = new ArrayList<>();
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noInfQ = elementos.item(temp);
            if (noInfQ.getNodeType() == Node.ELEMENT_NODE) {
                InfQuantidadeCTe infQuantidadeCTe = new InfQuantidadeCTe();
                Element eElement = (Element) noInfQ;
                infQuantidadeCTe.setCodigoUnidadeMedida(Integer.valueOf(eElement.getElementsByTagName("cUnid").item(0).getTextContent()));
                infQuantidadeCTe.setMedida(eElement.getElementsByTagName("tpMed").item(0).getTextContent());
                infQuantidadeCTe.setQuantidade(Double.parseDouble(eElement.getElementsByTagName("qCarga").item(0).getTextContent()));
                infQuantidadeCTes.add(infQuantidadeCTe);

            }
        }
        documento.setInfQuantidadeCTe(infQuantidadeCTes);
    }

    private static void lerElementosInfNFe(NodeList elementos, Documento documento) {
        List<NotaFiscal> notasFiscais = new ArrayList<>();
        for (int temp = 0; temp < elementos.getLength(); temp++) {
            Node noVPrest = elementos.item(temp);
            if (noVPrest.getNodeType() == Node.ELEMENT_NODE) {
                NotaFiscal notaFiscal = new NotaFiscal();
                Element eElement = (Element) noVPrest;

                notaFiscal.setChave(eElement.getElementsByTagName("chave").item(0).getTextContent());
                notaFiscal.setNumero(Integer.parseInt(eElement.getElementsByTagName("chave").item(0).getTextContent().substring(25, 34)));
                notaFiscal.setSerie(Integer.parseInt(eElement.getElementsByTagName("chave").item(0).getTextContent().substring(22, 25)));
                notaFiscal.setCnpjEmissor(eElement.getElementsByTagName("chave").item(0).getTextContent().substring(6, 20));
                notasFiscais.add(notaFiscal);
            }
        }
        documento.setNotasFiscais(notasFiscais);
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