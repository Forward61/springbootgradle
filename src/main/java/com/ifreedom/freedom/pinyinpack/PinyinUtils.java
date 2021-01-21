package com.ifreedom.freedom.pinyinpack;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.sourceforge.pinyin4j.format.HanyuPinyinToneType.WITHOUT_TONE;
import static net.sourceforge.pinyin4j.format.HanyuPinyinVCharType.WITH_V;

/**
 * @Author: freedom
 * @Date: 2021-01-20 09:09
 **/
public class PinyinUtils {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        String str = "今天天气 真好！good! 率";

        HanyuPinyinOutputFormat fmt = new HanyuPinyinOutputFormat();

        String pinyin1 = PinyinHelper.toHanYuPinyinString(str,fmt,"",true);
        //String pinyin1 = PinyinHelper.toHanYuPinyinString(str, fmt, "");
        System.out.println(pinyin1); // jin1tian1tian1qi4 zhen1hao3！good! lu:4

        String pinyin2 = PinyinHelper.toHanYuPinyinString(str, fmt, "",false);
        System.out.println(pinyin2); // jin1tian1tian1qi4zhen1hao3lu:4

        String pinyin3 = PinyinHelper.toHanYuPinyinString(str, fmt, "-",false);
        System.out.println(pinyin3); // jin1-tian1-tian1-qi4- zhen1-hao3-！good! lu:4

        HanyuPinyinOutputFormat fmt2 = new HanyuPinyinOutputFormat();
        //fmt2.setCaseType(UPPERCASE);
        fmt2.setToneType(WITHOUT_TONE);
        fmt2.setVCharType(WITH_V);
        String pinyin4 = PinyinHelper.toHanYuPinyinString(str, fmt2, "",false);
        System.out.println(pinyin4); // JIN TIAN TIAN QI ZHEN HAO LV


        System.out.println(convertHanzi2Pinyin("我是中国人123abc",true));
        System.out.println(convertHanzi2Pinyin("我是中国人123abc",false));
        String filePath = "src/main/resources/seq.txt";

        //String seqId = WriteFileExample.readTxt(filePath);
        //Integer seqIdint = Integer.valueOf(seqId)==0?Integer.valueOf(seqId)+1:Integer.valueOf(seqId)+4;
        //WriteFileExample.writeTxt(filePath,StringUtils.leftPad(""+seqId,4,"0"));
        //System.out.println(StringUtils.leftPad(seqId,4, "0"));
        String alternateAccount1 = getExBfAlternateAccount("张翰",filePath);
        String alternateAccount2 = getExBfAlternateAccount("彦斌",filePath);
        String alternateAccount3 = getExBfAlternateAccount("张恒",filePath);
        System.out.println("第一个是：" + alternateAccount1);
        System.out.println("第二个是：" + alternateAccount2);
        System.out.println("第三个是：" + alternateAccount3);
    }


    public static String getExBfAlternateAccount(String realName,String filePath) throws BadHanyuPinyinOutputFormatCombination {

        String alternateAccount = "";

        String firstLetter = convertHanzi2Pinyin(realName,false);


        String seqId = WriteFileExample.readTxt(filePath);
        Integer seqIdint = Integer.valueOf(seqId)==0?Integer.valueOf(seqId)+1:Integer.valueOf(seqId)+4;
        WriteFileExample.writeTxt(filePath,StringUtils.leftPad(""+seqIdint,4,"0"));
        System.out.println(
                alternateAccount = firstLetter + StringUtils.leftPad(""+seqIdint,4, "0"));
        return alternateAccount;
    }



    /***
     * 将汉字转成拼音(取首字母或全拼)
     * @param hanzi
     * @param full 是否全拼
     * @return
     */
    public static String convertHanzi2Pinyin(String hanzi,boolean full)
    {
        /***
         * ^[\u2E80-\u9FFF]+$ 匹配所有东亚区的语言
         * ^[\u4E00-\u9FFF]+$ 匹配简体和繁体
         * ^[\u4E00-\u9FA5]+$ 匹配简体
         */
        String regExp="^[\u4E00-\u9FFF]+$";
        StringBuffer sb=new StringBuffer();
        if(hanzi==null||"".equals(hanzi.trim()))
        {
            return "";
        }
        String pinyin="";
        for(int i=0;i<hanzi.length();i++)
        {
            char unit=hanzi.charAt(i);
            if(match(String.valueOf(unit),regExp))//是汉字，则转拼音
            {
                pinyin=convertSingleHanzi2Pinyin(unit);
                if(full)
                {
                    sb.append(pinyin);
                }
                else
                {
                    sb.append(pinyin.charAt(0));
                }
            }
            else
            {
                sb.append(unit);
            }
        }
        return sb.toString();
    }
    /***
     * 将单个汉字转成拼音
     * @param hanzi
     * @return
     */
    private static String convertSingleHanzi2Pinyin(char hanzi)
    {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String[] res;
        StringBuffer sb=new StringBuffer();
        try {
            res = PinyinHelper.toHanyuPinyinStringArray(hanzi,outputFormat);
            sb.append(res[0]);//对于多音字，只用第一个拼音
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return sb.toString();
    }
    /***
     * @param str 源字符串
     * @param regex 正则表达式
     * @return 是否匹配
     */
    public static boolean match(String str,String regex)
    {
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        return matcher.find();
    }

}
