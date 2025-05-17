package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtility {
	
	public static List<Map<String, String>> getTestData(String filePath, String sheetName) {
        List<Map<String, String>> testData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            int rowCount = sheet.getLastRowNum();
            int colCount = headerRow.getLastCellNum();

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                Map<String, String> dataMap = new HashMap<>();

                for (int j = 0; j < colCount; j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = row.getCell(j).toString();
                    dataMap.put(key, value);
                }
                testData.add(dataMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }

}
