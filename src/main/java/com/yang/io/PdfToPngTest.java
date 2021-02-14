package com.yang.io;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author tianfei21
 * @Date: 2020/12/23 10:22
 * @Description:
 * @Version: 1.0
 */
public class PdfToPngTest {

//    String pdfUrl = "https://storage.jd.com/eicore.fm.jd.com/131001570151-2941376.pdf?Expires=2439876513&AccessKey=bfac05320eaf11cc80cf1823e4fb87d98523fc94&Signature=PcdMuU3bY8DDyF2W6192nGcVAfE%3D";
    String pdfUrl = "https://storage.jd.com/fm-eicore/011001900611-39667166.pdf?Expires=2553848928&AccessKey=bfac05320eaf11cc80cf1823e4fb87d98523fc94&Signature=ThSyE1Q7Rz4lBc8HgbWx6rtbbYw%3D";
    final String pdfFileName = "131001570151-2941376.pdf";

    final String path = "";

    //缩放比例
    float scale = 2.5f;
    //旋转角度
    float rotation = 0f;

    @Test
    public void generatePic() throws Exception {
//        Document document = new Document();
//        URL url = new URL(pdfUrl);
//        document.setUrl(url);
//
//        for (int i = 0; i < document.getNumberOfPages(); i++) {
//            BufferedImage image = (BufferedImage)
//                    document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
//            RenderedImage rendImage = image;
//            try {
//                String imgName = i + ".png";
//                System.out.println(imgName);
//                File file = new File(imgName);
//                ImageIO.write(image, "png", file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            image.flush();
//        }
//
//        document.dispose();
    }

    @Test
    public void generatePng() throws IOException {
//        long beginTimeMillis = System.currentTimeMillis();
//        System.out.println(beginTimeMillis);
        //获取pdf文件
        PDDocument pdDocument;
        //创建生成的文件保存路径
        pdDocument = PDDocument.load(getInputStream(pdfUrl));
        PDFRenderer renderer = new PDFRenderer(pdDocument);

            BufferedImage image = renderer.renderImageWithDPI(0, 500);
            //引入一个输出流，方便关闭，不然会因为文件被占用而导致无法删除
//            OutputStream ops = new FileOutputStream(dstFile);
            String imgName = "D:\\PdfToPng\\test.png";
            System.out.println(imgName);
            File destFile = new File(imgName);
            OutputStream ops = new FileOutputStream(destFile);
            ImageIO.write(image, "png", destFile);
            pdDocument.close();
            ops.close();
//        }
        long endTimeMillis = System.currentTimeMillis();
//        System.out.println(endTimeMillis);
//        System.out.println(endTimeMillis - beginTimeMillis);
    }

    private InputStream getInputStream(String pdfUrl) {
        long beginTimeMillis = System.currentTimeMillis();
        System.out.println("开始："+beginTimeMillis);
        HttpURLConnection conn = null;
        try {
            URL url = new URL(pdfUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(), output);
            long endTimeMillis = System.currentTimeMillis();
            System.out.println("耗时："+(endTimeMillis - beginTimeMillis));

            return new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
            }

        }

        return null;
    }

}
