/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 *
 * @author Minimal
 */
public class testeandoelbicho {

    public static void main(String[] args) throws Exception {

        try {
            final WebClient webClient = new WebClient();
            final HtmlPage page = webClient.getPage("file:///C:/Users/Minimal/Desktop/codigo.html");
            //WebAssert.assertTextPresent(page, "It has fairly good JavaScript support");
            
            final HtmlDivision division = page.getHtmlElementById("Tooltip_1");

            //System.out.println(page.getTitleText());
            System.out.println(division.asXml());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public void getPage() throws Exception {
//        try (final WebClient webClient = new WebClient()) {
//            final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
//            WebAssert.assertTextPresent(page, "It has fairly good JavaScript support");
//
//        } catch (Exception e) {
//            System.out.println("Mira flaco no encointre nada segbui participando :D");
//        }
//    }
}
