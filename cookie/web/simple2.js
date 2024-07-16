// 失去焦点事件

function UpperCase() {
    // 先获取frame的value
    var frame = document.getElementById("frame");
    frame.value = frame.value.toUpperCase();
}
// 加载页面后，进行动态绑定
window.onload = function () {
    var frame2 = document.getElementById("frame2");
    frame2.onblur = function () {

        frame2.value = frame2.value.toUpperCase();

    }
}

// 内容发生改变事件
window.onload = function () {
    var sel01 = document.getElementById("sel01");
    sel01.onchange = function () {
        alert("nice~")
    }
}

// 表单提交事件  onsubmit
// 静态方法
function register(){
    var username = document.getElementById("username");
    var pwd = document.getElementById("pwd");
    if (username.value == "" || pwd.value == ""){
        alert("账号或者用户名输入有误，请重新输入~~~~")
        return false;
    }
    return true;
}
// 动态方法
// 首先加载页面，加载结束后，运行方法
window.onload = function () {
    var login1 = document.getElementById("login1");
    login1.onsubmit = function () {
        if (login1.username.value == "" || login1.pwd.value == "") {
            alert("登录失败~~")
            return false;
        }
        return true;
    }
}

// 限制长度
window.onload = function () {

    var login2 = document.getElementById("login2");
    login2.onsubmit = function () {
        if (login2.username.value.length < 4 || login2.username.value.length > 6) {
            alert("用户名长度错误~")
            return false;
        }
        if (login2.pwd.value.length != 6){
            alert("密码不符合要求~")
            return false;
        }
        return true;
    }
}

// dom应用案例
// 点击获取弹窗案例（绑定点击事件）
window.onload = function () {
    var div01 = document.getElementById("div01")
    div01.onclick = function () {
        alert("chengkaixuan6666")
    }
}

//
function selectAll() {
    //alert("调用成功！！")
    let sports = document.getElementsByName("sport");
    // alert(sports)
    for (var i = 0; i < sports.length; i++) {
        sports[i].checked = true;
    }
}

function selectNone() {
    var sports = document.getElementsByName("sport");
    for (var i = 0; i < sports.length; i++) {
        sports[i].checked = false;
    }
}

function selectReverse() {
    var sports = document.getElementsByName("sport");
    for (var i = 0; i < sports.length; i++) {
        sports[i].checked = !sports[i].checked;
    }
}

function changeImage() {
    var inputccc = document.getElementById("input2")
    var imgs
        = document.getElementsByTagName("img");
    // alert(inputccc.value)
    if (inputccc.value == "猫猫~~，点击切换成小狗") {
        for (var i = 0; i < imgs.length; i++) {
            imgs[i].src = "image/" + (i+4) + ".png";
        }
        inputccc.value = "小狗~~，点击切换成小猫";
    } else if(inputccc.value == "小狗~~，点击切换成小猫") {
        for (var i = 0; i < imgs.length; i++) {
            imgs[i].src = "image/" + (i+1) + ".png";
        }
        inputccc.value = "猫猫~~，点击切换成小狗";
    }
    // var imgs
    //     = document.getElementsByTagName("img");
    // alert("猫猫数量为" + imgs.length);
    // for (var i = 0; i < imgs.length; i++) {
    //     imgs[i].src = "image/" + (i+4) + ".png";
    // }
}

function AddImage() {
    var img = document.createElement("img");
    img.src = 'image/2.png';
    img.height = '100';
    document.body.appendChild(img);
}

/*
* html-dom测试
* */
// 查找所有id为java的节点 动态绑定方法
window.onload = function () {
    var bin01 = document.getElementById("btn01");
    bin01.onclick = function () {
        var java = document.getElementById("java");
        alert("java节点文本：" + java.innerText);
    }
}

window.onload = function () {
    var btn02 = document.getElementById("btn02");
    btn02.onclick = function () {
        var options
            = document.getElementsByTagName("option");
        for (var i = 0; i　< options.length; i++) {
            alert("该optipn的值为" + options[i].innerText);
        }
    }
}

window.onload = function () {
    var btn03
        = document.getElementById("btn03");
    btn03.onclick = function () {
        var names
            = document.getElementsByName("sport");
        for (var i = 0; i < names.length; i++) {
            if (names[i].checked) {
                alert("该运动是：" + names[i].value);
            }
        }
    }
}

window.onload = function () {
    var btn04
        = document.getElementById("btn04");
    btn04.onclick = function () {
        var lis
            = document.getElementsByTagName("li");
        for (var i = 0; i < lis.length; i++) {
            alert(lis[i].innerText);
        }
    }
}

// 返回指定dom对象下的所有子节点
window.onload = function () {
    var btn05 
        = document.getElementById("btn05");
    btn05.onclick = function () {
        var childNode
            = document.getElementById("sel01").childNodes;
        var sel01 = document.getElementById("sel01");
        // 这个sel01本身就是一个htmlselectelement，有集合的特点
        // 获取第一个子节点
        alert(sel01.firstChild);
        // 获取第一个option节点
        alert(sel01[0]);
        for (var i = 0; i < childNode.length; i++) {
            if (childNode[i].selected) {
                alert(i + " " + childNode[i].innerText);
            }
        }
    }
}

// 找java的父节点
window.onload = function () {
    var btn07 
        = document.getElementById("btn07");
    btn07.onclick = function () {
        var java = document.getElementById("java");
        var parentNode = java.parentNode;
        alert("父节点为：" + parentNode.innerText);
        // 返回前后兄弟节点
        var childnodes = parentNode.childNodes;
        for (var i = 0; i < childnodes.length; i++) {
            alert(childnodes[i].innerText);
        }
    }
}

// 返回兄弟节点
window.onload = function () {
    var btn08 = document.getElementById("btn08");
    btn08.onclick = function () {
        var ct
            = document.getElementById("ct");
        // 读取ct的value值
        alert(ct.value);
        // 输出兄弟节点
        alert(ct.previousSibling.innerText);
        alert(ct.previousSibling.previousSibling.innerText);

        alert(ct.nextSibling.innerText);
        alert(ct.nextSibling.nextSibling.innerText);
    }
}

// 设置#person的文本域
window.onload = function () {
    var btn09
        = document.getElementById("btn10");
    btn09.onclick = function () {
        var person
            = document.getElementById("person");
        person.innerText = "ccc666";
    }
}









