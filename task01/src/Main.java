package sg.edu.nus.iss.task01.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        String fileName = args[0];
        String dirPath = System.getProperty("user.dir");
        File file = new File(dirPath + File.separator + fileName);

        String readString, strippedString;
        BufferedReader br = new BufferedReader(new FileReader(file));
        Integer wordCount = 0;
        Map<String,Integer> topWords = new HashMap<String,Integer>();
        try{
            while((readString = br.readLine()) != null){
                strippedString = readString.replaceAll("\\p{Punct}", "");
                wordCount = strippedString.split(" ").length;
                System.out.println(wordCount);
                System.out.println(strippedString);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            br.close();
        }


    }
}
