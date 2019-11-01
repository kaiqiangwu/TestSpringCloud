$(window).preloader();

Split(['#myprescription', '#tolloperation'], {
    sizes: [52, 48],
    minSize: [770, 730]
});

function getCardIdInfor() {
    $.ajax({
        url: "/toll/getCardIdInfor",
        type: "post",
        success: function (result) {
            if (null == result.data.message) {
                $("#cardId").val(result.data.cardId);
            } else {
                swal(result.message, "", "error")
            }
        }
    })
}


var tollStatus = '';
$('.tollStatus').chosen({disable_search: true, allow_single_deselect: true,}).change(function () {

    tollStatus = $(".tollStatus option:selected").val();
});

$(function () {
    //1.初始化Table
    /*var oTable = new TableInit();
    oTable.Init();*/

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#MedicalRecord').bootstrapTable({
            url: '/toll/getAllMedicalRecord',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: false,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: false,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            // sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            queryParamsType: "",
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 0,             //最少允许的列数
            clickToSelect: false,                //是否启用点击选中行
            height: 200,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "loginIp",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                  //是否显示父子表
            responseHandler: function (res) {
		    	            //在ajax获取到数据，渲染表格之前，修改数据源
		    	            return res.data;
//		    	                "total" : res.totalElementsNumber, //总页数,前面的key必须为"total"
		    	                //"rows" : res.data //这个就是我们自定义的数据，必须这么写
        	    		},
            columns: [{
                field: 'no',
                title: '序号',
                sortable: true,
                align: "center",
                width: 40,
                formatter: function (value, row, index) {
                	
                    return index + 1
                }
            }, {
                field: 'department',
                title: '科室',
                align: 'center',
                valign: 'middle',
                fontSize: 14
            }, {
                field: 'registerType',
                title: '挂号类型',
                align: 'center',
                valign: 'middle',
                fontSize: 14
            }, {


                field: 'doctorName',
                title: '医生名称',
                align: 'center',
                valign: 'middle',
                fontSize: 14

            }, {
                field: 'prescriptionNum',
                title: '处方号',
                align: 'center',
                valign: 'middle',
                fontSize: 14
            }, {
                field: 'operation',
                title: '操作',
                align: 'center',

                events: operateEvents,//给按钮注册事件
                formatter: addFunctionAlty//表格中增加按钮
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的

            cardId: $("#cardId").val(),
            tollStatus: tollStatus
        };
        return temp;
    };
    return oTableInit;
};
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};

function addFunctionAlty() {
    return [

        '<button id="btn_toll" class="btn btn-outline-primary" >选择</button>  '
    ].join('');
}
var registerId = '';
var prescriptionNum = '';
window.operateEvents = {
    // 选择病历收费
    "click #btn_toll": function (e, value, row, index) {
        registerId = row.registerId;
        var cardId = $("#cardId").val();
        var doctorName = row.doctorName;
        var department = row.department;
        prescriptionNum = row.prescriptionNum;
        $.ajax({
            url: "/toll/getMedicalRecord",
            type: "post",
            data: {
                "prescriptionNum": prescriptionNum,
                "cardId": cardId
            },
            success: function (result) {
                if (result.data != null) {
                    $("#name").val(result.data.name);
                    $("#sex").val(result.data.sex);
                    $("#nationality").val(result.data.nationality);
                    $("#age").val(result.data.age);
                    $("#prescriptionNum").val(prescriptionNum);
                    $("#date").val(result.data.medicalRecord.createDatetime);
                    $("#department").val(department);
                    $("#diagnosisResult").val(result.data.medicalRecord.diagnosisResult);
                    $("#medicalOrder").html(result.data.medicalRecord.medicalOrder);
                    $("#drugCost").val(result.data.medicalRecord.drugCost);
                    $("#doctorName").val(doctorName);
                    $("#prescription").html(result.data.medicalRecord.prescription);
                    $("#examinationCost").val(result.data.treatmentPrice);
                    $("#total").val(parseFloat(result.data.medicalRecord.drugCost) + parseFloat(result.data.treatmentPrice))
                    
                }
            }
        })
    }
};

function getMedicalRecord() {
	var cardId =  $('#cardId').val();
	if(cardId==""){
		alert("请输入卡号")
		$('#MedicalRecord').bootstrapTable("destroy");
	}else{
		$('#MedicalRecord').bootstrapTable("destroy");
	    //1.初始化Table
	    var oTable = new TableInit();
	    oTable.Init();

	    //2.初始化Button的点击事件
	    var oButtonInit = new ButtonInit();
	    oButtonInit.Init();
	}
    
}

function printPrescription() {

    $("#myprescription").jqprint();
}

var payType = '';

$('.payType').chosen({disable_search: true}).change(function () {

    payType = $(".payType option:selected").val();

    if (payType == "现金") {
        $("#money").css("display", "block");
        $("#apay").css("display", "none");
        $("#payMoney").val("");
        $("#Change").val("")
    }
    else if (payType == "支付宝") {
        $("#money").css("display", "none");
        $("#apay").css("display", "block")
    } else {
        $("#money").css("display", "none");
        $("#apay").css("display", "none")
    }
});


function getChange() {
    var m = $("#payMoney").val();
    var n = $("#total").val();
    var x = m - n;
    $("#Change").val(x)
}

function saveTollInfo() {

    var cardId = $("#cardId").val();
    var total = $("#total").val();

    var medicalRecordPojo = {
        "registerId": registerId,
        "prescriptionnum": prescriptionNum
    };
    

    if (cardId == null || cardId == '') {
        swal("请填入就诊卡号！", "", "error");
        return false;
    }

    if (total == null || total == '') {
        swal("请选择收费的处方笺！", "", "error");
        return false;
    }

    $.ajax({
        url: "/toll/saveTollInfo",
        type: "post",
        contentType: "application/json",
        dataType:"json",
        data:JSON.stringify(medicalRecordPojo),
        success: function (result) {
            if (result.message == "SUCCESS") {
                swal({
                    title: result.message,
                    type: "success",
                    showCancelButton: true,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true
                }, function () {
                    window.location.reload()
                })
            } else {
                swal(result.message, "", "error")
            }
        }

    })

}