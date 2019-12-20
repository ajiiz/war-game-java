package com.mycompany.wargame;

public class Card {
    private final String kolor;
    private final String wartosc;
    private final int moc;
    
    Card(String kolor, String wartosc,int moc){
        this.kolor=kolor;
        this.wartosc=wartosc;
        this.moc = moc;
    }
    
    public int getMoc(){
        return this.moc;
    }
    public String getKarta(){
        return this.wartosc+" "+this.kolor;
    }
    @Override
    public String toString(){
        return " "+this.kolor+" "+this.wartosc+" "+this.moc+"\n";
    }
}
