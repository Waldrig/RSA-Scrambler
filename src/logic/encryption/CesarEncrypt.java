package logic.encryption;

import java.util.ArrayList;

/**
 * Created by Waldrig on 16.07.2017.
 */
public class CesarEncrypt {
    private String cesarMessage;
    private ArrayList <Integer> encryptedMessage = new ArrayList<>();

    public void cesar(String message, int key) {
        StringBuilder bufferMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            char symbols =  message.charAt(i);
            if (symbols >= 'А' && symbols<='Я')
            {
                int text = symbols - 'А' + key;
                text = text%33;
                bufferMessage.append((char) (text + 'А'));
            } else if (symbols>='а' && symbols <= 'я'){
                int text1 = symbols - 'а' + key;
                text1 = text1%33;
                bufferMessage.append((char) (text1+'а'));
            }
            else {
                bufferMessage.append(symbols);
            }
        }

        cesarMessage = bufferMessage.toString();
        System.out.println(cesarMessage);
    }

    public ArrayList<Integer> setEncryptedMessage (){
        char[] letters = cesarMessage.toCharArray();
        for (int i =0; i<letters.length; i++){
            encryptedMessage.add((int) letters[i]);
        }
        return encryptedMessage;
    }

    public ArrayList<Integer> getEncryptedMessage(){
        return encryptedMessage;
    }

}
