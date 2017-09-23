/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlToDb;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

/**
 *
 * @author Minimal
 */
public class getDataFromHtml {

    public void getTables(HtmlPage page) {

        String xmlTabla = "//table[@class='DataTable']";

        for (int i = 0; i < page.getByXPath(xmlTabla).size(); i++) {
            HtmlTable tabla = (HtmlTable) page.getByXPath(xmlTabla).get(i);
            for (HtmlTableRow row : tabla.getRows()) {
                for (HtmlTableCell cell : row.getCells()) {
                    System.out.print(cell.asText() + ",");
                }
                System.out.println("\n");
            }
        }
    }

    public void getTable() {

    }
}
/*
public String fromColorToNumber(HtmlTableCell celda) {
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
                return celda.asText() + ",";
        }
    }

    public String printColor(HtmlTableCell celda) {
        if (celda.getAttribute("class").equals("StatistGreen")) {
            return "Green,";
            //countGren++;
        }
        if (celda.getAttribute("class").equals("StatistRed")) {
            return "Red,";
            //countRed++;
        }
        if (celda.getAttribute("class").equals("StatistYellow")) {
            return "Yellow,";
            //countYellow++;
        }
        return celda.asText();
    }

    public void getInfoTable(String direccion) throws Exception {

        FileWriter fstream = new FileWriter("prueba002.txt");
        BufferedWriter out = new BufferedWriter(fstream);

        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage(direccion);
        final HtmlTable table = (HtmlTable) page.getByXPath("//table[@class='DataTable']").get(0);

        for (int i = 1; i < 16; i++) {

            out.write(table.getRows().get(i).getCell(1).asText() + ",");
            //out.write(table.getRows().get(i).getCell(1).asText());

        }
        out.close();
        webClient.close();

    }

    public String getInfo(HtmlPage page, int tabla) {

        HtmlTable table = (HtmlTable) page.getByXPath("//table[@class='DataTable']").get(tabla);
        if (tabla == 0) {
            return recorrotabla(table);
        }
        if (tabla >= 4) {
            return recorrotabla(table);
        }
        return "";
    }

    public String recorrotabla(HtmlTable tabla) {
        for (HtmlTableRow row : tabla.getRows()) {
            for (HtmlTableCell cell : row.getCells()) {
                return fromColorToNumber(cell);
            }
            return "\n";
        }
        return "";
    }
}
 */
