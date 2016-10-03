
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CVSUtils {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    public static void main(String[] args) throws Exception {

        BufferedReader br = null;

        try {
            String someLine;
            br = new BufferedReader(new FileReader("C:\\Users\\Genevieve\\IdeaProjects\\CP2406_Assignment\\cards.csv"));

            while ((someLine = br.readLine()) != null) {
                System.out.println("Raw card data: " + someLine);
                System.out.println("Converted ArrayList data: " + CVSUtilsToArrayList(someLine) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException theException) {
                theException.printStackTrace();
            }
        }
    }

    public static ArrayList<String> CVSUtilsToArrayList(String CSVtoArray) {
        ArrayList<String> result = new ArrayList<String>();
        if (CSVtoArray != null) {
            String[] splitData = CSVtoArray.split("\\s*, \\s");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    result.add(splitData[i].trim());
                }
            }

        }
        return result;
    }
}
//        String csvFile = " C:\\Users\\Genevieve\\IdeaProjects\\CP2406_Assignment\\cards.csv";

//        Scanner scanner = new Scanner(new File(csvFile));
//        while (scanner.hasNext()){
//            List<String> line = parseLine(scanner.nextLine());
//            System.out.println("Card [id= " + line.get(2) + ", subtitle= " + line.get(3) + ", chemistry= " + line.get(4)
//                    + ", classification= " + line.get(5) + ", crystal system= " + line.get(6) + ", occurence 1= " + line.get(7) +
//                    ", occurrence 2= " + line.get(8) + ", occurrence 3= " + line.get(9) + ", hardness= " + line.get(10)
//                    + ", specific gravity= " + line.get(11) + ", cleavage= " + line.get(12) + ", crustal abundance= " +
//                    line.get(13) + ", economic value= " + line.get(14));
//        }
//        scanner.close();
//    }
//
//    public static List<String> parseLine(String cvsLine){
//        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
//    }
//
//    public static List<String> parseLine(String cvsLine, char separators){
//        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
//    }
//
//    public static List<String>parseLine(String cvsLine, char separators, char customQuote){
//
//        List<String> result = new ArrayList<>();
//
//        //if empty, return!
//        if (cvsLine == null && cvsLine.isEmpty()) {
//            return result;
//        }
//
//        if (customQuote == ' ') {
//            customQuote = DEFAULT_QUOTE;
//        }
//
//        if (separators == ' ') {
//            separators = DEFAULT_SEPARATOR;
//        }
//
//        StringBuffer curVal = new StringBuffer();
//        boolean inQuotes = false;
//        boolean startCollectChar = false;
//        boolean doubleQuotesInColumn = false;
//
//        char[] chars = cvsLine.toCharArray();
//
//        for (char ch : chars) {
//
//            if (inQuotes) {
//                startCollectChar = true;
//                if (ch == customQuote) {
//                    inQuotes = false;
//                    doubleQuotesInColumn = false;
//                } else {
//
//                    //Fixed : allow "" in custom quote enclosed
//                    if (ch == '\"') {
//                        if (!doubleQuotesInColumn) {
//                            curVal.append(ch);
//                            doubleQuotesInColumn = true;
//                        }
//                    } else {
//                        curVal.append(ch);
//                    }
//
//                }
//            } else {
//                if (ch == customQuote) {
//
//                    inQuotes = true;
//
//                    //Fixed : allow "" in empty quote enclosed
//                    if (chars[0] != '"' && customQuote == '\"') {
//                        curVal.append('"');
//                    }
//
//                    //double quotes in column will hit this!
//                    if (startCollectChar) {
//                        curVal.append('"');
//                    }
//
//                } else if (ch == separators) {
//
//                    result.add(curVal.toString());
//
//                    curVal = new StringBuffer();
//                    startCollectChar = false;
//
//                } else if (ch == '\r') {
//                    //ignore LF characters
//                    continue;
//                } else if (ch == '\n') {
//                    //the end, break!
//                    break;
//                } else {
//                    curVal.append(ch);
//                }
//            }
//
//        }
//
//        result.add(curVal.toString());
//
//        return result;
//    }
//}
