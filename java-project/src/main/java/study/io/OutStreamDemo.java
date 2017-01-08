package study.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/1/2.
 */
public class OutStreamDemo {
    public static void generateCharacters_1(OutputStream out) throws IOException{
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacter = 94;
        int numberOfCharactersPerLine = 72;

        int start = firstPrintableCharacter;
        while (true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                out.write(((i-firstPrintableCharacter) % numberOfPrintableCharacter) + firstPrintableCharacter);
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstPrintableCharacter) % numberOfCharactersPerLine
                    + firstPrintableCharacter;
        }
    }

    public static void generateCharacters_2(OutputStream out) {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacter = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2];  //+2 对应着回车和换行

        while (true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) (((i - start) % numberOfPrintableCharacter) + firstPrintableCharacter);
            }
            line[numberOfCharactersPerLine] = '\r';
            line[numberOfCharactersPerLine + 1] = '\n';
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacter + firstPrintableCharacter;
        }
    }

    public static void generatePattern() {
        OutputStream out = null;
        try {
            out = new FileOutputStream("/log/project.log");
            //处理输出流。。。
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 利用带子源的try
         */
        try (OutputStream outStream = new FileOutputStream("/log/project.log")) {
            //处理输出流
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
