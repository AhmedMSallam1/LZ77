package LZ77Package;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner ( System.in );
        String data=input.nextLine();
        LZ77_Comperssion obj =new LZ77_Comperssion ( data );
        obj.compress ();
        obj.printTags ();
        obj.decompressed();

    }
}