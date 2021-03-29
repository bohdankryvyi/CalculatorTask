package writingResults;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOutput {
    public static void fileOutput(String s) throws IOException {
        FileOutputStream fout = new FileOutputStream("data.txt");

        byte b[] = s.getBytes();//converting string into byte array
        fout.write(b);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String time = (formatter.format(date));
        byte c[] = time.getBytes();
        fout.write(c);

        fout.close();
    }
}
