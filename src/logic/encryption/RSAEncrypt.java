package logic.encryption;




import logic.Menu;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Waldrig on 16.07.2017.
 */
public class RSAEncrypt extends Menu{

    private ArrayList<BigInteger> EncryptedMessage = new ArrayList<>();

    public void encrypt (){
        for (int i = 0; i < cesarEncrypt.getEncryptedMessage().size(); i++) {
            EncryptedMessage.add(BigInteger.valueOf(cesarEncrypt.getEncryptedMessage().get(i)).
                    modPow(generateKeys.getOpenE(),
                            generateKeys.getModul()));
            System.out.println("Расшифрованное сообщение: "+ BigInteger.valueOf(cesarEncrypt.getEncryptedMessage().get(i)));
        }
        System.out.println("Зашифрованное сообщение: " + EncryptedMessage);

    }
    public ArrayList<BigInteger> getEncryptedMessage (){return EncryptedMessage;}

}
