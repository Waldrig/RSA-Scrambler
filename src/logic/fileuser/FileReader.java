package logic.fileuser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Waldrig on 17.07.2017.
 */
public class FileReader {
    private String [] line;
    private BigInteger[] numbers;
    private String path;

    public void readFromFile () throws IOException {
        System.out.println("Укажите путь к зашифрованным данным: ");
        FileGenerator fileGenerator = new FileGenerator();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            path = r.readLine();
            File f = new File(path + "\\" + fileGenerator.getDIRR() + "\\" + fileGenerator.getMESSAGE());
            BufferedReader fin = new BufferedReader(new java.io.FileReader(f));
            line = fin.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        numbers = new BigInteger[line.length];
        for (int i = 0; i < line.length; i++) {
            numbers[i] = BigInteger.valueOf(Integer.parseInt(line[i]));
            System.out.println(numbers[i]);
        }
        if (numbers != null) {
            System.out.println("Данные считаны");
        }
    }
    public BigInteger[] getNumbers (){
        return numbers;
    }
}
