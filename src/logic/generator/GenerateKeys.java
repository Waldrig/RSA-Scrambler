package logic.generator;

import java.math.BigInteger;

/**
 * Created by Waldrig on 16.07.2017.
 */
public class GenerateKeys {
    private static BigInteger openE = new BigInteger("0");
    private static BigInteger openEiler = new BigInteger("0");
    private static BigInteger modul;
    private static BigInteger eiler;
    private static BigInteger closeD;


    public static void generateOpen(BigInteger p, BigInteger q) {

        modul = p.multiply(q);
        eiler = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
        openEiler = eiler;

        for (BigInteger e = BigInteger.valueOf(1); e.compareTo(eiler) < 0; e = e.add(BigInteger.ONE)) {
            if (e.isProbablePrime(1)) {
                if (BigInteger.ONE.compareTo(e.gcd(eiler)) == 0) {
                    if (!e.equals(BigInteger.valueOf(5))) {
                        System.out.println("Найдена открытая експонента");
                        openE = e;
                        break;
                    }
                }

            }
        }

        System.out.println("Ваш открытый ключ: " + "{" + openE + "," + modul + "}");
    }


    public static void generateClosed(){
        for (BigInteger i = BigInteger.valueOf(1); ;i = i.add(BigInteger.ONE)) {
            if (BigInteger.ONE.compareTo(i.multiply(openE).remainder(openEiler)) == 0){
                if (!i.equals(openE)) {
                    closeD = i;
                    break;
                } else {
                    continue;
                }
            }
        }
        System.out.println("Ваш закрытый ключ: " + "{" + closeD + "," + modul + "}");
    }


    public BigInteger getOpenE () {
        return openE;
    }

    public BigInteger getModul () {
        return modul;
    }

    public BigInteger getCloseD () {return closeD;}
}