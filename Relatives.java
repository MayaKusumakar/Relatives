import java.io.*;
import java.util.*;
public class Relatives{
   public static void main(String[] args) throws Exception{
      Map<String, Set<String>> map = new TreeMap<String, Set<String>>();
      String fileName = "lab08c.dat";
      Scanner file = new Scanner(new File(fileName));
      
      String key = "";
   String val = "";
   boolean first = true;
      int count = 0;
   int length = file.nextInt();
   file.nextLine();
       while(file.hasNext()){
            String line = file.nextLine();
            //System.out.println(line);

         for(int i = 0; i < line.length(); i++){
            String letter = line.substring(i, i+1);
         if(letter.equals(" ")){
            first = false;
         }
         if(first){
            key += letter;
         } else {
            if(!(letter.equals(" "))){
            val += letter;
            }
            
      }
      
   }
      if(count >= length){
         break;
      }
      
      if(map.containsKey(key)){
         
         Set<String> s = map.get(key);
         s.add(val);
         map.put(key,s);
      } else{
        Set<String> s = new TreeSet<String>();
        s.add(val);
        map.put(key,s);
     }
      first = true;
      key = "";
      val = "";
      count++;
   }
   
   
   
   System.out.println(map);
   System.out.println();
   
   for(String s : map.keySet()){
      String sentence = "";
      sentence += s;
      sentence += " is related to ";
      for(String str : map.get(s)){
         sentence += str + "";
      }
      System.out.println(sentence);
   }
   System.out.println();
   //System.out.println(map.get("Dot"));
   System.out.println("Dot is related to" + map.get("Dot"));
}
}