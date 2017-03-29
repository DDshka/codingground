import java.io.*;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        SymbString ss = new SymbString("213");  
        System.out.println(ss.Get());
        
        ss.Add("KAK_SLIHNO-TO?");  
        System.out.println(ss.Get());
        
        ss.Sub("213");  
        System.out.println(ss.Get());
        
        DecString dc = new DecString("123w2312", true);
        System.out.println(dc.Get());
        
        dc = new DecString("6662312");
        System.out.println(dc.Get());
     }
}
