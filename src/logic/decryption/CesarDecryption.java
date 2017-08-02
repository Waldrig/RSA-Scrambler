package logic.decryption;

import logic.Menu;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Waldrig on 17.07.2017.
 */
public class CesarDecryption extends Menu {
    private String decryptedMessage;
    private String decryptedCesarMessage;

    public String getDecryptedMessage () {

        char lettersBuffer;
        String messages = "";
        for (int i = 0; i < rsaDecryption.getDecryptedMassage().length; i++){
            lettersBuffer = (char) Integer.parseInt(rsaDecryption.getDecryptedMassage()[i].toString());
            messages += lettersBuffer + " ";
            System.out.println("Данные считанные: " + messages);
        }
        return decryptedMessage = messages;
    }


    public String decryptCesar (int key) throws IOException {

        StringBuilder Message = new StringBuilder();

        for (int i = 0; i < decryptedMessage.length(); i++){

            char text =  decryptedMessage.charAt(i);

            if (text >= 'А' && text<='Я')
            {
                int text1 = text - 'А' - key;
                text1 = text1%26;
                Message.append((char) (text1 + 'А'));
            } else if (text>='а' && text <= 'я'){
                int text1 = text - 'а' - key;
                text1 = text1%26;
                Message.append((char) (text1+'а'));
            }
            else {
                Message.append(text);
            }
        }
        decryptedCesarMessage = Message.toString();
        System.out.println(decryptedCesarMessage);
        return decryptedCesarMessage;
    }
}
