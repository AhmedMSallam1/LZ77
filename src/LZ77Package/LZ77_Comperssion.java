package LZ77Package;

import java.util.*;

public class LZ77_Comperssion {
    private String data;
    Scanner console=new Scanner ( System.in );

    Vector<LZ77_Code> tags = new Vector<>();

    public LZ77_Comperssion() {
        System.out.println("Please Input The Data To Encrypt : ");
        data=console.nextLine();
        compress();
    }

    public void compress() {
        //string which will store characters to check if found or not
        String temp = "";
        //store on it previous length and position
        int prevLength = 0;
        int prevPosition = 0;
        for (int i = 0; i < data.length(); i++) {
            //check if string iterate before or not
            boolean ok = false;
            temp += data.charAt(i);
            //represent length of string that will be iterated
            int length = 0;
            int j = 0;
            for (; j < i; j++) {
                //check if this string iterate in data string or not
                if (length == temp.length()) {
                    ok = true;
                    prevPosition = j; //j=0
                    length = 0;
                }
                if (temp.charAt(length) == data.charAt(j)) {
                    length++;

                } else if (temp.charAt(length) != data.charAt(j)) {
                    length = 0;
                }
            }
            if (length == temp.length()) {
                ok = true;
                prevPosition = j;
            }
            if (!ok) {
                LZ77_Code tempp = new LZ77_Code();
                if (prevPosition > 0) {
                    tempp.setIndex(Math.abs(j - prevPosition));
                } else {
                    tempp.setIndex(Math.abs(prevPosition));
                }
                tempp.setLength(prevLength);
                tempp.setNextChar(data.charAt(i));
                tags.add(tempp);

                prevLength = 0;
                prevPosition = 0;
                temp = "";
            } else {
                prevLength = temp.length();
            }
        }
        //ffff
        if (prevLength > 0) {
            LZ77_Code tempp = new LZ77_Code();
            tempp.setIndex(data.length() - prevPosition);
            tempp.setLength(prevLength - 1);
            tempp.setNextChar(data.charAt(data.length() - 1));
            tags.add(tempp);
        }
        printTags();
    }

    public void printTags() {
        System.out.println("Tags Are: ");
        for (LZ77_Code tag : tags) {
            System.out.println("<" + tag.getIndex() + "," + tag.getLength() + "," + tag.getNextChar() + ">");
        }
    }
}

