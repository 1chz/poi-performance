package io.github.shirohoo.poi.performance;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class XlsxViewV1 extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        model = model.entrySet()
                .stream()
                .filter(entry -> entry.getValue() instanceof Person)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        Sheet sheet = workbook.createSheet();

        int rowNum = 0;
        for (String key : model.keySet()) {
            Row row = sheet.createRow(rowNum++);
            Object obj = model.get(key);

            int cellNum = 0;
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(String.valueOf(field.get(obj)));
            }
        }
    }
}
