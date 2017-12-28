/**
 * Created by Administrator on 2017-12-12.
 */
/**
 * len=3,通过len长度获取0-999验证表达式
 * @param len
 */
function getIntRegByLength(len) {
    var obj = {};
    var reg,tem=len;
    if(typeof len === 'number' && len % 1 === 0){//整数
        var regNumber = "";
        while(tem > 0){
            regNumber += 9;
            tem--;
        }
        reg = '^(0|[1-9][0-9]{0,'+(len > 0 ? len -1 : len)+'})$';

        obj.reg = reg;
        obj.msg = '0-'+regNumber;
    }
    return obj;
}

function getDoubleRegByLength(len) {
    var obj = {};
    var reg,tem=len;
    if(typeof len === 'number' && len % 1 === 0){//整数
        var regNumber = "";
        while(tem > 0){
            regNumber += 9;
            tem--;
        }
        reg = '(^[1-9]([0-9]{1,'+(len > 0 ? len -1 : len)+'})?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)';

        obj.reg = reg;
        obj.msg = '0-'+regNumber+'.99';
    }
    return obj;
}
//layui失去光标校验
function layuiBlurCheck($id,verify,tips,$tip){
    if(!!!$id || !!!verify) return;//id或verify为空不校验
    var othis = $id
        ,vers = othis.attr('lay-verify').split('|')
        ,verType = othis.attr('lay-verType') //提示方式
        ,value = othis.val()
        ,stop=false;
    var  DANGER = 'layui-form-danger-input'
    othis.removeClass(DANGER);
    layui.each(vers, function(_, thisVer){
        var isTrue //是否命中校验
            ,errorText = '' //错误提示文本
            ,isFn = typeof verify[thisVer] === 'function';
        if(stop){return}
        //匹配验证规则
        if(verify[thisVer]){
            var isTrue = isFn ? errorText = verify[thisVer](value, othis) : !verify[thisVer][0].test(value);
            errorText = errorText || verify[thisVer][1];
            //如果是必填项或者非空命中校验，则阻止提交，弹出提示
            if(isTrue){
                othis.addClass(DANGER);
                //if(thisVer === 'required'){
                //    layer.msg(errorText, {icon: 5, shift: 6});
                //}else{
                    if(verType === 'tips'){
                        layer.tips(errorText, !!$tip ? $tip : othis, {tips: !!tips ? tips : 2,time:3000,tipsMore :true});
                    } else if(verType === 'alert') {
                        layer.alert(errorText, {title: '提示', shadeClose: true});
                    }else{
                        layer.msg(errorText, {icon: 5, shift: 6});
                    }
                //}
                if(thisVer == 'char'){
                    var t = $id.offset().top;
                    $(window).scrollTop(t);//滚动到锚点位置
                }
                stop = true;
            }
        }
    });
}


var NumberFormat= {
    /**
     * 格式化数字
     * Author : Z,Mingyu
     * 参数：
     * prmNum (Number) : 要格式化的数字
     * prmPtn (String) : 格式化规则，例如：#,##0.00
     * * prmNullValue : 当要格式化的数字为null、空或非数字时，返回的结果。默认为0
     */
    formatNum: function (prmNum, prmPtn, prmNullValue) {
        var nullValue = prmNullValue || prmNullValue == "" ? prmNullValue : 0;
        if (prmNum == "" || prmNum == null) return nullValue;
        prmNum = String(prmNum).replace(/\,/g, "");
        if (isNaN(prmNum)) return nullValue;
        if (prmPtn == "" || prmPtn == null) return prmNum;
        var ptnLen = prmPtn.length, pointIndex = prmPtn.indexOf("."), groupIndex = prmPtn.indexOf(","),
            pointLen = (pointIndex == -1 ? 0 : ptnLen - pointIndex - 1), pointStr = "", pointNumIndex;
        prmNum = parseFloat(prmNum).toFixed(pointLen) + "";
        if (groupIndex != -1) {
            if (pointIndex == -1) {
                pointIndex = ptnLen;
            } else {
                pointNumIndex = prmNum.indexOf(".");
                pointStr = prmNum.substring(pointNumIndex, prmNum.length);
                prmNum = prmNum.substring(0, pointNumIndex);
            }
            var len = pointIndex - groupIndex - 1, reg = new RegExp("(-?\\d+)(\\d{" + len + "})");
            while (reg.test(prmNum)) prmNum = prmNum.replace(reg, "$1,$2");
        }
        return prmNum + pointStr;
    }
}

function formatInt(value){
    return NumberFormat.formatNum(value,"#,##0","");
}

function formatDouble(value){
    return NumberFormat.formatNum(value,"#,##0.00","");
}

function formatDate(value){
    var date = new Date(value);
    var d1 = date.getDate();
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    return y + '-' + m +'-' + d1;
}

