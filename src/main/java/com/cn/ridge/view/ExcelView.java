package com.cn.ridge.view;

import com.cn.ridge.bean.User;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Author: create by wang.gf
 * Date: create at 2018/11/21
 */
public class ExcelView extends AbstractXlsxStreamingView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        String excelName = "导出的数据" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("u-MM-dd")) + ".xls";
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(excelName, "utf-8"));
        response.setContentType("application/ms-excel; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //Excel workbook
        SXSSFWorkbook sxssfWorkbook = (SXSSFWorkbook) workbook;
        @SuppressWarnings("unchecked")
        List<List<User>> allUsers = (List<List<User>>) model.get("allUsers");
        IntStream.range(0, allUsers.size()).forEach(i -> {
            Sheet sheet = sxssfWorkbook.createSheet("数据单" + i);
            //默认列宽
            sheet.setDefaultColumnWidth(10);
            //字体
            Font font = sxssfWorkbook.createFont();
            font.setCharSet(Font.DEFAULT_CHARSET);
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            //cell样式挑自己喜欢的来吧
            CellStyle cellStyle = sxssfWorkbook.createCellStyle();
            //前景颜色
            cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE_GREY.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //set font
            cellStyle.setFont(font);
            //首列
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("名字");
            header.getCell(0).setCellStyle(cellStyle);
            header.createCell(1).setCellValue("年龄");
            header.getCell(1).setCellStyle(cellStyle);
            header.createCell(2).setCellValue("住址");
            header.getCell(2).setCellStyle(cellStyle);
            //剩余列
            List<User> users = allUsers.get(i);
            IntStream.range(0, users.size()).forEach(j -> {
                Row row = sheet.createRow(j + 1);
                User user = users.get(j);
                row.createCell(0).setCellValue(user.getName());
                row.createCell(1).setCellValue(user.getAge());
                row.createCell(2).setCellValue(user.getAddr());
            });
        });
    }

}
