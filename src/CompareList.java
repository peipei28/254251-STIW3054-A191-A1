import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class CompareList {

    public static void main (String args [])throws IOException {

        FileInputStream file1 = new FileInputStream("List of Student.xls");
        HSSFWorkbook wb1 = new HSSFWorkbook(file1);
        HSSFSheet ws1 = wb1.getSheet("List of Students");
        int rowCount1 = ws1.getPhysicalNumberOfRows();

        FileInputStream file2 = new FileInputStream("List of Github Account.xls");
        HSSFWorkbook wb2 = new HSSFWorkbook(file2);
        HSSFSheet ws2 = wb2.getSheet("List of Github Account");
        int rowCount2 = ws2.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount1; i++) {
            HSSFRow row1 = ws1.getRow(i);

            String matric1 = "";
            HSSFCell id1 = row1.getCell(1);
            if (id1 != null) {
                id1.setCellType(CellType.STRING);
                matric1 = id1.getStringCellValue();
            }
        }

            for (int j = 1; j < rowCount2; j++) {
                HSSFRow row2 = ws2.getRow(j);

                String matric2 = "";
                HSSFCell id1 = row2.getCell(0);
                if (id1 != null) {
                    id1.setCellType(CellType.STRING);
                    matric2 = id1.getStringCellValue();

                }
            }
    }
}
