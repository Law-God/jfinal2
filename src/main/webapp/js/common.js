/**
 * Created by Administrator on 2017-12-12.
 */
/**
 * len=3,通过len长度获取0-999验证表达式
 * @param len
 */
function getRegByIntLength(len) {
    var obj = {};
    var reg;
    if(typeof len === 'number' && len % 1 === 0){//整数
        var regNumber = "";
        /*while(len > 0){
            regNumber += 9;
            len--;
        }*/
        reg = '[0-9]{1,'+len+'}';

        obj.reg = reg;
        obj.msg = '0-'+regNumber;
    }
    return obj;
}