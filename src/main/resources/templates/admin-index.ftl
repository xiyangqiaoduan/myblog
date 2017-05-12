<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="robots" content="none" />
        <title>个人博客 - 后台管理</title>
        <link type="text/css" rel="stylesheet" href="/css/default-base.css?2000111" />
        <link type="text/css" rel="stylesheet" href="/css/default-admin.css?2000111" />
        <link type="text/css" rel="stylesheet" href="/js/lib/CodeMirrorEditor/codemirror.min.css?1111" />
        <link type="text/css" rel="stylesheet" href="/js/lib/highlight.js-9.6.0/styles/github.css?1111" />
        <#--<link rel="icon" type="image/png" href="/favicon.png" />-->
    </head>
    <body onhashchange="admin.setCurByHash();">
        <div class="tip"><span id="loadMsg">载入中</span></div>
        <div class="tip tip-msg"><span id="tipMsg"></span></div>
        <div id="allPanel">
            <div id="top">
                <a href="" target="_blank" class="hover">
                    个人博客
                </a>
               
                <span class="right"> 
                    <a href="" title='首页'>首页</a><a href='javascript:admin.logout();' title='退出'>登出</a>
                </span>
            </div>
            <div id="tabs">
                <ul>
                    <li>
                        <div id="tabs_main">
                            <a href="#main">
                                <span class="icon-refresh"></span> 后台首页
                            </a>
                        </div>
                    </li>
                    <li>
                        <div id="tabArticleTitle" class="tab-current" onclick="admin.collapseNav(this)">
                            <span class="icon-article"></span>
                            文章
                            <span class="icon-chevron-up right"></span>
                        </div>
                        <ul id="tabArticleMgt">
                            <li>
                                <div id="tabs_article">
                                    <a href="#article/article" onclick="admin.article.prePost()">发布文章</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_article-list">
                                    <a href="#article/article-list">文章整理</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_draft-list">
                                    <a href="#article/draft-list">草稿夹</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <div id="tabs_comment-list">
                            <a href="#comment-list">
                                <span class="icon-cmts"></span>评论管理
                            </a>
                        </div>
                    </li>
                    <li>
                        <div id="tabToolsTitle" onclick="admin.collapseNav(this)">
                            <span class="icon-setting"></span>
                            工具管理
                            <span class="icon-chevron-down right"></span>
                        </div>
                        <ul class="none" id="tabTools">
                            <li>
                                <div id="tabs_preference">
                                    <a href="#tools/preference">偏好设定</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_category-list">
                                    <a href="#tools/category-list">分类管理</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_page-list">
                                    <a href="#tools/page-list">导航管理</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_link-list">
                                    <a href="#tools/link-list">链接管理</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_user-list">
                                    <a href="#tools/user-list">用户管理</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_plugin-list">
                                    <a href="#tools/plugin-list">插件管理</a>
                                </div>
                            </li>
                            <li>
                                <div id="tabs_others">
                                    <a href="#tools/others">其他</a>
                                </div>
                            </li>  
                        </ul>
                    </li>
                    <li>
                        <div id="tabs_about">
                            <a href="#about">
                                <span class="icon-info"></span> 关于
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
            <div id="tabsPanel">
                <div id="tabsPanel_main" class="none"></div>
                <div id="tabsPanel_article" class="none"></div>
                <div id="tabsPanel_article-list" class="none"></div>
                <div id="tabsPanel_draft-list" class="none"></div>
                <div id="tabsPanel_link-list" class="none"></div>
                <div id="tabsPanel_preference" class="none"></div>
                <div id="tabsPanel_category-list" class="none"></div>
                <div id="tabsPanel_page-list" class="none"></div>
                <div id="tabsPanel_others" class="none"></div>
                <div id="tabsPanel_user-list" class="none"></div>
                <div id="tabsPanel_comment-list" class="none"></div>
                <div id="tabsPanel_plugin-list" class="none"></div>
                <div id="tabsPanel_about" class="none"></div>
            </div>
            <div class="clear"></div>
            <div class="footer">
                Powered by <a href="http://b3log.org" target="_blank">B3log 开源</a> • <a href="https://hacpai.com/tag/solo" target="_blank">Solo</a> 1.0.0
            </div>
        </div>
        <script src="/js/lib/compress/admin-lib.min.js"></script>
        <script src="/js/lib/tiny_mce/tiny_mce.js"></script>
        <script src="/js/lib/KindEditor/kindeditor-min.js"></script>
        <script src="/js/common.js"></script>

        <script src="/js/admin/admin.js"></script>
        <script src="/js/admin/editor.js"></script>
        <script src="/js/admin/editorTinyMCE.js"></script>
        <script src="/js/admin/editorKindEditor.js"></script>
        <script src="/js/admin/editorCodeMirror.js"></script>
        <script src="/js/admin/tablePaginate.js"></script>
        <script src="/js/admin/article.js"></script>
        <script src="/js/admin/comment.js"></script>
        <script src="/js/admin/articleList.js"></script>
        <script src="/js/admin/draftList.js"></script>
        <script src="/js/admin/pageList.js"></script>
        <script src="/js/admin/others.js"></script>
        <script src="/js/admin/linkList.js"></script>
        <script src="/js/admin/preference.js"></script>
        <script src="/js/admin/pluginList.js"></script>
        <script src="/js/admin/userList.js"></script>
        <script src="/js/admin/categoryList.js"></script>
        <script src="/js/admin/commentList.js"></script>
        <script src="/js/admin/plugin.js"></script>
        <script src="/js/admin/main.js"></script>
        <script src="/js/admin/about.js"></script>

        <script src="/js/admin/latkeAdmin.js"></script>

        <#include "admin-label.ftl">

        <script >
            admin.inited();
        </script>
    </body>
</html>