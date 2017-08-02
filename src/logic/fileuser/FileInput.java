package logic.fileuser;

import logic.Menu;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Waldrig on 16.07.2017.
 */
public class FileInput extends Menu {
    private ArrayList <String> readmeFile = new ArrayList<>();
    private ArrayList <BigInteger> secretMessageFile = new ArrayList<>();
    private ArrayList <String > openKeyFile = new ArrayList<>();
    private ArrayList <String> seceretKeyFile = new ArrayList<>();

    public FileInput(){
        //Наполнение README.txt
        this.readmeFile.add("В этом файле вы найдете информацию об файлах RSA.\r\n");
        this.readmeFile.add("OPENKEY.txt - содержит открытый ключ.\r\n");
        this.readmeFile.add("SECRET MESSAGE.txt - содержит зашифрованное сообщение.\r\n");
        this.readmeFile.add("SECRETKEY.txt - содержит секретный ключ.\r\n");
        this.readmeFile.add("\r\n");
        this.readmeFile.add("Как это работает?\r\n");
        this.readmeFile.add("Зашифрованное сообщение было зашифровано открытым ключем.\r\nВы передаёте сообщение другому человеку, который расшифрует его своим закрытым ключем.\r\n");
        this.readmeFile.add("\r\n");
        this.readmeFile.add("ВАЖНО!!! никому не сообщайте свой закрытый ключ.\r\n");
        //Наполнение SECRETMESSAGE.txt
        this.secretMessageFile = rsaEncrypt.getEncryptedMessage();
        //Наполнение OPENKEY.txt
        this.openKeyFile.add(generateKeys.getOpenE().toString());
        this.openKeyFile.add(" ");
        this.openKeyFile.add(generateKeys.getModul().toString());
        //Наполнение SECRETKEY.txt
        this.seceretKeyFile.add(generateKeys.getCloseD().toString());
        this.seceretKeyFile.add(" ");
        this.seceretKeyFile.add(generateKeys.getModul().toString());
    }
    public ArrayList<String> getReadme (){return readmeFile;}
    public ArrayList<BigInteger> getSecretMessageFile (){return secretMessageFile;}
    public ArrayList<String> getSeceretKeyFile() {return seceretKeyFile;}
    public ArrayList<String> getOpenKeyFile () {return openKeyFile;}
}
