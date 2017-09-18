/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlToDb;

/**
 *
 * @author acenturion
 */
public class FileFromHtml {

    private final String direccion;
    private static FileFromHtml fileFromHtml;

    private FileFromHtml(String direccion) {
        this.direccion = direccion;
    }

    public static FileFromHtml getFile(String direccion) {
        if (fileFromHtml == null) {
            fileFromHtml = new FileFromHtml(direccion);
        } else {
            System.out.println("Error en el singleton");
        }
        return fileFromHtml;
    }

}
