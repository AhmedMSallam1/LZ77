package LZ77Package;

public class LZ77_Code {
    private int length;
    private int index;
    private char nextChar;
    public void setLength(int length){
        this.length=length;
    }
    public void setIndex(int index){
        this.index=index;
    }
    public void setNextChar(char nextChar){
        this.nextChar=nextChar;
    }
    public int getLength(){
        return length;
    }
    public int getIndex(){
        return index;
    }
    public char getNextChar(){
        return nextChar;
    }
}
