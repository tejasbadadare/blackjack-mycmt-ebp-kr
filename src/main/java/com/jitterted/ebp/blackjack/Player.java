package com.jitterted.ebp.blackjack;

public class Player {

    public Player(int balance) {
        this.playerBalance = balance;
    }
    public Player() {

    }

    private int playerBalance = 0;
    private int playerBet = 0;


    public int getPlayerBalance() {
        return playerBalance;
    }

    public int getPlayerBet() {
        return playerBet;
    }

    public void playerDeposits(int amount) {
        playerBalance += amount;
    }

    public void playerBets(int betAmount) {
        playerBet = betAmount;
        playerBalance -= betAmount;
    }

    public int playerBalance() {
        return playerBalance;
    }

    public void playerWins() {
        playerBalance += playerBet * 2;
    }

    public void playerLoses() {
        playerBalance += playerBet * 0;
    }

    public void playerTies() {
        playerBalance += playerBet * 1;
    }
}
