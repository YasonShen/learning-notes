//package com.ya.exam;
//
//public class ExcelModel{
//
//        int column;
//        int row;
//
//        String content;
//
//        public String getContent(int row, int column){
//            return this.content;
//        }
////        ExcelModel(String ct){
////            this.content = ct;
////        }
//
//        public ExcelModel(){
//
//        }
//
//        public ExcelModel(int column, int row) {
//            this.column = column;
//            this.row = row;
//        }
//
//        public ExcelModel(int column, int row, String content) {
//            this.column = column;
//            this.row = row;
//            this.content = content;
//        }
//
//    private void setContent(int rowid, int columnid, String content){
//
////        ExcelModel excelModel = new ExcelModel(rowid, columnid, content);
//          this.content = content;
//
//    }
//
//    private  ExcelModel merge(int rowid1, int columnid1, int rowid2, int columnid2){
//
//            getContent(rowid1, columnid1);
//        ExcelModel res = new ExcelModel();
//        res.content =
//    }
//
//    private static void printTable(ExcelModel a){
//        System.out.println("a单元格的数据为："+a.content);
//    }
//
//    public static void main(String[] args) {
//        ExcelModel a = new ExcelModel(1, 1);
//        ExcelModel b = new ExcelModel(2, 2);
//
//        a.setContent(1,1,"abc");
//        b.setContent(2,2,"cde");
//
//        ExcelModel res = merge(1,1,2,2);
//
//        printTable(res);
//    }
//}
