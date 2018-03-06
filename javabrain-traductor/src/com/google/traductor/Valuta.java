package com.google.traductor;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Fernando García
 */
public class Valuta {

    private static Scraping s = new Scraping();

    public static String mnxToUsdType(double mnx){
        DecimalFormat df = new DecimalFormat("#.0000 USD");
        double a = mnx / s.map.get("usd");
        return df.format(a);
    }

    public static String usdToMnxType(double usd){
        DecimalFormat df = new DecimalFormat("#.0000 MNX");
        double a = usd * s.map.get("usd");
        return df.format(a);
    }

    public static double mnxToUsd(double mnx){
        return mnx / s.map.get("usd");
    }

    public static double usdToMnx(double usd){
        return usd * s.map.get("usd");
    }

    public static void main(String[] args) {
        System.out.println(usdToMnxType(70.00));
        System.out.println(mnxToUsd(50.00));
    }
}

class Scraping{

    public final String url = "https://www.hsbc.com.mx/1/2/es/personas/divisas";
    public final int maxPages = 2;
    public Map<String,Double> map = new HashMap();

    public Scraping() {

        for (int i=1; i<maxPages; i++){

            String urlPage = String.format(url, i);

            if (getStatusConnectionCode(urlPage) == 200) {

                Document document = getHtmlDocument(urlPage);
                Elements entradas = document.select("div.grid.grid_24");
                String data = entradas.get(1).getElementsByClass("vdp_tableStyle").text();
                String div = data
                .replace("Divisas A la compra A la Venta Dólar Americano $ ","")
                .replace("Euro","")
                .replace("Libra Esterlina","")
                .replace("Yen Japonés","")
                .replace("Yuan Chino","")
                .replace("Real Brasileño","")
                .replace("Real Brasileño","")
                .replace("Dólar Canadiense","")
                .replace(" ","")
                .replace("$",",");
                String[] divs = div.substring(1).split(",");

                for (int j = 0; j < divs.length; j++) {
                    String div1 = divs[j];
                    System.out.println(div1+" "+j);
                }


                map.put("usd",Double.parseDouble(divs[1]));
                map.put("eur",Double.parseDouble(divs[3]));
                map.put("gbp",Double.parseDouble(divs[5]));//Libra esterlina

            }else{
                System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(urlPage));
                break;
            }
        }
    }

    public int getStatusConnectionCode(String url) {

        Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }

    private Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }

}
