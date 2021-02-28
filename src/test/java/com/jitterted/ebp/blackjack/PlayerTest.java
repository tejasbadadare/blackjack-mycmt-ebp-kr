package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayerDepositIncreasesPlayerBalance() {
        Player player = new Player();
        int depositAmount = 10;

        player.playerDeposits(depositAmount);

        assertThat(player.playerBalance()).isEqualTo(depositAmount);
    }

    @Test
    public void testPlayerBetReducesPlayerBalance() {
        Player player = new Player(100);
        int betAmount = 10;

        player.playerBets(betAmount);

        assertThat(player.playerBalance()).isEqualTo(100 - 10);
    }

    @Test
    public void testPlayerWinGivesDoublePayout() {
        Player player = new Player(100);
        int betAmount = 10;

        player.playerBets(betAmount);
        player.playerWins();

        assertThat(player.playerBalance()).isEqualTo(100 + 10);
    }

    @Test
    public void testPlayerLosesGivesNoPayout() {
        Player player = new Player(100);
        int betAmount = 10;

        player.playerBets(betAmount);
        player.playerLoses();

        assertThat(player.playerBalance()).isEqualTo(100 - 10);
    }

    @Test
    public void testPlayerTiesGivesBetBack() {
        Player player = new Player(100);
        int betAmount = 10;

        player.playerBets(betAmount);
        player.playerTies();

        assertThat(player.playerBalance()).isEqualTo(100);
    }
}