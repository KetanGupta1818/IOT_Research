package morsecode;


import java.util.*;
import java.io.*;

public class Dictionary {

    public static String[] characterToMorseCode = new String[256];
    public static Map<String,Character> morseCodeToCharacter = new HashMap<>();
    public static void createDictionary() {
        for(int a=0;a<256;a++){
            StringBuilder cur_code = new StringBuilder();
            for(int i=0;i<8;i++){
                if((a&(1<<i))>0) cur_code.append("-");
                else cur_code.append(".");
            }
            morseCodeToCharacter.put(cur_code.toString(),(char)a);

            characterToMorseCode[a] = cur_code.toString();
        }
    }
}

