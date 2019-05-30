package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Created by jams on 2019/5/27.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws Exception {
        boolean notNull = false; //判断Excel文件是否有内容
        String filename = file.getOriginalFilename();

        if (!filename.matches("^.+\\.(?i)(xls)$") && !filename.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        //判断Excel文件的版本
        boolean isExcel2003 = true;
        if (filename.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet == null) {
            throw new Exception("第一个sheet为空");
        }
        int totalRows = sheet.getPhysicalNumberOfRows(); //获取行数，第一行是标题
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Row row = null;
        int totalCells = 0;
        for (int i = 1; i < totalRows; i++) {
            //遍历单元格
            row = sheet.getRow(i);
            //totalCells = row.getPhysicalNumberOfCells();        //获取每一行的单元格数
            //循环设置每个单元格的数据类型为String类型
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                   log.info("cell[{}]:{}",j,cell.getStringCellValue());
                }
            }
        }
        return "upload";
    }
}
