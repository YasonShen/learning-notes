//package com.ya.test;
//
//import com.jd.BaseTest;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.IOUtils;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;
//import org.junit.Test;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
///**
// * @author shenqiuyang3
// * @date 2020/12/28 20:53
// * @Description
// */
//@Slf4j
//public class PdfToPngTest extends BaseTest {
//
//    final String pdfUrl = "https://storage.jd.com/eicore.fm.jd.com/131001570151-2941376.pdf?Expires=2439876513&AccessKey=bfac05320eaf11cc80cf1823e4fb87d98523fc94&Signature=PcdMuU3bY8DDyF2W6192nGcVAfE%3D";
//
//    final String pdfFileName = "131001570151-2941376.pdf";
//
//    final String path = "";
//
//    //缩放比例
//    float scale = 2.5f;
//    //旋转角度
//    float rotation = 0f;
//
//    @Test
//    public void generatePic() throws Exception {
////        Document document = new Document();
////        URL url = new URL(pdfUrl);
////        document.setUrl(url);
////
////        for (int i = 0; i < document.getNumberOfPages(); i++) {
////            BufferedImage image = (BufferedImage)
////                    document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
////            RenderedImage rendImage = image;
////            try {
////                String imgName = i + ".png";
////                System.out.println(imgName);
////                File file = new File(imgName);
////                ImageIO.write(image, "png", file);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////            image.flush();
////        }
////
////        document.dispose();
//    }
//
//    @Test
//    public void generatePng() throws IOException {
//        //获取pdf文件
//        PDDocument pdDocument;
//        //创建生成的文件保存路径
////        String newFolderPath = folderPath +File.separator+ "thumbnail";
////        File folder = new File(newFolderPath);
////        if (!folder.exists()) {
////            folder.mkdirs();
////        }
//        //转换新的文件名，123.pdf转换为123.png
////        pdDocument = PDDocument.load(file);
//        pdDocument = PDDocument.load(getInputStream());
//        PDFRenderer renderer = new PDFRenderer(pdDocument);
//        int pages = pdDocument.getNumberOfPages();
//
//        //生成新的文件
//        StringBuffer imgFilePath = null;
//        for (int i = 0; i < pages; i++) {
////            String imgSavePath = newFolderPath + File.separator + imgName;
////            imgFilePath = new StringBuffer();
////            imgFilePath.append(imgSavePath);
////            因为只转换1页，所以生成的图片只有一张，不用分开命名，如果转换多页pdf文件到多个png图片，须加上命名区分
////            imgFilePath.append("-");
////            imgFilePath.append(String.valueOf(i + 1));
////            imgFilePath.append(".png");
////            File dstFile = new File(imgFilePath.toString());
//            BufferedImage image = renderer.renderImageWithDPI(i, 200);
//            //引入一个输出流，方便关闭，不然会因为文件被占用而导致无法删除
////            OutputStream ops = new FileOutputStream(dstFile);
//            String imgName = "131001570151-2941376.png";
//            System.out.println(imgName);
//            File destFile = new File(imgName);
//            OutputStream ops = new FileOutputStream(destFile);
//            ImageIO.write(image, "png", destFile);
//            pdDocument.close();
//            ops.close();
//        }
//    }
//
//    private InputStream getInputStream() {
//        HttpURLConnection conn = null;
//        try {
//            URL url = new URL(pdfUrl);
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(20 * 1000);
//            final ByteArrayOutputStream output = new ByteArrayOutputStream();
//            IOUtils.copy(conn.getInputStream(), output);
//            return new ByteArrayInputStream(output.toByteArray());
//        } catch (Exception e) {
//            log.error(e + "");
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.disconnect();
//                }
//            } catch (Exception e) {
//                log.error(e + "");
//            }
//
//        }
//
//        return null;
//    }
//}
//
