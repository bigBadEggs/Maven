$(function () {
    // 登录
    $("input[name='login']").click(function () {
        var name = $("input[name='userName']").val();
        var pwd = $("input[name='userPwd']").val();
        console.log(name);
        $.ajax({
            url: "http://localhost:8080/Login",
            type: "post",
            data: {
                "userName": name,
                "userPwd": pwd
            },
            dataType: "json",
            success: function (list) {
                if(list.length > 0){
                    layer.open({
                        title: 'success',
                        content: '欢迎登录'
                    });
                }else{
                    layer.open({
                        title: 'error',
                        content: '登录失败'
                    });
                }
            },
            error: function (xml) {
                alert("登录失败");
            }
        })
    })

    // 注册
    $("input[name='register']").click(function () {
        var name = $("input[name='userName']").val();
        var pwd = $("input[name='userPwd']").val();
        $.ajax({
            url: "http://localhost:8080/Register",
            type: "post",
            data: {
                "userName": name,
                "userPwd": pwd
            },
            dataType: "json",
            success: function (mag) {
                if(mag != 0){
                    layer.open({
                        title: 'success',
                        content: '注册成功'
                    });
                }else{
                    layer.open({
                        title: 'error',
                        content: '注册失败'
                    });
                }
            },
            error: function (xml) {
                alert("注册失败");
            }
        })
    })
})