package com.example.a2lab;

//klase, atsakinga uz zodziu ir zenklu skaiciavima
public class Counter {

    //metodas skaiciuojantis zodzius
    public int getWordsCount(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return 0; //grazinamas nulis, jei tekstas tuscias
        }

        //zodziai skaiciuojami atskiriant pagal tarpus
        String[] words = inputText.trim().split("\\s+");
        return words.length; //grazinamas zodziu skaicius
    }

    //metodas skaiciuojantis zenklus (neitraukiami tarpai)
    public int getCharacterCount(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return 0; //grazinamas nulis, jei tekstas tuscias
        }

        //tarpai pasalinami ir zenklai skaiciuojami
        return inputText.replaceAll("\\s+", "").length();
    }
}

