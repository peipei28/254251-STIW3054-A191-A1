import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class readAcc {
    public static void main(String[] args) {

        final String url = "https://github.com/STIW3054-A191/Main-Issues/issues/1";

        try {
            final Document doc = Jsoup.connect(url).get();

            for (Element row : doc.select("table.d-block tr")) {
                if (row.select("p").text().equals("")) {
                    continue;
                } else {
                    final String info = row.select("p").text();
                    System.out.println(info);

                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}