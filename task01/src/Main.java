package sg.edu.nus.iss.task01.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main{

    public static void main(String[] args) throws FileNotFoundException, IOException{
        String fileName = args[0];
        String dirPath = System.getProperty("user.dir");
        File file = new File(dirPath + File.separator + fileName + ".txt");

        String readString, strippedString;
        BufferedReader br = new BufferedReader(new FileReader(file));
        Integer counts = 0;
        Integer totalWordCount = 0;
        Map<String,Integer> wordCounts = new LinkedHashMap<String,Integer>();
        try{
            while((readString = br.readLine()) != null){
                readString = readString.toLowerCase();
                strippedString = readString.replaceAll("\\p{Punct}", "");
                String[] wordArray = strippedString.split(" ");

                totalWordCount += strippedString.split(" ").length;
                for(String word:wordArray){
                    counts = wordCounts.get(word);
                    if(counts == null){
                        counts = 1;
                    }
                    else{
                        counts +=1;
                    }
                    wordCounts.put(word, counts);
                }
            }

            //sort and print
           List<Map.Entry<String,Integer>> entrySetList = new LinkedList<Map.Entry<String,Integer>>(wordCounts.entrySet());
           //sort through a list
           Collections.sort(entrySetList,(map1,map2) -> map2.getValue().compareTo(map1.getValue()));

            //print out top 10 values as well as frequency
            for(int i =0; i <10; i++){
                Float termFreq = ((float)entrySetList.get(i).getValue() / totalWordCount);
                System.out.printf("word: '%s', occurs '%d' with counts of %.3f \n", entrySetList.get(i).getKey(),entrySetList.get(i).getValue(), termFreq);
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            br.close();
        }


    }
}
