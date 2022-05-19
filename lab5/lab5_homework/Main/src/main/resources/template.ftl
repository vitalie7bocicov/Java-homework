<!DOCTYPE html>
<html>
    <head>
        <title>${catalog.getName()}</title>
        <meta charset="UTF-8">
        <html lang="ro-RO">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        </head>
    <body>
        <h1> ${catalog.getName()}</h1>
        <ol>

            <#list catalog.getItems() as item>
                <li>
                    <strong>ID: ${item.getId()}</strong>
                    <ul>
                        <li>
                            <#if item.getTitle()!="undefined">
                                Title: ${item.getTitle()}
                            </#if>
                        </li>
                        <li>
                            <#if item.getLocation()!="undefined">
                                 Location: <a target="_blank" href="${item.getLocation()}">${item.getLocation()}</a>
                            </#if>
                        </li>
                        <li>
                            <#if item.getLocation()!="undefined">
                                Year: ${item.getYear()}
                            </#if>
                        </li>
                        <li>
                            <#if item.getAuthor()!="undefined">
                                Author: ${item.getAuthor()}
                            </#if>
                        </li>
                        <li>
                            Type: ${item.getType()}
                        </li>
                        <#if (item.getType()=="article")>
                            
                            <#assign name=item.getId()>
                            <#if articles[item.getId()].getLab()!="undefined">
                                <li>
                                    Lab: <a target="_blank" href="${articles[item.getId()].getLab()}">${articles[item.getId()].getLab()}</a>
                                </li>
                            </#if>

                            <#if articles[item.getId()].getSolution()!="undefined">
                                <li>
                                    Solution: <a target="_blank" href="${articles[item.getId()].getSolution()}">${articles[item.getId()].getSolution()}</a>
                                </li>
                            </#if>
                        </#if>
                    </ul>
                </li>
            </#list>

        </ol>
    </body>
</html>