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