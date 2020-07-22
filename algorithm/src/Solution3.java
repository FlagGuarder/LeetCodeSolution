import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution3 {
    /*
    * 测试用例：
    * 空字符开头："   434fdfd"，"   fff3434fdf，"   fsfsdf"

    * 数字开头"424    "，"342fsfs"，"424fsdf    "，"432   erwer"
    * 空字符*/
    public int myAtoi(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);

        int num = 0;
        if(matcher.find()){
            try{
                num = Integer.parseInt(str.substring(matcher.start(),matcher.end()));

            }catch (Exception e){
                num = '-' == str.charAt(0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return num;
    }


}
