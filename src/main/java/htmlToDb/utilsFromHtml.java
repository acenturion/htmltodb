/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlToDb;

import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

/**
 *
 * @author Minimal
 */
public class utilsFromHtml {

    public void regresionTable(){
        
    }
    
    public static void casesTable(HtmlTableCell cell){
        System.out.print(cell.asText()+",");
    }
}
