package ru.itis;

/**
 * Created by KFU-user on 03.11.2016.
 */
public class ReversString {

    public static String getRevers(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
}
