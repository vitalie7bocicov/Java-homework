/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import management.interfaces.Command;
import management.interfaces.Item;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author vital
 */
public class ViewCommand implements Command{
    public static void viewItem(Item item)
            throws IOException, NullPointerException, IllegalArgumentException, URISyntaxException{
        
        Desktop desktop = Desktop.getDesktop();
        File myItem = new File(item.getLocation());
        
        UrlValidator urlValidator = new UrlValidator();
        if(urlValidator.isValid(item.getLocation()))
            desktop.browse(new URI(item.getLocation()));
        else
            desktop.open(myItem);
    }
    
    public static void viewIndex(File file)
            throws IOException, NullPointerException, IllegalArgumentException, URISyntaxException{
        
        Desktop desktop = Desktop.getDesktop();
        
        UrlValidator urlValidator = new UrlValidator();
        if(urlValidator.isValid(file.getAbsolutePath()))
            desktop.browse(new URI(file.getAbsolutePath()));
        else
            desktop.open(file);
    }
}
