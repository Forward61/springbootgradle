package com.ifreedom.freedom.pinyinpack;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @Author: freedom
 * @Date: 2021-01-20 10:10
 **/
public class WriteFileExample {

    /**
     * 启用 使用中
     * 使用FileOutputStream来写入txt文件
     * @param txtPath txt文件路径
     * @param content 需要写入的文本
     */
    public static void writeTxt(String txtPath,String content){
        FileOutputStream fileOutputStream = null;
        File file = new File(txtPath);
        try {
            if(file.exists()){
                //判断文件是否存在，如果不存在就新建一个txt
                file.createNewFile();
            }
            if (StringUtils.isEmpty(content)){
                content = "1";
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 启用使用中
     * 传入txt路径读取txt文件
     * @param txtPath
     * @return 返回读取到的内容
     */
    public static String readTxt(String txtPath) {
        File file = new File(txtPath);
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = bufferedReader.readLine()) != null){
                    sb.append(text);
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "0";
    }


    /**弃用
     *从文件中读取内容
     */
    public static void readTxtFile(String filePath){
        try {
            String encoding= "GBK" ;
            File file= new File(filePath);
            if (file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding); //考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null ;
                while ((lineTxt = bufferedReader.readLine()) != null ){
                    System.out.println(lineTxt);
                }
                read.close();
            } else {
                System.out.println( "找不到指定的文件" );
            }
        } catch (Exception e) {
            System.out.println( "读取文件内容出错" );
            e.printStackTrace();
        }

    }




    /**
     * 弃用
     * 读取文件内容
     * @param fileName
     * @return
     */
    public static String readFileContent(String fileName) {
        String str="";
        String returnStr = "";

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str1="";

            while ((str1 = in.readLine()) != null) {
                System.out.println("文本内容："+str1);
            }
            //BufferedReader in = new BufferedReader(new FileReader(fileName));
            //while ((str=in.readLine()) != null) {
            //
            //    returnStr = str;
            //    System.out.println("zh文本内容"+ returnStr);
            //    //return str;
            //
            //}
        } catch (IOException e) {
            return returnStr;
        }
        return returnStr;
        //File file = new File(fileName);
        //BufferedReader reader = null;
        //StringBuffer sbf = new StringBuffer();
        //try {
        //    reader = new BufferedReader(new FileReader(file));
        //    String tempStr=reader.readLine();
        //    while (tempStr  != null) {
        //        sbf.append(tempStr);
        //    }
        //    reader.close();
        //    return sbf.toString();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //} finally {
        //    if (reader != null) {
        //        try {
        //            reader.close();
        //        } catch (IOException e1) {
        //            e1.printStackTrace();
        //        }
        //    }
        //}
        //return sbf.toString();
    }

}
