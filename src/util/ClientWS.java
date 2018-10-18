/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidades.Quilometragem;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 *
 * @author ramon
 */
public class ClientWS {

    public static String recebeWS(String origem, String destino) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("conf.properties"));
            String chave = prop.getProperty("api.chave");
            
            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/xml?origins=" + origem + "&destinations=" + destino + "&mode=driving&language=pt-BR&sensor=false&key=" + chave);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes("Quilometragem");
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            return response.toString();

        } catch (IOException e) {
            Logger log = Logger.getLogger(ClientWS.class.getName());
            log.log(Level.ERROR, e);
            throw new RuntimeException(e);
        }
    }

    public static Quilometragem quilometragemXML(String xml) {
        try {
            InputSource is = new InputSource(new StringReader(xml));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();
            String origem = doc.getElementsByTagName("origin_address").item(0).getTextContent();
            String destino = doc.getElementsByTagName("destination_address").item(0).getTextContent();
            String quilometragem = doc.getElementsByTagName("text").item(1).getTextContent();
            String tempo = doc.getElementsByTagName("text").item(0).getTextContent();
            int metragem = Integer.parseInt(doc.getElementsByTagName("value").item(1).getTextContent());
            
            return new Quilometragem(origem, destino, quilometragem, tempo, metragem);

        } catch (Exception e) {
            Logger log = Logger.getLogger(ClientWS.class.getName());
            log.log(Level.ERROR, e);
            return new Quilometragem();
        }
    }
}
