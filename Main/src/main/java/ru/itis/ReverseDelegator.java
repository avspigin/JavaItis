package ru.itis;

/**
 * Created by KFU-user on 03.11.2016.
 */
public class ReverseDelegator {

    public String reverse(String source) {
        return ReversString.getRevers(source);
    }
}
