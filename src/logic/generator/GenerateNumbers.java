package logic.generator;

import logic.Menu;

import java.math.BigInteger;

/**
 * Created by Waldrig on 16.07.2017.
 */
public class GenerateNumbers extends Menu {
    private static BigInteger firstNumber = new BigInteger("0");
    private static BigInteger secondNumber = new BigInteger("0");
    private static int maxNumber = 0;
    private static int minNumber = 0;


    public static void setSimpleNumbers (int min, int max){

        if (min > 0 && max < 10000) {
            for (BigInteger e = BigInteger.valueOf(min);
                 e.compareTo(BigInteger.valueOf(max)) < 0;
                 e = e.add(BigInteger.ONE)) {
                if (e.isProbablePrime(1)) {
                    firstNumber = e;
                    secondNumber = firstNumber.nextProbablePrime();
                    if (firstNumber.multiply(secondNumber).compareTo(BigInteger.valueOf(maxNumber)) > 0) {
                        break;
                    }
                }
            }
        } else if(min < 0){
            System.out.println("Минимальное число должно быть больше 6000");
        } else if(max > 10000){
            System.out.println("Максимальное число должно быть меньше 10000");
        }
        System.out.println(firstNumber);
        System.out.println(secondNumber);
    }

    public static void bigestNumber (){
        for (int i = 0; i < cesarEncrypt.getEncryptedMessage().size(); i++){
            if(maxNumber<cesarEncrypt.getEncryptedMessage().get(i))
                maxNumber = cesarEncrypt.getEncryptedMessage().get(i);
            if(minNumber>cesarEncrypt.getEncryptedMessage().get(i))
                minNumber = cesarEncrypt.getEncryptedMessage().get(i);
        }
    }

    public BigInteger getFirstNumber (){return firstNumber;}
    public BigInteger getSecondNumber (){
        return secondNumber;
    }
}
