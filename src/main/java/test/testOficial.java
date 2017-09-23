/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Minimal
 */
public class testOficial {

    public static void main(String[] args) throws Exception {
        try {
            //agregar una funcion que genere nombres automaticamente
            FileWriter file = new FileWriter("test0035.txt");
            BufferedWriter out = new BufferedWriter(file);

            WebClient webClient = new WebClient();
            //Agregar una funcion que busque el archivo
            HtmlPage page = webClient.getPage("file:///C:/Users/acenturion/Desktop/test002.html");
            //Como identifica las tablas
            String xmlTabla = "//table[@class='DataTable']";

            //Recorro todas las tablas
            for (int i = 0; i < page.getByXPath(xmlTabla).size(); i++) {
                //con i = 0 obtengo la tabla de la regresion
                if (i == 0) {
                    HtmlTable tabla = (HtmlTable) page.getByXPath(xmlTabla).get(i);

                    out.write(getRegresionData(tabla));
                }
                //con mayor a 4 obtengo los modulos y los casos
                if (i >= 4) {
                    HtmlTable tabla = (HtmlTable) page.getByXPath(xmlTabla).get(i);
                    out.write(getTittleCell(tabla));
                    out.write(getNameModule(tabla));
                    out.write(getCasos(tabla));

                }
                //out.write("\n");
            }

            out.close();
            webClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String getTittleCell(HtmlTable tabla){
        HtmlTableRow row = tabla.getRow(0);
        String tittleCell = "";
        for (final HtmlTableCell cell : row.getCells()) {
            tittleCell += cell.asText() + ",";
        }
        tittleCell += "\n";
        return tittleCell;
        
    }

    public static String getRegresionData(HtmlTable tabla) {
        String regresionData = "";
        for (int i = 1; i < 16; i++) {
            String cell = tabla.getRows().get(i).getCell(1).asText();
            regresionData += cell + ",";
        }
        regresionData += "\n";
        return regresionData;
        
    }

    public static String getNameModule(HtmlTable tabla) {
        HtmlTableRow row = tabla.getRow(1);
        String nameModule = "";
        for (final HtmlTableCell cell : row.getCells()) {
            nameModule += cell.asText() + "\n";
        }
        return nameModule;
    }

    public static String getCasos(HtmlTable tabla) {
        String casos = "";
        for (int i = 2; i < tabla.getRowCount() - 1; i++) {
            HtmlTableRow row = tabla.getRow(i);
            for (final HtmlTableCell cell : row.getCells()) {
                casos += fromColorToNumber(cell) + ",";
            }
            casos += "\n";
        }
        return casos;
    }

    public static String fromColorToNumber(HtmlTableCell celda) {
        //System.out.println(celda.asText());   
        switch (celda.asText()) {
            case "Tkt":
                return printColor(celda);
            case "Tsl":
                return printColor(celda);
            case "GUI":
                return printColor(celda);
            case "Mkt":
                return printColor(celda);
            case "Dplus":
                return printColor(celda);
            case "Pang":
                return printColor(celda);
            case "Bcore":
                return printColor(celda);
            case "Htef":
                return printColor(celda);
            case "SGV":
                return printColor(celda);
            default:
                return celda.asText();
        }
    }

    public static String printColor(HtmlTableCell celda) {
        //Con esta funcion puedo identificar el color de cada verificacion
        if (celda.getAttribute("class").equals("StatistGreen")) {
            return "Green";
            //countGren++;
        }
        if (celda.getAttribute("class").equals("StatistRed")) {
            return "Red";
            //countRed++;
        }
        if (celda.getAttribute("class").equals("StatistYellow")) {
            return "Yellow";
            //countYellow++;
        }
        return celda.asText();
    }
    
}
