import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readAcc {
    private static List<InfoAcc> nameList = new ArrayList();

    public static List<InfoAcc> collectData2(){

        final String url = "https://github.com/STIW3054-A191/Main-Issues/issues/1";

        try {
            final Document doc = Jsoup.connect(url).get();

            Elements table = doc.select("td.d-block.comment-body.markdown-body.js-comment-body");

            for (Element tableData : table) {
                String info = tableData.getElementsMatchingOwnText("\\d{5,6}").text();
                String matric;

                Pattern matricPattern = Pattern.compile("(\\d{5,6})");
                Matcher m1 = matricPattern.matcher(info);
                if ((m1.find())) {
                    matric = m1.group(1);

                int linkIndex = info.lastIndexOf("ink");
                int nameIndex = info.lastIndexOf("ame");

                String Gname1 = null;
                try {
                    Gname1 = info.substring(nameIndex + 3, linkIndex - 1).replace(':', ' ').trim();
                } catch (Exception e) {
                    System.out.println("");
                }

                String Glink = null;
                try {
                    Glink = info.substring(linkIndex + 3).replace(':', ' ').trim();
                } catch (Exception e) {
                    System.out.println();
                }

                    nameList.add(new InfoAcc(matric, Gname1, Glink));
                }
            }
            } catch(Exception ex){
                System.out.println("");
            }

        return nameList;

        }

    public static void toExcel() {

        if (nameList.isEmpty()) {
            System.out.println("No data to  write");
            System.exit(0);
        }
        String excelFile = "List of Github Account.xls";
        System.out.println("\nwriting the" +excelFile+"...");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("List of Github Account");

        try{
            for(int i =0; i<nameList.size();i++) {
                HSSFRow row = sheet.createRow(i);
                HSSFCell cell1 = row.createCell(0);
                cell1.setCellValue(nameList.get(i).getMatric());
                HSSFCell cell2 = row.createCell(1);
                cell2.setCellValue(nameList.get(i).getName());
                HSSFCell cell3 = row.createCell(2);
                cell3.setCellValue(nameList.get(i).getLink());
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
        collectData2();
        toExcel();
    }
}