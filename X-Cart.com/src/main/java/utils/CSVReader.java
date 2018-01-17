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

    public static Object[][] readCSVfile(String fileName) {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		int lenght = 0;

		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			while ((record = file.readLine()) != null) {
				String fields[] = record.split(",");
				records.add(fields);
				lenght++;
			}
			file.close();


			//System.out.println(records.size());


			Object[][] returnObject = new Object[records.size()][];
			for (int itemIndex = 0; itemIndex < records.size(); itemIndex++) {
				System.out.println(itemIndex);
				returnObject[itemIndex] = records.get(itemIndex);
			}
			return returnObject;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
    // for TestNG data provider
    public static Iterator<Object[]> readCSVfileToIterator(String fileName) {
        List<Object[]> records = new ArrayList<>();
        String record;

        try {
            try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
                while ((record = file.readLine()) != null) {
                    String fields[] = record.split("\t");
                    Object[] obj = null;
                    for (int i = 0; i < fields.length; i++) {
                        obj = new Object[fields.length];
                        obj[i] = fields[i];
                        
                    }
                    records.add(obj);
                }
            }
            return records.iterator();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static Object[][] readCSVfileToObject(String fileName) {
        Object[][] records = new Object[6][12];
        String record;

        try {
            try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
                int r = 0;
                while ((record = file.readLine()) != null) {
                    String fields[] = record.split("\t");
                    for (int i = 0; i < fields.length; i++) {
                        
                        records[r][i] = fields[i];
                        
                    }
                 r++;   
                }
            }
            return records;
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
