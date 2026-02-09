package com.zhurong.utils.TheOthers;

import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFUtils;
import com.linuxense.javadbf.DBFWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * dbf工具类
 * 2019/2/28
 */
public class DBFUtil {

    //定义 DBFWriter 实例用来写 DBF 文件
    private static final DBFWriter writer = new DBFWriter();

    /**
     * 写dbf
     * @date 2019/2/14
     */
    public static boolean writeData(String filePath, List<String[]> elementList) {

        File file = new File(filePath);
        OutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DBFWriter writer = new DBFWriter(fos);
        DBFField fields[] = new DBFField[2]; //声明文件列数，此为2列

        if (file.exists()) {
            /*设置第一列的属性*/
            fields[0] = new DBFField();
            fields[0].setName("code");//title
            fields[0].setType(DBFDataType.CHARACTER);//数据类型,CHARACTER不支持中文
            fields[0].setLength(10);//数据长度

            //设置第二列的属性
            fields[1] = new DBFField();
            fields[1].setName("name");
            //fields[1].setType(DBFDataType.NUMERIC);
            fields[1].setType(DBFDataType.CHARACTER);
            fields[1].setLength(10);
            //fields[1].setDecimalCount(2);//设置数据保存两位小数

            //定义DBF字段结构
            writer.setFields(fields);

            int elementListSize = elementList.size();
            for (int i = 0; i < elementListSize; i++) {
                String[] data = elementList.get(i);

                if (null == data) {
                    continue;
                }
                writer.addRecord(data);
            }

            writer.write();
            DBFUtils.close(writer);

            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    //测试
    public static void main(String[] args) throws Exception {
        File dbfFile = new File("d:\\test.dbf");

        String[] str1Arr = new String[]{"ldh", "LiuDeHua"};
        String[] str2Arr = new String[]{"lq", "LiuQian"};
        List<String[]> dataList = new ArrayList<>();
        dataList.add(str1Arr);
        dataList.add(str2Arr);

        DBFUtil.writeData(dbfFile.getAbsolutePath(), dataList);
    }

}