package LZ77Package;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console=new Scanner ( System.in );
        int num;
        System.out.println("Please choose your operation :");
        System.out.println("1: Compression");
        System.out.println("2: Decompression");
        System.out.println("0: Exit");
        num=console.nextInt();
        while (num!=0){
            if (num==2){
                LZ77_Decompression dec = new LZ77_Decompression();
//            dec.decompressed();
            }else if(num==1){
                LZ77_Comperssion comp =new LZ77_Comperssion ();
//            comp.compress ();
            } else if (num==0) {
                System.exit(0);
            }
            System.out.println("Please choose your operation :");
            System.out.println("1: Compression");
            System.out.println("2: Decompression");
            System.out.println("0: Exit");
            num=console.nextInt();
        }
    }
}