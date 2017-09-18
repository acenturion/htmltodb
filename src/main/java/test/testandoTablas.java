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
import java.util.List;

/**
 *
 * @author Minimal
 */
public class testandoTablas {

    public static void main(String[] args) throws Exception {

        try {
            FileWriter fstream = new FileWriter("index.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            final WebClient webClient = new WebClient();
            final HtmlPage page = webClient.getPage("file:///C:/Users/acenturion/Desktop/regresion001.html");
            int countGren = 0;
            int countRed = 0;
            int countYellow = 0;
            //final HtmlTable table = page.getHtmlElementById("DataTable");
            final HtmlTable table = (HtmlTable) page.getByXPath("//table[@class='DataTable']").get(4);

            for (int i = 2; i < table.getRowCount() - 1; i++) {
                HtmlTableRow row = table.getRow(i);
                for (final HtmlTableCell cell : row.getCells()) {
                    
                    out.write(cell.getTextContent() + ",");
                }
                out.write("\n");
            }

            out.close();
            webClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
