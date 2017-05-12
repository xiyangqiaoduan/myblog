<div>

    <article class="post">
        <header>
            <h1>
                <a rel="bookmark" href="">
                    世界，你好!
                </a>
               <#-- <#if article.articlePutTop>
                <sup>
                    ${topArticleLabel}
                </sup>
                </#if>
                <#if article.hasUpdated>
                <sup>
                    ${updatedLabel}
                </sup>
                </#if>-->
            </h1>

            <div class="meta">
                <span class="tooltipped tooltipped-n" aria-label="创建日期">
                    <i class="icon-date"></i>
                    <time>
                      2017-05-10
                    </time>
                </span>
                &nbsp; | &nbsp;
                <span class="tooltipped tooltipped-n" aria-label="评论数">
                     <i class="icon-comments"></i>
                    <a href="http://localhost/hello-solo#comments">
                        6 评论</a>
                </span>
                &nbsp; | &nbsp;
                <span class="tooltipped tooltipped-n" aria-label="浏览数">
                    <i class="icon-views"></i>
                     1 浏览
                </span>
            </div>
        </header>
        <div class="content-reset">
            <p>欢迎使用 <a href="https://github.com/b3log/solo">Solo</a> 博客系统。这是系统自动生成的演示文章，编辑或者删除它，然后开始你的独立博客之旅！</p>
            <p>另外，欢迎你加入<a href="https://hacpai.com">黑客与画家的社区</a>，你可以使用博客账号直接登录！</p>
            <hr/>
            <p>Solo 博客系统是一个开源项目，如果你觉得它很赞，请到<a href="https://github.com/b3log/solo">项目首页</a>给颗星鼓励一下 <img align="absmiddle" alt=":heart:" class="emoji" src="http://localhost:8080/solo/js/lib/emojify.js-1.1.0/images/basic/heart.png" title=":heart:" width="20px" height="20px"></img></p>
        </div>
        <footer class="fn-clear tags">

                <a class="tag" rel="tag" href="tags/java"> java</a>
                <a class="tag" rel="tag" href="tags/spring"> spring</a>
            <a href="#more" rel="contents" class="fn-right">
                阅读全文 &raquo;
            </a>
        </footer>
    </article>



   <#-- <#if 0 != paginationPageCount>
        <div class="fn-clear">
            <nav class="pagination fn-right">
                <#if 1 != paginationPageNums?first>
                <a href="${servePath}${path}/${paginationPreviousPageNum}" class="page-number">&laquo;</a>
                    <a class="page-number" href="${servePath}${path}/1">1</a> <span class="page-number">...</span>
                </#if>
                <#list paginationPageNums as paginationPageNum>
                <#if paginationPageNum == paginationCurrentPageNum>
                <span class="page-number current">${paginationPageNum}</span>
                <#else>
                <a class="page-number" href="${servePath}${path}/${paginationPageNum}">${paginationPageNum}</a>
                </#if>
                </#list>
                <#if paginationPageNums?last != paginationPageCount> <span class="page-number">...</span>
                <a href="${servePath}${path}/${paginationPageCount}" class="page-number">${paginationPageCount}</a>
                <a href="${servePath}${path}/${paginationNextPageNum}" class="page-number">&raquo;</a>
                </#if>
            </nav>
        </div>
    </#if>-->
</div>