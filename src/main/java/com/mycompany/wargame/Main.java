package com.mycompany.wargame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String answer;
        boolean gameOn = true;
        boolean startGame = true;
        while(startGame){
            Deck talia = new Deck();
            while(gameOn){
                try{
                Thread.sleep(1000);}
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                if(!talia.game()) gameOn = false;
            }
            System.out.println("Chcesz zagracz jeszcze raz? (Tak/Nie)");
                answer = scan.next();
                if(answer.equals("Nie")){
                    startGame = false;
                }
                else if(answer.equals("Tak")){
                    gameOn = true;
                }
        }
        System.out.println("Dziekuje za gre");
    }
}
