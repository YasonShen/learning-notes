package com.yang.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

/**
 * @author shenqiuyang3
 * @date 2020/12/23 14:02
 * @Description
 */
public class PdfToPngTest {

    /**
     * 把pdf文件转换为jpg文件同步保存到服务器上
     *
     * @param savePath   保存的pdf文件路径
     * @param folderPath 文件所在的文件夹
     * @param dpi        转换后的文件清晰度，
     * @param flag       转换的pdf文件页数，为0时转换全部页数，也可以指定转换页数
     * @throws Exception
     */
    private static void pdf2Png(String savePath, String folderPath, int dpi, int flag) throws Exception {
        //获取pdf文件
        File file = new File(savePath);
        PDDocument pdDocument;
        //创建生成的文件保存路径
        String newFolderPath = folderPath + File.separator + "thumbnail";
        File folder = new File(newFolderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //转换新的文件名，123.pdf转换为123.png
        int dot = file.getName().lastIndexOf(".");
        String imgName = file.getName().substring(0, dot);
        pdDocument = PDDocument.load(file);
        PDFRenderer renderer = new PDFRenderer(pdDocument);
        int pages = pdDocument.getNumberOfPages();
        //确定要打印的页数
        if (flag > 0) {
            if (flag < pages) {
                pages = flag;
            }
        }
        //生成新的文件
        StringBuffer imgFilePath = null;
        for (int i = 0; i < pages; i++) {
            String imgSavePath = newFolderPath + File.separator + imgName;
            imgFilePath = new StringBuffer();
            imgFilePath.append(imgSavePath);
//            因为只转换1页，所以生成的图片只有一张，不用分开命名，如果转换多页pdf文件到多个png图片，须加上命名区分
//            imgFilePath.append("-");
//            imgFilePath.append(String.valueOf(i + 1));
            imgFilePath.append(".png");
            File dstFile = new File(imgFilePath.toString());
            BufferedImage image = renderer.renderImageWithDPI(i, dpi);
            //引入一个输出流，方便关闭，不然会因为文件被占用而导致无法删除
            OutputStream ops = new FileOutputStream(dstFile);
            ImageIO.write(image, "png", dstFile);
            pdDocument.close();
            ops.close();
        }
    }


    public static void pdfPng(String srcPath, String destPath, int dpi, int index) throws IOException {
        File srcFile = new File(srcPath);

        File destFile = new File(destPath);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
//        System.out.println(destFile.getAbsoluteFile());
//
//        PDDocument load = PDDocument.load(srcFile);
//        PDFRenderer pdfRenderer = new PDFRenderer(load);
//
//        int pages = load.getNumberOfPages();
//        if (flag > 0 && flag < pages) {
//            pages = flag;
//        } else {
//            pages = 0;
//        }
//
////        for (int i = 0; i < pages; i++) {
//        BufferedImage image = pdfRenderer.renderImageWithDPI(pages, 200);
//
////            String imgName = "D:\\PdfToPng\\" + i + ".png";
////            System.out.println(imgName);
////            destFile = new File(imgName);
//        ImageIO.write(image, "png", destFile);
////        }
//        load.close();


        PDDocument load = PDDocument.load(srcFile);
        PDFRenderer pdfRenderer = new PDFRenderer(load);
        BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(index, 200);
        ImageIO.write(bufferedImage, "png", destFile);
        load.close();
    }

    public static void main(String[] args) throws Exception {
        String savePath = "D://pdfToPng/in.pdf";
        String folderPath = "D://pdfToPng/out1.png";
//        File src = new File("D:/pdfToPng/in.pdf");
//        File dest = new File("pdfToPng/out.png");
        pdfPng(savePath, folderPath, 100, 13);
//        System.out.println(src.getAbsoluteFile());
    }
}
