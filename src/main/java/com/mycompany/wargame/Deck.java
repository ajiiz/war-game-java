package com.mycompany.wargame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> karty = new ArrayList();
    private final List<Card> gracz = new ArrayList();
    private final List<Card> komputer = new ArrayList();
    
    Deck(){
        //Tworzenie tali kart
        String []kolory = {"Pik","Wino","Kier","Karo"};
        String []wartosci = {"9","10","Walet","Dama","Krol","As"};
        int []sila = {1,2,3,4,5,6};
        for(int i=0;i<4;i++){
            for(int j = 0;j<6;j++){
                karty.add(new Card(kolory[i],wartosci[j],sila[j]));
            }
        }
        
        //Tasowanie Kart
        Collections.shuffle(karty);
        
        //Tworzenie tali gracza i komputera
        for(int i = 0;i<this.karty.size();i++){
            if(i<12) gracz.add(karty.get(i));
            else komputer.add(karty.get(i));
        }
    }
    
    public boolean game(){
        if(gracz.get(0).getMoc() > komputer.get(0).getMoc()){
            System.out.println("Gracz: "+gracz.get(0).getKarta()+" vs "+komputer.get(0).getKarta()+" :Komputer");
            System.out.println("Potyczke wygrywa gracz!\n");
            deleteCards("Gracz",1);
        }
        else if(gracz.get(0).getMoc() < komputer.get(0).getMoc()){
            System.out.println("Gracz: "+gracz.get(0).getKarta()+" vs "+komputer.get(0).getKarta()+" :Komputer");
            System.out.println("Potyczke wygrywa komputer!\n");
            deleteCards("Komputer",1);
        }
        else if(gracz.get(0).getMoc() == komputer.get(0).getMoc()){
            int cardNeeded = 3;
            System.out.print("Gracz: "+gracz.get(0).getKarta()+" vs "+komputer.get(0).getKarta()+": Komputer\n");
            while(true){
                System.out.println("Wojna!");
                if(gracz.size()<cardNeeded) {
                    announceWinner("Komputer");
                    return false;
                }
                else if(komputer.size()<cardNeeded){
                    announceWinner("Gracz");
                    return false;
                }
                System.out.println("Gracz(Karta Przykryta)"+"    "+"(Karta Przykryta)Komputer"); 
                System.out.println("Gracz: "+gracz.get(cardNeeded-1).getKarta()+" vs "+komputer.get(cardNeeded-1).getKarta()+": Komputer");
                
                if(gracz.get(cardNeeded-1).getMoc() > komputer.get(cardNeeded-1).getMoc()){
                    deleteCards("Gracz",cardNeeded);
                    System.out.print("Potyczke wygrywa gracz!\n");
                    break;
                }
                else if(gracz.get(cardNeeded-1).getMoc()<komputer.get(cardNeeded-1).getMoc()){
                    deleteCards("Komputer",cardNeeded);
                    System.out.print("Potyczke wygrywa komputer!\n");
                    break;
                }
                cardNeeded+=2;
            }
            
        }
        if(gracz.isEmpty()){
            announceWinner("Komputer");
            return false;
        }
        else if(komputer.isEmpty()) {
            announceWinner("Gracz");
            return false;
        }
        return true;
    }
    
    public void deleteCards(String winner, int num){
        if(gracz.size()<num || komputer.size()<num){
            announceWinner(winner);
        }
        for(int i = 0; i < num; i++){
            if(winner.equals("Gracz")){
                gracz.add(komputer.get(0));
                komputer.remove(0);
                gracz.add(gracz.get(0));
                gracz.remove(0);
            }
            else if(winner.equals("Komputer")){
                komputer.add(gracz.get(0));
                gracz.remove(0);
                komputer.add(komputer.get(0));
                komputer.remove(0);
            }
        }
    }
    
    public void announceWinner(String winner){
        if(winner.equals("Gracz")) System.out.println("\nKomputerowi skonczyly sie karty");
        else System.out.println("\nGraczowi skonczyly sie karty");
        System.out.println("\nKoniec gry!");
        System.out.println("\nWygrywa: "+winner);
    }
    
    //Metody testowe/pomocnicze
    public void showDeck(){
        for(int i = 0; i < karty.size();i++){
            System.out.println(karty.get(i).toString());
        }
    }
    
    public void showPlayersDeck(){
        for(int i = 0; i < gracz.size();i++){
            System.out.print(gracz.get(i).toString());
        }
    }
    
    public void showComputersDeck(){
        for(int i = 0; i < komputer.size();i++){
            System.out.print(komputer.get(i).toString());
        }
    }
}
