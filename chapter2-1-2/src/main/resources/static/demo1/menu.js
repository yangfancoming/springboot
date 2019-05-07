//常量
var posLeft;
var posTop;
//一级菜单ID 必填
var firstMenuArr = ["firstli_0", "secondli_1", "thirdli_2"];
//二级菜单的ID 必填
var secondMenuArr = ["firstMenu", "secondMenu", "thirdMenu"];
$(document).ready(function () {
  //鼠标右键
  $(document).contextmenu(function (e) {
    var winWidth = $(document).width();
    var winHeight = $(document).height();
    var posX = e.pageX;
    var posY = e.pageY;
    var menuWidth = $(".contextmenu").width();
    var menuHeight = $(".contextmenu").height();
    var secMargin = 10;
    if (posX + menuWidth + secMargin >= winWidth
      && posY + menuHeight + secMargin >= winHeight) {
      posLeft = posX - menuWidth - secMargin + "px";
      posTop = posY - menuHeight - secMargin + "px";
    }
    else if (posX + menuWidth + secMargin >= winWidth) {
      posLeft = posX - menuWidth - secMargin + "px";
      posTop = posY + secMargin + "px";
    }
    else if (posY + menuHeight + secMargin >= winHeight) {
      posLeft = posX + secMargin + "px";
      posTop = posY - menuHeight - secMargin + "px";
    }
    else {
      posLeft = posX + secMargin + "px";
      posTop = posY + secMargin + "px";
    };
    $('.contextmenu').css({
      "left": posLeft,
      "top": posTop
    }).show();
    return false;
  });
  //任意点击事件都可以隐藏菜单
  $(document).click(function () {
    for (var i = 0; i < secondMenuArr.length; i++) {
      if (document.getElementById(secondMenuArr[i]).getAttribute("flag") != "true") {
        $("#" + secondMenuArr[i]).css({ display: "none" });
      }
    }
    $('.contextmenu').hide();
  });
  for (var i = 0; i < firstMenuArr.length; i++) {
    $('#' + firstMenuArr[i]).mouseover(function () {
      var menuLiId = this.id;
      var arr = menuLiId.split("_");
      var num = arr[1];
      if ($("#" + secondMenuArr[num]).css('display') == 'none') {
        var left = Number(posLeft.substring(0, posLeft.length - 2)) + 150 + "px";
        var top = Number(posTop.substring(0, posTop.length - 2)) + num * 39 + "px";
        $("#" + secondMenuArr[num]).css({ display: "block", left: left, top: top });
      } else if ($("#" + secondMenuArr[num]).css('display') != 'none' && document.getElementById(secondMenuArr[num]).getAttribute("flag") == "true") {
        flash("#" + secondMenuArr[num]);
        flash("#" + menuLiId);
      }
    })
  }

  //鼠标移入一级菜单第一格
  // $('#firstli').mouseover(function () {
  //   if ($('#firstMenu').css('display') == 'none') {
  //     var left = Number(posLeft.substring(0, posLeft.length - 2)) + 150 + "px";
  //     var top = Number(posTop.substring(0, posTop.length - 2)) + "px";
  //     $("#" + secondMenuArr[0]).css({ display: "block", left: left, top: top });
  //   } else if ($('#firstMenu').css('display') != 'none' && document.getElementById("firstMenu").getAttribute("flag") == "true") {
  //     flash("#firstMenu");
  //   }
  // })
  //鼠标移入一级菜单第二格
  // $("#secondli").mouseover(function () {
  //   if ($('#secondMenu').css('display') == 'none') {
  //     var left = Number(posLeft.substring(0, posLeft.length - 2)) + 150 + "px";
  //     var top = Number(posTop.substring(0, posTop.length - 2)) + 39 * 1 + "px";
  //     $("#" + secondMenuArr[1]).css({ display: "block", left: left, top: top });
  //   } else if ($('#secondMenu').css('display') != 'none' && document.getElementById("secondMenu").getAttribute("flag") == "true") {
  //     flash("#secondMenu");
  //   }
  // })
  //鼠标移入一级菜单第三格
  // $("#thirdli").mouseover(function () {
  //   if ($('#thirdMenu').css('display') == 'none') {
  //     var left = Number(posLeft.substring(0, posLeft.length - 2)) + 150 + "px";
  //     var top = Number(posTop.substring(0, posTop.length - 2)) + 39 * 2 + "px";
  //     $("#" + secondMenuArr[2]).css({ display: "block", left: left, top: top });
  //   } else if ($('#thirdMenu').css('display') != 'none' && document.getElementById("thirdMenu").getAttribute("flag") == "true") {
  //     flash("#thirdMenu");
  //   }
  // })

  //监听body鼠标移动
  $("#menuBody").mousemove(function () {
    var mousePosLeft = 0;
    var mousePosTop = 0;
    var x = event.clientX;
    var y = event.clientY;
    if (typeof (posLeft) != "undefined") {
      mousePosLeft = Number(posLeft.substring(0, posLeft.length - 2));
      mousePosTop = Number(posTop.substring(0, posTop.length - 2));
      //获取一级菜单li长度
      var length = $("#menu li").length;
      //移除一级菜单上边，左边，下边都销毁所有二级菜单
      if (x < mousePosLeft || y < mousePosTop || (x >= mousePosLeft && x <= mousePosLeft + 150 && y > mousePosTop * 39 * length)) {
        for (var i = 0; i < secondMenuArr.length; i++) {
          if (document.getElementById(secondMenuArr[i]).getAttribute("flag") != "true") {
            $("#" + secondMenuArr[i]).css({ display: "none" });
          }
        }
      }
      //在一级菜单中下移鼠标
      for (var j = 0; j < length; j++) {
        if (x >= mousePosLeft && x <= mousePosLeft + 150 && y > mousePosTop + 39 * (j + 1)) {
          if (document.getElementById(secondMenuArr[j]).getAttribute("flag") != "true") {
            $("#" + secondMenuArr[j]).css({ display: "none" });
          }
        }
      }
      //在一级菜单中上移鼠标
      for (var k = 0; k < length - 1; k++) {
        if (x >= mousePosLeft && x <= mousePosLeft + 150 && y < mousePosTop + 39 * (k + 1)) {
          if (document.getElementById(secondMenuArr[k + 1]).getAttribute("flag") != "true") {
            $("#" + secondMenuArr[k + 1]).css({ display: "none" });
          }
        }
      }
      //移除二级菜单右侧，销毁所有二级菜单
      if (x >= mousePosLeft + 300) {
        for (var i = 0; i < secondMenuArr.length; i++) {
          if (document.getElementById(secondMenuArr[i]).getAttribute("flag") != "true") {
            $("#" + secondMenuArr[i]).css({ display: "none" });
          }
        }
      }
    }
  })
});

//点击钉
function onDingClick(index, temp) {
  var left = Number(posLeft.substring(0, posLeft.length - 2)) + 150 + "px";
  var top = Number(posTop.substring(0, posTop.length - 2)) + (Number(temp) - 1) * 39 + "px";
  //先销毁原有对象
  $('#' + index).css({ display: "none" });
  //使用dom对象设置一个flag
  var flag = document.getElementById(index).getAttribute("flag");
  //flag为true说明已经钉上了，把钉起下来
  if (flag == "true") {
    document.getElementById(index).setAttribute("flag", "false");
    $('#' + index).css({ display: "none" });
  } else {//钉上去，并加一个flag
    document.getElementById(index).setAttribute("flag", "true");
    $('#' + index).css({ display: "block", position: "absolute", left: left, top: top });
  }

  //添加dom的移动事件
  var move = false;
  var _x, _y;
  var presentId;
  var _h, _w;
  $("#" + index).mousedown(function (e) {
    presentId = e.currentTarget.id;
    var length = $("#" + presentId + " li").length;
    // console.log(length);
    _h = (length + 1) * 39;
    move = true;
    _x = e.pageX - parseInt($("#" + index).css("left"));
    _y = e.pageY - parseInt($("#" + index).css("top"));
  });
  var height = document.body.clientHeight;
  var width = document.documentElement.clientWidth;
  $(document).mousemove(function (e) {
    if (move) {
      var x = e.pageX - _x;//控件左上角到屏幕左上角的相对位置 
      var y = e.pageY - _y;
      if (x >= 0 && y >= 0 && x <= width - 150 && y <= height - _h) {
        $("#" + index).css({ top: y, left: x, opacity: "0.6" });
      }
    }
  }).mouseup(function () {
    $("#" + index).css({ opacity: "1" });
    move = false;
  });
}
//已钉上的对象，鼠标再次悬浮一级菜单时，闪烁一次
function flash(obj) {
  $(obj).animate(
    { opacity: "0" }, 250);
  $(obj).animate(
    { opacity: "1" }, 499);
}