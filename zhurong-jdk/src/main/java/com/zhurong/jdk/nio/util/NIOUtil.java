package com.zhurong.jdk.nio.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO文件复制工具（大文件复制的时候效率更显快）
 * 2018/11/6
 */
public class NIOUtil {

    /**
     * 拷贝
     * @param src 源文件
     * @param dst 目标文件
     */
    public static void copyFileUseNIO(String src, String dst) throws IOException {
        //声明源文件和目标文件
        FileInputStream fi = new FileInputStream(new File(src));
        FileOutputStream fo = new FileOutputStream(new File(dst));

        //获得传输通道channel
        FileChannel inChannel = fi.getChannel();
        FileChannel outChannel = fo.getChannel();

        //获得容器buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            //判断是否读完文件
            int eof = inChannel.read(buffer);
            if (eof == -1) {
                break;
            }

            //重设一下buffer的position=0，limit=position
            buffer.flip();

            //开始写
            outChannel.write(buffer);

            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }

        //关闭管道
        inChannel.close();
        outChannel.close();

        //关闭流
        fi.close();
        fo.close();
    }
}