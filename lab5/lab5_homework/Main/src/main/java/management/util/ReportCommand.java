/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import management.classes.Article;
import management.classes.Catalog;
import management.interfaces.Command;
import management.interfaces.Item;

/**
 *
 * @author vital
 */
public class ReportCommand implements Command {

    public static void report(Catalog catalog)
            throws IOException, TemplateException, NullPointerException, IllegalArgumentException, URISyntaxException {

        Configuration cfg = new Configuration(new Version("2.3.23"));

        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("template.ftl");
            
        Map<String, Object> articles = new HashMap<>();
        for(Item item : catalog.getItems()){
            if(item instanceof Article)
                articles.put(item.getId(), (Article)item);
        }
        Map<String, Object> templateData = new HashMap<>();

        templateData.put("catalog", catalog);
        templateData.put("articles", articles);

        File output = new File("output.html");
        try (Writer fileWriter = new FileWriter(output, StandardCharsets.UTF_8)) {
            template.process(templateData, fileWriter);
            ViewCommand.viewIndex(output);
        }
        
    }
}
