var totalRecord,currentPage;

function reset_form(ele){
    $(ele)[0].reset();

    //清空表单样式
    $(ele).find("*").removeClass("has-error has-success");
    $(ele).find(".help-block").text("");
}

//显示校验信息
function show_validate_msg(ele,status,msg){
    //清楚当前元素校验状态
    $(ele).parent().removeClass("has-success has-error");
    $(ele).next("span").text("");
    if("success" == status) {
        $(ele).parent().addClass("has-success");
        $(ele).next("span").text(msg);
    } else if("error" == status) {
        $(ele).parent().addClass("has-error");
        $(ele).next("span").text(msg);
    }

}

//2、解析并显示分页信息
function build_page_info(result,ele) {
    $(ele).empty();
    $(ele).css({"font-size":"20px","color":"darkblue"});
    $(ele).append("当前第"+result.extend.pageInfo.pageNum+"页，总"+
        result.extend.pageInfo.pages+"页，总"
        +result.extend.pageInfo.total+"条记录");
    totalRecord = result.extend.pageInfo.total;
    currentPage = result.extend.pageInfo.pageNum;
}


//3、解析并显示分页条
function build_page_nav(result,ele) {
    $(ele).empty();
    var ul = $("<ul></ul>").addClass("pagination");
    var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
    var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
    if(result.extend.pageInfo.hasPreviousPage == false){
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    } else {
        firstPageLi.click(function () {
            to_page(1);
        })

        prePageLi.click(function () {
            to_page(result.extend.pageInfo.pageNum-1);
        })
    }


    var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
    if(result.extend.pageInfo.hasNextPage == false){
        lastPageLi.addClass("disabled");
        nextPageLi.addClass("disabled");
    } else {
        lastPageLi.click(function () {
            to_page(result.extend.pageInfo.pages);
        })

        nextPageLi.click(function () {
            to_page(result.extend.pageInfo.pageNum+1);
        })
    }


    ul.append(firstPageLi).append(prePageLi);

    $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
        if(result.extend.pageInfo.pageNum == item) {
            numLi.addClass("active");
        }
        numLi.click(function () {
            to_page(item);
        });

        ul.append(numLi);
    });

    ul.append(nextPageLi).append(lastPageLi);

    var navEle = $("<nav></nav>")
        .addClass("Page navigation")
        .css("text-align","right")
        .append(ul).appendTo("#page_nav_area");
}


//到首页
function to_firstpage(content_div,page){
    content_div.empty();
    content_div.load(page);
    content_div.attr(page)
}

//获取所有书籍类别显示在下拉框中
function get_allBookstyle(ele,url) {
    //清空下拉列表
    $(ele).empty();
    $.ajax({
        url:url,
        type:"GET",
        async:false,
        success:function (result) {
            $("<option value='' hidden></option>").append("--按选择书籍类别--").appendTo(ele);
            $.each(result.extend.bookstyleList,function () {
                var optionEle = $("<option></option>").append(this.bookstyleName).attr("value",this.bookstyleId);
                optionEle.appendTo(ele);
            })
        }
    });
}


function my_alert(title,content,type) {
    $.alert({
        title: title,
        content: content,
        type: type
    })
}

// 时间戳转化为日期
function timestamp2Date(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
    var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var m = (date.getMinutes() <10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    var s = (date.getSeconds() <10 ? '0' + date.getSeconds() : date.getSeconds());
    return Y+M+D+h+m+s;
};


function isInteger(n){
    var reg =/^[0-9]+?$/;;
    return reg.test(n)

}


function isFloat(n){
    var reg = /^(([^0][0-9]+|0)\.([0-9]{1,2}))$/
    return reg.test(n)
}
