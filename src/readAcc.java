import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class readAcc {

    //private static List<String> nameList = new ArrayList<String>();
    public static void collectData2(){

        final String url = "https://github.com/STIW3054-A191/Main-Issues/issues/1";

        try {
            final Document doc = Jsoup.connect(url).get();

            for (Element row : doc.select("table.d-block tr")) {
                if (row.select("p").text().equals("")) {
                    continue;
                } else {
                    final String info = row.select("p").text();
                    //System.out.println(info);
                    String str = info;
                    List<String> nameList = new ArrayList<String>();
                    String[] strArray = str.split("Name:|Matric:|Link:|Name : |Matric :|Link : |Matric No : |Name |name : |matrix :|link:|Matric no:");
                    for(String word : strArray) {
                        nameList.add(word);
                    }
                    System.out.println(nameList);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*public static void toExcel() {

        if (nameList.isEmpty()) {
            System.out.println("No data to  write");
            System.exit(0);
        }
        String excelFile = "List of Student.xls";
        System.out.println("\nwriting the" +excelFile+"...");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("List of Students");

        try{
            for(int i =0; i<nameList.size();i++) {
                HSSFRow row = sheet.createRow(i);
                HSSFCell cell1 = row.createCell(0);
                cell1.setCellValue((nameList.spliterator());
                //HSSFCell cell2 = row.createCell(1);
                //cell2.setCellValue(dataRecord.get(i).getMatric());
               // HSSFCell cell3 = row.createCell(2);
               // cell3.setCellValue(dataRecord.get(i).getName());
            }
            FileOutputStream outputFile = new FileOutputStream(excelFile);
            workbook.write(outputFile);
            outputFile.flush();
            outputFile.close();
            System.out.println(excelFile+ "is create successfully");
        } catch (IOException e){
            System.out.println("Error : Failed to write the file");
        }
    }*/

    public static void main(String [] args){
        collectData2();
        //toExcel();
    }
}