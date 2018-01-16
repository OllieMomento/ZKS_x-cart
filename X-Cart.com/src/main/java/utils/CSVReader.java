package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CSVReader {

    // for TestNG data provider
    public static Iterator<String[]> readCSVfileToIterator(String fileName) {
        List<String[]> records = new ArrayList<>();
        String record;

        try {
            try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
                while ((record = file.readLine()) != null) {
                    String fields[] = record.split(";");
                    records.add(fields);
                }
            }
            return records.iterator();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

   
    // for JUnit data provider
    public static Collection<String[]> readCSVfileToCollection(String fileName, String separator) throws FileNotFoundException, IOException {
        List<String[]> records = new ArrayList<>();
        String record;

        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(separator);
            //System.out.println(fields.length);
            records.add(fields);
        }
        file.close();
        return records;
    }


}
