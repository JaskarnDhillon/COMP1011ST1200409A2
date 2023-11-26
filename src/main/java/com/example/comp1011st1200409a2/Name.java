package com.example.comp1011st1200409a2;

public class Name {
    private String common;
    private String official;

    /**
     * returns a string
     * @return
     */
    public String getCommon() {
        return common;
    }

    /**
     * returns a string
     * @return
     */
    public String getOfficial() {
        return official;
    }

    /**
     * method overrides default toString
     * to return an "official" string
     * @return
     */
    public String toString(){
        return String.format(official);
    }
}
