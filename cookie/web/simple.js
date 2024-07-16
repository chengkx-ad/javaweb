console.log("test成功");
num1 = 100;
num2 = "100";
name = "成凯璇";
//alert(num1);
//alert(name);
console.log(num1 == num2); // 比较值的大小
console.log(num1 === num2); // 比较值和数据类型

function hi(){
    // alert("hi ccc")
}

var f1 = function () {
    console.log("执行成功")
}

function f2(){
    var num = 0;
    for(var i=0; i < arguments.length; i++) {
        if (typeof (arguments[i]) == "number") {
            num = num + arguments[i];
        }
    }
    return num;
}
function f3(){
    console.log(f2(1,2,3,4))
}

// 事件绑定

// 1\某个页面或者图像被加载完成
function sayOk(){
    console.log("静态注册  onload~~")
}

// 动态绑定  页面加载成功以后进行动态绑定
window.onload = function () {
    console.log("动态注册  onload~~")
    var bt01 = document.getElementById("bt01");
    bt01.onclick = function () {
        alert("点击了按钮");
    }
}

// 2\onclick 点击事件
// 静态注册
function f4(){
    alert("加油！！！奥里给")
}
// 动态

