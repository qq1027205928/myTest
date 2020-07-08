package com.testparam.controller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class TestExcel {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        //String filePath ="C:\\Users\\IGEN\\Desktop\\补充excel\\方域合同补充信息（第二批）.xlsx";
        //FileInputStream fileInputStream = new FileInputStream(filePath);
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        //HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        File file = new File("C:\\Users\\IGEN\\Desktop\\补充excel\\方域合同补充6.1.xlsx");
        XSSFWorkbook workbook2 = new XSSFWorkbook(file);
        XSSFSheet sheet1 = workbook2.getSheet("Sheet1");
        int lastRowNum = sheet1.getLastRowNum();
        System.out.println(lastRowNum);
        for(int i=2;i<=lastRowNum;i++){
            XSSFRow row = sheet1.getRow(i);
            if(row==null){
                break;
            }
            short lastCellNum = row.getLastCellNum();
            /*for (int j = 0; j < lastCellNum; j++) {
                XSSFCell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                String cellValue = cell.getStringCellValue();
                System.out.println(cellValue);
            }*/
            StringBuilder sb = new StringBuilder("update T_IN_INCOMING SET PUTINFORBANKACCOUNT =");
            String PUTINFORBANKACCOUNT = row.getCell(4).getStringCellValue();
            sb.append("'").append(PUTINFORBANKACCOUNT.trim()).append("'").append(",PUTINFORBANKNAME = ");
            String PUTINFORBANKNAME = row.getCell(5).getStringCellValue();
            sb.append("'").append(PUTINFORBANKNAME.trim()).append("'").append(",POSTCODE = ");
            row.getCell(6).setCellType(CellType.STRING);
            String POSTCODE = row.getCell(6).getStringCellValue();
            sb.append("'").append(POSTCODE.trim()).append("'").append(",CONTACTSNAME = ");
            row.getCell(7).setCellType(CellType.STRING);
            String CONTACTSNAME = row.getCell(7).getStringCellValue();
            sb.append("'").append(CONTACTSNAME.trim()).append("'").append(",CONTACTSIDNUMBER = ");
            row.getCell(8).setCellType(CellType.STRING);
            String CONTACTSIDNUMBER = row.getCell(8).getStringCellValue();
            sb.append("'").append(CONTACTSIDNUMBER.trim()).append("'").append(",CONTACTSPHONE = ");
            row.getCell(9).setCellType(CellType.STRING);
            String CONTACTSPHONE = row.getCell(9).getStringCellValue();
            sb.append("'").append(CONTACTSPHONE.trim()).append("'").append(",CONTACTSADDRESS = ");
            row.getCell(10).setCellType(CellType.STRING);
            String CONTACTSADDRESS = row.getCell(10).getStringCellValue();
            sb.append("'").append(CONTACTSADDRESS.trim()).append("'").append(" where INCOMINGNUMBER LIKE");
            row.getCell(2).setCellType(CellType.STRING);
            String INCOMINGNUMBER = row.getCell(2).getStringCellValue();
            sb.append("'%").append(INCOMINGNUMBER.trim()).append("%';");
            System.out.println(sb.toString());
            StringBuilder sb2 = new StringBuilder("update T_IN_BUILD_STATION SET SPECIFICATION=");
            row.getCell(11).setCellType(CellType.STRING);
            String SPECIFICATION = row.getCell(11).getStringCellValue();
            sb2.append(SPECIFICATION).append(",BLOCKS =");
            row.getCell(12).setCellType(CellType.STRING);
            String BLOCKS = row.getCell(12).getStringCellValue();
            String block = BLOCKS.replace("块", "");
            sb2.append(block).append(",PAYMENTUSE = '首付款' where INCOMINGID = (select ID from T_IN_INCOMING where INCOMINGNUMBER like ");
            sb2.append("'%").append(INCOMINGNUMBER.trim()).append("%');");
            System.out.println(sb2.toString());
            System.out.println();
        }

    }
}
