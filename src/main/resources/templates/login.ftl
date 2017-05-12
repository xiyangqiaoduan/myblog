<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>个人博客系统</title>
        <meta name="keywords" content="个人博客系统<" />
        <meta name="description" content="个人博客系统<" />
        <meta name="owner" content="yangcb" />
        <meta name="author" content="yangcb Team" />
        <meta name="generator" content="Solo" />
        <meta name="copyright" content="yangcb" />
        <meta name="revised" content="Blog, 2017" />
        <meta name="robots" content="noindex, follow" />
        <meta http-equiv="Window-target" content="_top" />
        <link type="text/css" rel="stylesheet" href="/css/default-init.css?2017" charset="utf-8" />
        <link rel="icon" type="/image/png" href="favicon.png" />
    </head>
    <body>
        <div class="wrapper">
            <div class="wrap">
                <div class="content">
                    <div class="logo">
                        <a href="" target="_blank">
                            <img border="0" width="153" height="56" alt="B3log" title="B3log" src="/images/logo.jpg"/>
                        </a>
                    </div>
                    <div class="main">
                        <h2>
                           登录
                        </h2>
                        <div class="form">
                            <label for="userEmail">
                                邮箱
                            </label>
                            <input id="userEmail" tabindex="1" />
                            <label for="userPassword">
                                密码
                            </label>
                            <input type="password" id="userPassword" tabindex="2" />
                            <button onclick='login();'>登录</button>
                            <span id="tip"></span>
                        </div>

                    </div>
                    <span class="clear"></span>
                </div>
            </div>
            <div class="footerWrapper">
                <div class="footer">
                    &copy; 2016 - <a href="">个人博客</a><br/>
                    Powered by <a href="http://b3log.org" target="_blank">B3log 开源</a> • <a href="https://hacpai.com/tag/solo" target="_blank">Solo</a> 1.0
                </div>
            </div>
        </div>       
        <script type="text/javascript" src="/js/lib/jquery/jquery.min.js" charset="utf-8"></script>
        <script type="text/javascript">
                                (function() {
                                    $("#userEmail").focus();

                                    $("#userPassword, #userEmail").keypress(function(event) {
                                        if (13 === event.keyCode) { // Enter pressed
                                            login();
                                        }
                                    });

                                    // if no JSON, add it.
                                    try {
                                        JSON
                                    } catch (e) {
                                        document.write("<script src=\"/js/lib/json2.js\"><\/script>");
                                    }
                                })();

                                var login = function() {
                                    if (!/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test($("#userEmail" + status).val())) {
                                        $("#tip").text("邮箱格式错误");
                                        $("#userEmail").focus();
                                        return;
                                    }

                                    if ($("#userPassword").val() === "") {
                                        $("#tip").text("密码不能为空");
                                        $("#userPassword").focus();
                                        return;
                                    }

                                    var requestJSONObject = {
                                        "userEmail": $("#userEmail").val(),
                                        "userPassword": $("#userPassword").val()
                                    };
                                    
                                    $("#tip").html("<img src='/images/loading.gif'/> loading...")

                                    $.ajax({
                                        url: "login",
                                        type: "POST",

                                        data: {  userEmail: $("#userEmail").val(),
                                            userPassword: $("#userPassword").val()},
                                        error: function() {
                                            // alert("Login error!");
                                        },
                                        success: function(data, textStatus) {
                                            if (!data.status) {
                                                $("#tip").text(data.errMsg);
                                                return;
                                            }

                                            window.location.href = data.url;
                                        }
                                    });
                                };
        </script>
    </body>
</html>
