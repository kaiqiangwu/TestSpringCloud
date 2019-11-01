$(window).preloader();

function getCardIdInfor() {
    $.ajax({
        url: "/medicalExamination/getCardIdInfor",
        type: "post",
        success: function (result) {
            if (result.state == 1) {
                $("#cardId").val(result.data.cardId);
                $("#name").val(result.data.name);
                $("#sex").val(result.data.sex);
                $("#nationality").val(result.data.nationality);
                $("#age").val(result.data.age)
            } else {
                swal(result.message, "", "error")
            }
        }
    })
}

function savemedicalExaminationInfo() {

    var medicalExaminationInfoReqVO = {
        cardId: $("#cardId").val(),
        bodyTemperature: $("#bodyTemperature").val(),
        pulse: $("#pulse").val(),
        heartRate: $("#heartRate").val(),
        bloodPressure: $("#bloodPressure").val(),
        examinationCost: $("#examinationCost").val()
    };

    $.ajax({
        url: "/medicalExamination/saveMedicalExaminationInfo",
        type: "post",
        data: JSON.stringify(medicalExaminationInfoReqVO),
        contentType: "application/json",
        success: function (result) {
        	if (result.state == 1) {
                swal({
                    title: "保存成功！",
                    type: "success",
                }, function () {
                    setTimeout(function () {
                        window.location.reload()
                    }, 500)
                })
            } else {
                swal(result.data, "", "error")
            }
        }
    })

}