/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import management.interfaces.Command;
import management.interfaces.Item;
import org.apache.tika.Tika;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

/**
 *
 * @author vital
 */
public class InfoCommand implements Command {

    public static void info(Item item)
            throws IOException, TikaException {

        Tika tika = new Tika();
        String mediaType = tika.detect(item.getLocation());
        System.out.println(item.getId() + " is " + mediaType);
        Metadata meta = extractMetadatatUsingFacade(new FileInputStream(item.getLocation()));
        
        String[] metadataNames = meta.names();

        for(String name : metadataNames) {		        
           System.out.println(name + ": " + meta.get(name));
       }
    }

    public static Metadata extractMetadatatUsingFacade(InputStream stream)
            throws IOException, TikaException {
        Tika tika = new Tika();
        Metadata metadata = new Metadata();

        tika.parse(stream, metadata);
        return metadata;
    }
}
