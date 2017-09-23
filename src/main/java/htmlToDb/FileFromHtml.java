/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlToDb;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author acenturion
 */
public class FileFromHtml {

    private static FileWriter fileFromHtml = null;

    public static FileWriter getInstance(String direccion) throws IOException {
        if(fileFromHtml == null){
            fileFromHtml = new FileWriter(direccion);
        }
            return fileFromHtml;
    }

}
