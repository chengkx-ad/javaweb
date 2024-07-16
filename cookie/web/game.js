var cock_top = 200;
var cock_left = 200;
var wugui_height = 67;
var wugui_width = 94;

var cock_height = 73;
var cock_width = 76;
function move(obj) {
    // 获取乌龟的dom对象
    var wugui
        = document.getElementById("wugui");
    // 获取top和left的值
    var wugui_top = wugui.style.top;
    var wugui_left = wugui.style.left;

    // alert(wugui_top)
    // alert(wugui_left)
    // 使乌龟动起来
    // 注意  上面的两个值 是string 并不是number 类型转换
    var wugui_leftnum = parseInt(wugui_left.substring(0, wugui_left.indexOf("p")));
    var wugui_topnum = parseInt(wugui_top.substring(0, wugui_top.indexOf("p")));

    // 利用value使乌龟动起来
    if (obj.value === "向上走") {
        wugui_topnum -= 10;
        wugui.style.top = wugui_topnum + "px";
    } else if (obj.value === "向下走") {
        wugui_topnum += 10;
        wugui.style.top = wugui_topnum + "px";
    }else if (obj.value === "向左走") {
        wugui_leftnum -= 10;
        wugui.style.left = wugui_leftnum + "px";
    }else if (obj.value === "向右走") {
        wugui_leftnum += 10;
        wugui.style.left = wugui_leftnum + "px";
    }

    // 如何判断它们发生了重叠呢?
    // 定义两个距离，两个图片的上边沿的距离以及左边沿的距离
    var top = Math.abs(wugui_topnum - cock_top);
    var left = Math.abs(wugui_leftnum - cock_left);

    // 重叠？
    // 当距离小于图片的高度，并且左距离小于图片的宽度时发生重叠
    // 默认为0 没有发生重叠
    var yy = 0;
    var xx = 0;

    // 应该有四种情况  上下
    // 左右
    if (wugui_top < cock_top) {
        if (top < wugui_height) {
            yy = 1;
        }
    }else{
        if (top < cock_height) {
            yy = 1;
        }
    }
    if (wugui_left  < cock_left) {
        if (left < wugui_width) {
            xx = 1;
        }
    }else{
        if (left < cock_width) {
            xx = 1;
        }
    }

    if (xx && yy) {
        alert("乌龟牛逼!!")
        // 将乌龟置于原位
        wugui.style.top = "120px";
        wugui.style.left = "100px";
    }

}