<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="个人博客">
            <meta name="keywords" content="Solo,Java 博客,开源"/>
            <meta name="description" content="An open source blog with Java. Java 开源博客"/>
        </@head>
    </head>
    <body>
        <#include "header.ftl">
       <div class="wrapper">
            <div class="main-wrap">
                <main>
                    <#include "article-list.ftl">
                </main>
               <#-- <#include "side.ftl">-->
            </div>
        </div>

        <#include "footer.ftl">
    </body>
</html>