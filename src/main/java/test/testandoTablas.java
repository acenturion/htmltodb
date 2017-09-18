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
public class testandoTablas {

    public static void main(String[] args) throws Exception {

        try {
            FileWriter fstream = new FileWriter("index.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            final WebClient webClient = new WebClient();
            final HtmlPage page = webClient.getPage("file:///C:/Users/Minimal/Desktop/codigo.html");
            int countGren = 0;
            int countRed = 0;
            int countYellow = 0;
            //final HtmlTable table = page.getHtmlElementById("DataTable");
            final HtmlTable table = (HtmlTable) page.getByXPath("//table[@class='DataTable']").get(4);
            
           
            for (final HtmlTableRow row : table.getRows()) {
                
                for (final HtmlTableCell cell : row.getCells()) {
                    
                   // System.out.println(cell.getByXPath("//div/nowrap/text()").get(1));
                  out.write(cell.asText()+",");
               
                    
                    //System.out.println(cell.asText());
                    if (cell.getAttribute("class").equals("StatistGreen")) {
                        out.write("Green,");
                        countGren++;
                    }
                    if (cell.getAttribute("class").equals("StatistRed")) {
                        out.write("Red,");
                        countRed++;
                    }
                    if (cell.getAttribute("class").equals("StatistYellow")) {
                        out.write("Yellow,");
                        countYellow++;
                    }
                }
                out.write('\n');

            }
            System.out.println("Green: " + countGren + "\nRed: " + countRed + "\nYellow: " + countYellow);
            out.close();
            webClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
