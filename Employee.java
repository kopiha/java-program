import java.io.*;
import java.util.*;
public class SimpleWordCount{
public static void main(String[]args){
try{
BufferReader br=new BufferedReader(new FileReader("Input.txt"));
Hashmap<String,Integer>counts=new Hashmap<>();
String line;
while(line=br.readLine())!=null){
String[] words=line.tolowercase().Spilt("\\W+");
for(String word: words)
if(!word.isEmpty()){
 if(counts.containskeyword)){
counts.put(word,counts.get(word)+1);
}else{
counts.put(word,1);
}
}
}
}
br.close():
System.out.println("W+="+counts.get(w));
}
}catch(Exception e){
 System.out.println("Error:"+e);
  }
}
}
