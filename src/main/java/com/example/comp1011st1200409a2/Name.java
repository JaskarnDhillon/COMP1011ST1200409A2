package com.example.comp1011st1200409a2;

public class Name {
    private String common;
    private String official;

    public String getCommon() {
        return common;
    }

    public String getOfficial() {
        return official;
    }

    public String toString(){
        return String.format(official);
    }
}
