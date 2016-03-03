/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Comparator;

/**
 *
 * @author Anael
 */
public class Score implements Comparable{
    
    private String userName;
    private int wins;
    private int balance;

    @Override
    public String toString() {
        return userName + " " + wins + " " + balance;
    }
    
    public Score (){}
    
    public Score(String userName,int wins,int balance)
    {
        this.userName = userName;
        this.wins = wins;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public int compareTo(Score comparestu) {
        int compareage=((Score)comparestu).getBalance();
        /* For Ascending order*/
        return this.balance-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Score)
        {
           int compareage=((Score)o).getBalance();
        /* For Ascending order*/
        return compareage-this.getBalance();
        }
        else return 0;
    }
    
    
    
}
