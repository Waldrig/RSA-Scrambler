package logic.fileuser;

import java.io.*;

/**
 * Created by Waldrig on 16.07.2017.
 */
public class FileGenerator {
    private String path;
    private final String DIRR = "RSA Encryption";
    private final String OPENKEY = "OPENKEY.txt";
    private final String SECRETKEY = "SECRETKEY.txt";
    private final String MESSAGE = "SECRET MESSAGE.txt";
    private final String README = "README.txt";

    public void fileCreator (){

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Укажите путь к папке в которой создать файлы: ");
        try {

            path = r.readLine();
            File directory = new File(path+ "\\" + DIRR);

            boolean createdDirectory = directory.mkdir();


            if(createdDirectory) {
                File openKey = new File(path + "\\" +  DIRR, OPENKEY);
                File readme = new File(path+ "\\" + DIRR, README);
                File secretKey = new File(path+ "\\" + DIRR, SECRETKEY);
                File message = new File(path+ "\\" + DIRR, MESSAGE);

                boolean createdOpenKey = openKey.createNewFile();
                boolean createdReadme = readme.createNewFile();
                boolean createdSecretKey = secretKey.createNewFile();
                boolean createdMessage = message.createNewFile();

                if (createdMessage && createdOpenKey && createdSecretKey && createdReadme) {
                    fileInput();
                    System.out.println("Файлы созданы");
                }
            } else if (directory.exists()) {
                fileInput();
                System.out.println("Файлы были обновлены");
            } else {
                System.out.println("Дирректория не создана");
            }

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void fileInput (){
        FileInput fileInput = new FileInput();
        try {

            FileWriter OpenKey  = new FileWriter(path+ "\\" + DIRR+ "\\" +OPENKEY, false);
            FileWriter Readme  = new FileWriter(path+ "\\" + DIRR+ "\\"+README, false);
            FileWriter SecretKey  = new FileWriter(path+ "\\" + DIRR+ "\\"+SECRETKEY, false);
            FileWriter Message  = new FileWriter(path+ "\\" + DIRR+ "\\"+MESSAGE, false);
            for (int i = 0; i < fileInput.getReadme().size(); i++){
                Readme.write(fileInput.getReadme().get(i));
            }
            for (int i = 0; i < fileInput.getSecretMessageFile().size(); i++){
                Message.write(fileInput.getSecretMessageFile().get(i).toString());
                Message.write(" ");
            }
            for (int i = 0; i < fileInput.getOpenKeyFile().size(); i++){
                OpenKey.write(fileInput.getOpenKeyFile().get(i));
                Message.write(" ");
            }
            for (int i = 0; i < fileInput.getSeceretKeyFile().size(); i++){
                SecretKey.write(fileInput.getSeceretKeyFile().get(i));
                Message.write(" ");
            }
            Readme.flush();
            Message.flush();
            OpenKey.flush();
            SecretKey.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public String getDIRR (){
        return DIRR;
    }
    public  String getMESSAGE (){
        return MESSAGE;
    }
}
