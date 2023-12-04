package morsecode;

import java.io.*;

import static morsecode.Dictionary.*;
public class Main {
    public static void main(String[] args) throws IOException {
        createDictionary();
        long start = System.currentTimeMillis();
     //   long len = encrypt("input2.txt","output2.txt");
        long len = decrypt("input2.txt","output2.txt");
        long end = System.currentTimeMillis();
        System.out.println("decryption of length "+len + " takes " + (end-start) + " milliseconds");
    //    System.out.println("encryption of length "+len + " takes " + (end-start) + " milliseconds");
    }
    private static long encrypt(String inputFileName,String outputFileName) throws IOException {
        File file = new File("src\\morsecode\\encrypt\\"+ inputFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder message = new StringBuilder();
        while ((st = br.readLine()) != null)
            message.append(st);
        StringBuilder encryptedMessage = new StringBuilder();
        for(int i=0;i<message.length();i++){
            encryptedMessage.append(characterToMorseCode[message.charAt(i)]);
        }
        FileWriter out = new FileWriter("src\\morsecode\\encrypt\\"+outputFileName);
        out.write(encryptedMessage.toString());
        out.flush();
        out.close();
        return message.length();
    }
    private static long decrypt(String inputFileName,String outputFileName) throws IOException {
        File file = new File("src\\morsecode\\decrypt\\"+ inputFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder message = new StringBuilder();
        while ((st = br.readLine()) != null)
            message.append(st);
        StringBuilder decryptedMessage = new StringBuilder();
        final int width = 8;
        for(int i=0;i<message.length();i+=width){
       //     decryptedMessage.append(morseCodeToCharacter.get(message.substring(i,i+width)));
            int cur = 0;
            for(int j=0;j<width;j++) {
                if(message.charAt(i+j) == '-') cur += (1<<j);
            }
            decryptedMessage.append((char)(cur));
        }
        FileWriter out = new FileWriter("src\\morsecode\\decrypt\\"+outputFileName);
        out.write(decryptedMessage.toString());
        out.flush();
        out.close();
        return decryptedMessage.length();
    }
}
