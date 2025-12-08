package com.orchard.service.impl;

import com.orchard.bo.RecordExcellBo;
import com.orchard.mapper.RecordMapper;
import com.orchard.mapper.ReportMapper;
import com.orchard.service.RecordService;
import com.orchard.service.ReportService;
import com.orchard.vo.RecordExcelVo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private RecordMapper recordMapper;
    /**
     * 导出记录的excel数据
     * @param response
     */
    @Override
    public void exportBusinessData(HttpServletResponse response) {
        //1. 查询数据库，获取营业数据---查询最近30天的运营数据
//        LocalDate localDateEnd = LocalDate.now();

        //2. 通过POI将数据写入到Excel文件中创建Excel表格
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("Template/record.xlsx");


        //基于模板文件创建一个新的Excel文件
        try {
            XSSFWorkbook excel = new XSSFWorkbook(resourceAsStream);
            //获取ecxel的页面
            XSSFSheet excel1 = excel.getSheet("Sheet1");

                //获取记录中的数据,精细化到秒
            List<RecordExcelVo> list = recordMapper.recordByTime();

                // 从第1行开始（Excel行索引从0开始）
            int rowIndex = 1;

            for (RecordExcelVo recordExcelVo : list) {
                // 获取或创建行
                XSSFRow row = excel1.getRow(rowIndex);
                if (row == null) {
                    row = excel1.createRow(rowIndex);
                }

                // 确保单元格存在
                for (int i = 1; i <= 6; i++) {
                    if (row.getCell(i) == null) {
                        row.createCell(i);
                    }
                }

                // 填写单元格数据
                row.getCell(1).setCellValue(recordExcelVo.getGoodstypeName());
                row.getCell(2).setCellValue(recordExcelVo.getGoodsName());
                row.getCell(3).setCellValue(recordExcelVo.getRemark());
                row.getCell(4).setCellValue(recordExcelVo.getUserName());
                row.getCell(5).setCellValue(recordExcelVo.getAdminName());
                row.getCell(6).setCellValue(recordExcelVo.getCount());

                rowIndex++;  // 移动到下一行
            }




            //获取输出流将excel文件下载到客户端浏览器中
            ServletOutputStream outputStream = response.getOutputStream();
            excel.write(outputStream);
            //关闭资源
            excel.close();
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
