import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Document;
import  org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class readWiki {
   private static List<InfoWiki> dataRecord = new ArrayList();

    public static void collectData() {

        final String url = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";

        try {
            final Document doc = Jsoup.connect(url).get();

            for (Element row : doc.select("div.markdown-body tr")) {
                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    final String no = row.select("td:nth-of-type(1)").text();
                    final String matric = row.select("td:nth-of-type(2)").text();
                    final String name = row.select("td:nth-of-type(3)").text();

                    dataRecord.add(new InfoWiki(no, matric, name));
                    System.out.println(no + "\t" + matric + "\t" + name);
                }
            };

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void toExcel() {

        if (dataRecord.isEmpty()) {
            System.out.println("No data to  write");
            System.exit(0);
        }
        String excelFile = "List of Student.xls";
        System.out.println("\nwriting the" +excelFile+"...");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("List of Students");

        try{
            for(int i =0; i<dataRecord.size();i++) {
                HSSFRow row = sheet.createRow(i);
                HSSFCell cell1 = row.createCell(0);
                cell1.setCellValue(dataRecord.get(i).getNo());
                HSSFCell cell2 = row.createCell(1);
                cell2.setCellValue(dataRecord.get(i).getMatric());
                HSSFCell cell3 = row.createCell(2);
                cell3.setCellValue(dataRecord.get(i).getName());
            }
            FileOutputStream outputFile = new FileOutputStream(excelFile);
            workbook.write(outputFile);
            outputFile.flush();
            outputFile.close();
            System.out.println(excelFile+ "is create successfully");
        } catch (IOException e){
            System.out.println("Error : Failed to write the file");
        }
    }

    public static void main(String [] args){
        collectData();
        toExcel();
    }
}

