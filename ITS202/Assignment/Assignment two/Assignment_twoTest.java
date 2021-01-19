import java.io.*;  
import java.util.Scanner; 

public class Assignment_twoTest{  
    public static void main(String args[]){ 

        try{ 
            Assignment_two<String, Integer> obj = new Assignment_two<>();  
            FileInputStream fis=new FileInputStream("./input.txt");       
            Scanner sc=new Scanner(fis);

            while(sc.hasNextLine()){  

                String temp = sc.nextLine();
                String tem = temp;
                String[] line = temp.split(" ",3);

                if(tem.contains("PUT")){
                    int i=Integer.parseInt(line[2]);
                    obj.put(line[1],i);

                }else if(tem.contains("KEYS")){
                    for (String s : obj.keys(line[1],line[2]))
                    System.out.print(s+" ");
                    System.out.println();
                
                }else if(tem.contains("GET")) System.out.println(obj.get(line[1]));

                else if(tem.contains("FLOOR")) System.out.println(obj.floor(line[1]));

                else if(tem.contains("SELECT")){
                    int i=Integer.parseInt(line[1]);
                    System.out.println(obj.select(i));
                
                }else if(tem.contains("SIZE")) System.out.println(obj.size());
                else if(tem.contains("MIN")) System.out.println(obj.min());
                else System.out.println("sorry...!!!");

            }

            sc.close(); 
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }  
}   
