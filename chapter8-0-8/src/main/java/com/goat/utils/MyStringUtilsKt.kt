package utils

/**
 * Created by 64274 on 2018/7/13.
 * @Description: TODO
 * @author  山羊来了
 * @date 2018/7/13---20:27
 */
class  MyStringUtilsKt{

    companion object {
        fun strSplit(str:String,len:Int): Array<String?>{
            var goat = str
            val length = goat.length/len
            var strArr = arrayOfNulls<String>(length)
            for (temp in strArr.indices){
                strArr[temp] = goat.substring(0,len)
                goat = goat.substring(len)
            }
            return strArr
        }
    }

}