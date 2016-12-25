package study.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by SF on 2016/5/19.
 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String fname) throws Exception{
        try {
            in = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException e2){
                System.out.println("in.close() unsuccessful!");
            }

            throw e;
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }


    public void dispose() {
        try {
            in.close();
            System.out.println("in.close()  successful");
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
    }
}
