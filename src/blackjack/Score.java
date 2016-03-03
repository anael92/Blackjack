
package blackjack;

/**
 *
 * @author ANI
 */

// This class helps with organize score table
 
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

    @Override
    public int compareTo(Object o) {
        if (o instanceof Score)
        {
           int compareage=((Score)o).getBalance();
        /* For Descending order*/
        return compareage-this.getBalance();
        }
        else return 0;
    }
    
    
    
}
