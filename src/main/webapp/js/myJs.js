$(function () {
    // 1. 实时监听内容输入
    $("body").delegate(".comment", "propertychange input", function () {
        // 1.1 判断是否输入内容
        if($(this).val().length > 0){
            // 提交按钮可用
            $("input[value='提交']").prop("disabled", false);
        }else{
            // 提交按钮不可用
            $("input[value='提交']").prop("disabled", true);
        }
    })
    // // 2. 监听提交按钮点击
    // $("input[value='提交']").click(function () {
    //     // 拿到用户输入内容
    //     var $text = $(".comment").val();
    //     var $name = $("input[name='userName']").val();
    //     // 提交远程服务器
    //     $.ajax({
    //         url: "http://localhost:8080/addMsg",
    //         type: "post",
    //         data: {
    //             "username": $name,
    //             "message": $text
    //         },
    //         dataType: "text",
    //         success: function (msg) {
    //             if(msg == "1"){
    //                 alert("success"),
    //                 // 清空输入框
    //                 $(".comment").val("");
    //             }
    //         },
    //         error: function (xml) {
    //             console.log(xml);
    //         }
    //     })
    // })
    // 3. 从数据库获取留言显示
    var rsCount = 0;  //数据条数
    var maxPage = 0;  //最大页数
    var num = 1;
    var size = 3;
    showAjax();
    $(".btn1").click(function () {
        $(".messageShow").children().remove();
        if(num>1){
            --num;
        }
        console.log("btn1:" + num);
        showAjax();
    })
    $(".btn2").click(function () {
        $(".messageShow").children().remove();
        maxPage = Math.ceil(rsCount / size);
        num = num>=maxPage ? maxPage : ++num;
        console.log("btn2:" + num);
        showAjax();
    })
    // 显示留言Ajax封装
    function showAjax() {
        $.ajax({
            url: "http://localhost:8080/showMsg",
            type: "post",
            data:{
                "num": num,
                "size": size
            },
            dataType: "json",
            success: function (list) {
                console.log(list);
                $.each(list, function (key, value) {
                    if(typeof value === "object"){
                        $liuYan = createEle(value);
                        $(".messageShow").append($liuYan);
                    }else{
                        rsCount = value;
                    }

                })
            },
            error: function (xml) {
                console.log(xml);
            }
        })
    }

    // 4. 删除按钮监听

    // 创建节点 -- 根据obj对象调用属性
    function createEle(obj) {
        var $liuYan = $('<div class="info">\n' +
            '        <p class="user">\n' +
            '            用户名：<span class="userName">'+obj.username+'</span>\n' +
            '            <span class="userId">'+ obj.id +'</span>\n' +
            '        </p>\n' +
            '        <p class="infoText">'+ obj.message +'</p>\n' +
            '        <p class="infoOpen">\n' +
            '            <span class="infoTime">'+obj.time+'</span>\n' +
            '            <span>发表于：</span>\n' +
            '        </p>\n' +
            '    </div>');
        return $liuYan;
    }

    // 生成时间 -- 毫秒值
    // function createTime(time) {
    //     //获取系统时间
    //    var date = new Date(time);
    //     //拼接时间
    //     var arr = [date.getFullYear()+"-",
    //         date.getMonth()+1+ "-",
    //         date.getDate()+" ",
    //         date.getHours()+":",
    //         date.getMinutes()+":",
    //         date.getSeconds()];
    //     return arr.join("");
    // }
})