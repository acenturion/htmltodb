/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlToDb;

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
public class getDataFromHtml {

    public void getData(String direccion) {
        try {
            FileWriter fstream = new FileWriter("prueba001.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            final WebClient webClient = new WebClient();
            final HtmlPage page = webClient.getPage(direccion);

            final HtmlTable table = (HtmlTable) page.getByXPath("//table[@class='DataTable']").get(4);

            for (int i = 2; i < table.getRowCount() - 1; i++) {
                HtmlTableRow row = table.getRow(i);
                for (final HtmlTableCell cell : row.getCells()) {

                    out.write(fromColorToNumber(cell));
                }
                out.write('\n');
            }
            out.close();
            webClient.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

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

}
