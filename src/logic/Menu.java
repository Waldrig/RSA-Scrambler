package logic;

import logic.decryption.CesarDecryption;
import logic.decryption.RSADecryption;
import logic.encryption.CesarEncrypt;
import logic.encryption.RSAEncrypt;
import logic.generator.GenerateKeys;
import logic.generator.GenerateNumbers;
import logic.fileuser.FileGenerator;
import logic.fileuser.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Waldrig on 16.07.2017.
 */
public class Menu {
    public static CesarEncrypt cesarEncrypt = new CesarEncrypt();
    public static GenerateNumbers generateNumbers = new GenerateNumbers();
    public static GenerateKeys generateKeys = new GenerateKeys();
    public static RSAEncrypt rsaEncrypt = new RSAEncrypt();
    public static FileGenerator fileGenerator = new FileGenerator();
    public static FileReader fileReader = new FileReader();
    public static RSADecryption rsaDecryption = new RSADecryption();
    public static CesarDecryption cesarDecryption = new CesarDecryption();
    private static String message;
    private static int key;
    private static int max, min;
// Всё работает, осталось переписать всё по новой. Разделить шифрователь и дешифрователь. Усоврешенствовать логику (минимальное
    //и максимальное числа должны быть большими, иначе не правильна дешифровка.
    public static void main(String[] args){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите сообщение");
            message = reader.readLine();
            System.out.println("Введите ключ для предварительного шифрования сообщения");
            key = Integer.parseInt(reader.readLine());
            System.out.println("Введите минимальное значение для генерации пары чисел");
            min = Integer.parseInt(reader.readLine());
            System.out.println("Введите максимальное значение для генерации пары чисел");
            max = Integer.parseInt(reader.readLine());
            cesarEncrypt.cesar(message, key);
            cesarEncrypt.setEncryptedMessage();
            generateNumbers.setSimpleNumbers(min, max);
            generateKeys.generateOpen(generateNumbers.getFirstNumber(), generateNumbers.getSecondNumber());
            generateKeys.generateClosed();
            rsaEncrypt.encrypt();
            fileGenerator.fileCreator();
            fileReader.readFromFile();
            rsaDecryption.setDecryptedMassage();
            cesarDecryption.getDecryptedMessage();
            cesarDecryption.decryptCesar(key);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
