package LZ77Package;
import java.util.*;
public class LZ77_Decompression {
    private String data;
    Scanner console = new Scanner(System.in);
    Scanner m = new Scanner(System.in);
    Vector<LZ77_Code> tags = new Vector<>();
    int numoftags;

    public LZ77_Decompression() {
        System.out.println("Please Enter The Number of Tags : ");
        numoftags = console.nextInt();
        System.out.println("Please Enter The Tags : ");
        for (int i = 0; i < numoftags; i++) {
            String code = "";
            String ans = "";
            code = m.nextLine();
            ans = code.substring(1, code.length() - 1);
            String[] arr = ans.split(",");
            int in = Integer.parseInt(arr[0]);
            int l = Integer.parseInt(arr[1]);
            LZ77_Code Temp = new LZ77_Code();
            Temp.setLength(l);
            Temp.setIndex(in);
            Temp.setNextChar(arr[2].charAt(0));
            tags.add(Temp);
        }
        decompressed();
    }

    public void decompressed() {
        System.out.println("Tags Are: ");
        //string which will be returned to decompress
        String dataa = "";
        //String temp="";
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getLength() == 0) {
                dataa += tags.get(i).getNextChar();
            } else {
                //get length of characters
                int sz = tags.get(i).getLength();
                //get length of string
                int dz = dataa.length();
                // calculate posion that will be start from the string
                int ind = Math.abs(dz - (tags.get(i).getIndex()));
                while (sz > 0) {
                    dataa += dataa.charAt(ind);
                    ind++;
                    sz--;
                }
                dataa += tags.get(i).getNextChar();
            }
        }
        System.out.println("After Decompression : " + dataa);
    }
}
