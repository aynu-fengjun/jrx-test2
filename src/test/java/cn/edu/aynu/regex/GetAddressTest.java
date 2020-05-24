package cn.edu.aynu.regex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAddressTest {

    public static void main(String[] args) {
        //调用正则表达式匹配方法
       /* List<Map<String,String>> address = addressRegex("中华人民共和国吉林省长春市二道区临河街万兴小区4栋2门");*/
        List<Map<String,String>> address = addressRegex("中华人民共和国河北省石家庄市武林区砂石街河东小区8栋1单元");
        //获取国家信息
        System.out.println(address.get(0).get("country"));
        //获取省份信息
        System.out.println(address.get(0).get("province"));
        //获取城市信息
        System.out.println(address.get(0).get("city"));
        //获取区信息
        System.out.println(address.get(0).get("county"));
        //获取街道信息
        System.out.println(address.get(0).get("town"));
        //获取门牌号信息
        System.out.println(address.get(0).get("village"));

    }

    private static List<Map<String, String>> addressRegex(String address) {
        //编写正则
        String regex="(?<country>.*?国)(?<province>[^省]+自治区|.*?省|.*?行政区)(?<city>[^市]+自治州|市辖区|.*?市)(?<county>[^县]+县|.*?区)(?<town>.*?街)(?<village>.*)";
        //编译正则表达式
        Pattern pattern = Pattern.compile(regex);
        //获取匹配器
        Matcher matcher = pattern.matcher(address);
        String country=null,province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        //循环获取分组后信息
        while(matcher.find()){
            row=new LinkedHashMap<String,String>();

            country=matcher.group("country");
            row.put("country", country==null?"":country.trim());

            province=matcher.group("province");
            row.put("province", province==null?"":province.trim());

            city=matcher.group("city");
            row.put("city", city==null?"":city.trim());

            county=matcher.group("county");
            row.put("county", county==null?"":county.trim());

            town=matcher.group("town");
            row.put("town", town==null?"":town.trim());

            village=matcher.group("village");
            row.put("village", village==null?"":village.trim());
            list.add(row);
        }
        return list;
    }
}
