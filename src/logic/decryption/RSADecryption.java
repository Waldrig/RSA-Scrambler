package logic.decryption;

import logic.Menu;

import java.math.BigInteger;

/**
 * Created by Waldrig on 17.07.2017.
 */
public class RSADecryption extends Menu {
    private BigInteger [] decryptedMassage;

    public void setDecryptedMassage (){
        decryptedMassage = new BigInteger[fileReader.getNumbers().length];

        for (int i = 0; i < fileReader.getNumbers().length; i++) {
            decryptedMassage[i] = fileReader.getNumbers()[i].modPow(generateKeys.getCloseD(), generateKeys.getModul());
            System.out.println("Данные из файлридера" + fileReader.getNumbers()[i]);
            System.out.println("Данные из RSADEcr " + decryptedMassage[i]);
        }
    }

    public BigInteger [] getDecryptedMassage (){
        return decryptedMassage;
    }
}
