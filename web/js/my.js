//使用ajax加载数据字典 生成select
/**
 *
 * @param typeCode 数据字典的类型
 * @param positionId 将下拉选放入的位置标签的id
 * @param selectName 生成下拉选时 select标签的name的属性值
 * @param selectedId 需要回显时，选中哪个option
 */
function loadSelect(typeCode, positionId, selectName, selectedId) {
    //创建select对象，将name属性指定
    var $select = $("<select name=" + selectName + "></select>");
    $select.append($("<option value=''>---请选择---</option>"));
    //使用jquery的ajax，访问后台Action
    $.post("${pageContext.request.contextPath}/BaseDictAction", {dict_type_code: typeCode}, function (data) {
        //遍历返回的jsonArray
        $.each(data, function (i, json) {
            var $option = $("<option value='" + json['dict_id'] + "'>" + json["dict_item_name"] + "</option>");
            //判断是否需要回显
            if (json['dict_id'] == selectedId) {
                $option.attr("selected", "selected")
            }
            //添加到select
            $select.append($option);
        });
    }, "json")
    //将组装好的select对象放入到页面的指定位置
    $("#" + positionId).append($select);

}