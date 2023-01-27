package sg.edu.nus.iss.task01.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) throws FileNotFoundException, IOException{
        String fileName = args[0];
        String dirPath = System.getProperty("user.dir");
        File file = new File(dirPath + File.separator + fileName);

        String readString, strippedString;
        BufferedReader br = new BufferedReader(new FileReader(file));
        Integer freq = 0;
        Map<String,Integer> wordCounts = new LinkedHashMap<String,Integer>();
        try{
            while((readString = br.readLine()) != null){
                readString = readString.toLowerCase();
                strippedString = readString.replaceAll("\\p{Punct}", "");
                String[] wordArray = strippedString.split(" ");

                for(String word:wordArray){
                    freq = wordCounts.get(word);
                    if(freq == null){
                        freq = 1;
                    }
                    else{
                        freq +=1;
                    }
                    wordCounts.put(word, freq);
                }
            }

            //sort and print
           List<Map.Entry<String,Integer>> entrySetList = new LinkedList<Map.Entry<String,Integer>>(wordCounts.entrySet());
           //sort through a list
           Collections.sort(entrySetList,(map1,map2) -> map2.getValue().compareTo(map1.getValue()));

            //print out top 10 values 
            for(int i =0; i <10; i++){
                System.out.println("word: '" + entrySetList.get(i).getKey() + "', with number of counts Counts: " + entrySetList.get(i).getValue());
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            br.close();
        }


    }
}
