package com.zhurong.utils.common;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.io.FileUtils;

/**
 * 文件工具类
 * @date 2018/8/27
 */
public class FileUtil {

    /**
     * 获得文件的扩展名（扩展名不带 . ）
     * @date 2018/8/27
     */
    public static String extName(String fileName) {
        if (fileName == null) {
            return null;
        }
        int index = fileName.lastIndexOf(".");
        if (index == -1) {
            return null;
        }
        return fileName.substring(index + 1);
    }

    /**
     * 获取文件大小，返回KB，没有文件时返回0
     * @param filePath 文件路径
     * @date 2018/9/20
     */
    public static String getFileSize(String filePath) {
        File file = new File(filePath);
        double fileDoubleV = (double) file.length();

        double resultDouble = fileDoubleV / 1000.00;
        //不保留小数，五舍五入
        BigDecimal resultBigDecimal = new BigDecimal(resultDouble).setScale(0, RoundingMode.HALF_UP);

        return resultBigDecimal.toString();
    }


    /*------------------- 创建文件 start --------------------------*/
    /**
     * 创建所给文件或目录的父目录
     * @date 2018/8/27
     */
    public static File mkParentDirs(File file) {
        final File parentFile = file.getParentFile();
        if (null != parentFile && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return parentFile;
    }

    /**
     * 创建文件及其父目录。
     * 1、如果这个文件存在，直接返回这个文件。
     * 2、此方法不对 File 对象类型做判断，如果 File 不存在，无法判断其类型。
     * @date 2018/8/27
     */
    public static File touch(File file) {
        if (null == file) {
            return null;
        }
        if (!file.exists()) {
            mkParentDirs(file);
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
    /*------------------- 创建文件 end --------------------------*/

    /**
     * 删除文件
     * @param filePathAndName 文件路径及名称，例如：d://image//1.jpg
     * @date 2018/9/20
     */
    public static void delFile(String filePathAndName) {
        try {
            File myDelFile = new File(filePathAndName);

            if (!myDelFile.exists()) {
                throw new RuntimeException("要删除的文件不存在！");
            }
            myDelFile.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件夹
     * @param folderPathAndName
     * @date 2019/5/8
     */
    public static void delFolder(String folderPathAndName) {
        File folder = new File(folderPathAndName);
        if (folder.exists()) {
            try {
                FileUtils.deleteDirectory(folder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //=====Used By AttachFile start ==========

    public static String getNewFileName(String basePath, String oldFileName) {
        File oldFile = new File(basePath + File.separator + oldFileName);
        if (!oldFile.exists()) {
            return oldFileName;
        } else {
            String filename = getFileNameWithoutSuffix(oldFileName);
            String suffix = getFileSuffix(oldFileName);
            int flag = 0;
            String newFileName = null;

            while ((newFileName = getNewFileName(basePath, filename, suffix, flag++)) == null) {
            }

            return newFileName;
        }
    }

    /**
     * 获取文件名（不带后缀名）
     * @date 2019/6/3
     */
    public static String getFileNameWithoutSuffix(String fileName) {
        return fileName.indexOf(".") > -1 ? fileName.substring(0, fileName.lastIndexOf(".")) : fileName;
    }

    /**
     * 获取文件的后缀名
     * @date 2019/6/3
     */
    public static String getFileSuffix(String fileName) {
        return fileName.indexOf(".") > -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
    }

    /**
     * 获取新文件名
     * @date 2019/6/3
     */
    private static String getNewFileName(String basePath, String fileName, String suffix, int flag) {
        String newFileName;
        if (flag <= 0) {
            newFileName = fileName + "." + suffix;
        } else {
            newFileName = fileName + "(" + flag + ")." + suffix;
        }

        File newFile = new File(basePath + File.separator + newFileName);
        return newFile.exists() ? null : newFileName;
    }

    /**
     * 根据输入流和文件名获取文件
     * @date 2019/6/3
     */
    public static File getFile(InputStream in, String fileName) throws IOException {
        if (in != null && fileName != null) {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];

            int length;
            while ((length = in.read(temp)) > 0) {
                fos.write(temp, 0, length);
            }

            fos.flush();
            fos.close();
            return file;
        } else {
            return null;
        }
    }

    public static boolean removeFile(File srcFile, File destFile, boolean overlay) {
        return copyOrRemoveFile(srcFile, destFile, overlay, false);
    }

    private static boolean copyOrRemoveFile(File srcFile, File destFile, boolean overlay, boolean isCopy) {
        if (srcFile != null && srcFile.exists()) {
            if (!destFile.exists() && !destFile.getParentFile().exists() && !destFile.getParentFile().mkdirs()) {
                return false;
            } else {
                boolean complated;
                int byteread;
                if (srcFile.isDirectory()) {
                    complated = true;
                    if (destFile.exists()) {
                        if (!destFile.isDirectory()) {
                            if (!overlay) {
                                return false;
                            }

                            deleteFile(destFile);
                        }
                    } else {
                        complated = destFile.mkdir();
                    }

                    if (!complated) {
                        return false;
                    } else {
                        File[] children = srcFile.listFiles();
                        boolean allComplate = true;
                        File[] var26 = children;
                        byteread = children.length;

                        for (int var28 = 0; var28 < byteread; ++var28) {
                            File child = var26[var28];
                            allComplate = copyOrRemoveFile(child, new File(destFile.getAbsoluteFile() + "\\" + child.getName()), overlay,
                                isCopy);
                            if (!allComplate) {
                                break;
                            }
                        }

                        return allComplate;
                    }
                } else {
                    complated = true;
                    if (destFile.exists()) {
                        if (overlay) {
                            deleteFile(destFile);
                        } else {
                            complated = false;
                        }
                    }

                    if (!complated) {
                        return false;
                    } else if (isCopy) {
                        InputStream in = null;
                        FileOutputStream out = null;

                        boolean var8;
                        try {
                            in = new FileInputStream(srcFile);
                            out = new FileOutputStream(destFile);
                            byte[] buffer = new byte[1024];
                            var8 = false;

                            while ((byteread = in.read(buffer)) != -1) {
                                out.write(buffer, 0, byteread);
                            }

                            boolean var9 = true;
                            return var9;
                        } catch (FileNotFoundException var21) {
                            var8 = false;
                        } catch (IOException var22) {
                            var8 = false;
                            return var8;
                        } finally {
                            try {
                                if (out != null) {
                                    out.close();
                                }

                                if (in != null) {
                                    in.close();
                                }
                            } catch (IOException var20) {
                                var20.printStackTrace();
                            }

                        }

                        return var8;
                    } else {
                        return srcFile.renameTo(destFile);
                    }
                }
            }
        } else {
            return false;
        }
    }

    public static void deleteFile(String filepath) {
        if (filepath != null) {
            deleteFile(new File(filepath));
        }
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                if (children != null && children.length != 0) {
                    File[] var2 = children;
                    int var3 = children.length;

                    for (int var4 = 0; var4 < var3; ++var4) {
                        File child = var2[var4];
                        deleteFile(child);
                    }
                }
            }

            file.delete();
        }

    }

    public static void downloadFilebBreakpoint(HttpServletRequest request, HttpServletResponse response, File file, String fileName)
        throws IOException {
        downloadFilebBreakpoint(request, response, file, fileName, "attachment");
    }

    public static void openFilebBreakpoint(HttpServletRequest request, HttpServletResponse response, File file, String fileName)
        throws IOException {
        downloadFilebBreakpoint(request, response, file, fileName, "inline");
    }

    private static void downloadFilebBreakpoint(HttpServletRequest request, HttpServletResponse response, File file, String fileName,
        String downloadType) throws IOException {
        BufferedInputStream bis = null;
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在：" + fileName);
        } else {
            long p = 0L;
            long toLength = 0L;
            long contentLength = 0L;
            int rangeSwitch = 0;
            String rangBytes = "";
            long fileLength = file.length();
            InputStream ins = new FileInputStream(file);
            bis = new BufferedInputStream(ins);
            response.reset();
            response.setHeader("Accept-Ranges", "bytes");
            String range = request.getHeader("Range");
            String suffix;
            if (range != null && range.trim().length() > 0 && !"null".equals(range)) {
                response.setStatus(206);
                rangBytes = range.replaceAll("bytes=", "");
                if (rangBytes.endsWith("-")) {
                    rangeSwitch = 1;
                    p = Long.parseLong(rangBytes.substring(0, rangBytes.indexOf("-")));
                    contentLength = fileLength - p;
                } else {
                    rangeSwitch = 2;
                    suffix = rangBytes.substring(0, rangBytes.indexOf("-"));
                    String temp2 = rangBytes.substring(rangBytes.indexOf("-") + 1, rangBytes.length());
                    p = Long.parseLong(suffix);
                    toLength = Long.parseLong(temp2);
                    contentLength = toLength - p + 1L;
                }
            } else {
                contentLength = fileLength;
            }

            response.setHeader("Content-Length", (new Long(contentLength)).toString());
            if (rangeSwitch == 1) {
                suffix = "bytes " + (new Long(p)).toString() + "-" + (new Long(fileLength - 1L)).toString() + "/" + (new Long(fileLength))
                    .toString();
                response.setHeader("Content-Range", suffix);
                bis.skip(p);
            } else if (rangeSwitch == 2) {
                suffix = range.replace("=", " ") + "/" + (new Long(fileLength)).toString();
                response.setHeader("Content-Range", suffix);
                bis.skip(p);
            } else {
                suffix = "bytes " + "0-" + (fileLength - 1L) + "/" + fileLength;
                response.setHeader("Content-Range", suffix);
            }

            if (downloadType.equals("attachment")) {
                response.setContentType("application/octet-stream");
            } else {
                suffix = getFileSuffix(fileName).toLowerCase();
                byte var20 = -1;
                switch (suffix.hashCode()) {
                    case 102340:
                        if (suffix.equals("gif")) {
                            var20 = 4;
                        }
                        break;
                    case 105441:
                        if (suffix.equals("jpg")) {
                            var20 = 2;
                        }
                        break;
                    case 110834:
                        if (suffix.equals("pdf")) {
                            var20 = 0;
                        }
                        break;
                    case 111145:
                        if (suffix.equals("png")) {
                            var20 = 3;
                        }
                        break;
                    case 115312:
                        if (suffix.equals("txt")) {
                            var20 = 1;
                        }
                }

                switch (var20) {
                    case 0:
                        response.setContentType("application/pdf");
                        break;
                    case 1:
                        response.setContentType("text/plain");
                        break;
                    case 2:
                        response.setContentType("image/jpeg");
                        break;
                    case 3:
                        response.setContentType("image/png");
                        break;
                    case 4:
                        response.setContentType("image/gif");
                        break;
                    default:
                        response.setContentType("multipart/form-data");
                }
            }

            fileName = new String(fileName.getBytes("gbk"), "ISO8859-1");
            response.addHeader("Content-Disposition", downloadType + ";filename=" + fileName);
            OutputStream out = response.getOutputStream();
            long readLength = 0L;
            int bsize = 1024;
            byte[] bytes = new byte[bsize];
            int n;
            if (rangeSwitch != 2) {
                while ((n = bis.read(bytes)) != -1) {
                    out.write(bytes, 0, n);
                }
            } else {
                while (readLength <= contentLength - (long) bsize) {
                    n = bis.read(bytes);
                    readLength += (long) n;
                    out.write(bytes, 0, n);
                }

                if (readLength <= contentLength) {
                    n = bis.read(bytes, 0, (int) (contentLength - readLength));
                    out.write(bytes, 0, n);
                }
            }

            out.flush();
            out.close();
            bis.close();
        }
    }

    public static void downloadFile(String filename, byte[] data, HttpServletResponse response) throws IOException {
        downloadFile(filename, (InputStream) (new ByteArrayInputStream(data)), response);
    }

    public static void downloadFile(String filename, InputStream is, HttpServletResponse response) throws IOException {
        if (is != null) {
            response.reset();
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", -1L);
            filename = new String(filename.getBytes("gbk"), "ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            OutputStream out = response.getOutputStream();
            byte[] data = new byte[1024];

            int length;
            while ((length = is.read(data)) > 0) {
                out.write(data, 0, length);
            }

            out.close();
            is.close();
        }
    }

    public static File resizeImage(File oldImage, String destFilePath, String size, boolean cut) throws IOException {
        if (!oldImage.exists()) {
            return null;
        } else {
            File image = new File(destFilePath);
            if (image.exists()) {
                return image;
            } else {
                int width = 0;
                int height = 0;
                if (size.indexOf("x") > -1) {
                    String[] sizes = size.split("x");
                    if (sizes.length == 1) {
                        if (!sizes[0].equals("")) {
                            width = Integer.parseInt(sizes[0]);
                        }
                    } else if (sizes.length == 2) {
                        if (!sizes[0].equals("")) {
                            width = Integer.parseInt(sizes[0]);
                        }

                        if (!sizes[1].equals("")) {
                            height = Integer.parseInt(sizes[1]);
                        }
                    }
                }

                if ((width != 0 || height != 0) && width >= 0 && height >= 0) {
                    if (height > 0 && width > 0) {
                        BufferedImage bufferimage = ImageIO.read(oldImage);
                        int imageWidth = bufferimage.getWidth();
                        int imageHeitht = bufferimage.getHeight();
                        if (imageWidth > width && imageHeitht > height) {
                            if ((float) width / (float) height == (float) imageWidth / (float) imageHeitht) {
                                Thumbnails.of(new File[]{image}).size(width, height).toFile(image);
                            } else if (cut) {
                                if ((float) imageWidth / (float) width > (float) imageHeitht / (float) height) {
                                    bufferimage = Thumbnails.of(new File[]{oldImage}).height(height).asBufferedImage();
                                } else {
                                    bufferimage = Thumbnails.of(new File[]{oldImage}).width(width).asBufferedImage();
                                }

                                Thumbnails.of(new BufferedImage[]{bufferimage}).sourceRegion(Positions.CENTER, width, height)
                                    .size(width, height).toFile(image);
                            } else if ((float) imageWidth / (float) width > (float) imageHeitht / (float) height) {
                                Thumbnails.of(new File[]{oldImage}).width(width).toFile(image);
                            } else {
                                Thumbnails.of(new File[]{oldImage}).height(height).toFile(image);
                            }

                            return image;
                        } else if (imageWidth <= width && imageHeitht <= height) {
                            return oldImage;
                        } else {
                            if (imageWidth > width) {
                                Thumbnails.of(new File[]{oldImage}).width(width).toFile(image);
                            } else {
                                Thumbnails.of(new File[]{oldImage}).height(height).toFile(image);
                            }

                            return image;
                        }
                    } else {
                        if (width > 0) {
                            Thumbnails.of(new File[]{oldImage}).width(width).toFile(image);
                        } else {
                            Thumbnails.of(new File[]{oldImage}).height(height).toFile(image);
                        }

                        return image;
                    }
                } else {
                    return null;
                }
            }
        }
    }

    //=====Used By AttachFile end ==========


}