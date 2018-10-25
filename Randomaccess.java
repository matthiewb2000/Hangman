import java.io.IOException;
import java.io.RandomAccessFile;
public class Randomaccess
{
    // instance variables - replace the example below with your own
    static final String FILEPATH = "wordList.txt";
    public String str;

    /**
     * Constructor for objects of class Randomaccess
     */
    public Randomaccess() throws IOException{
        str = new String(readFromFile(FILEPATH));
    }
    
    private static String readFromFile(String filePath)
        throws IOException{
            //for(int i=0;i<10;i++)
            //{
            RandomAccessFile file = new RandomAccessFile(filePath, "r");
            long rNum = Math.round(Math.random()*(file.length()-1000));
            String str = new String();
            System.out.println("length is " + file.length());
            file.seek(rNum);
            str = file.readLine();
            str = file.readLine();
            file.close();
            
           //}
            return str;
    }
    
}
