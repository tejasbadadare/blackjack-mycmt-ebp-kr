package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingOutcomeTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Player player = createGameWithPlayerBalanceOf(20);
    player.playerBets(10);

    player.playerWins();

    assertThat(player.playerBalance())
        .isEqualTo(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Player player = createGameWithPlayerBalanceOf(80);
    player.playerBets(70);

    player.playerTies();

    assertThat(player.playerBalance())
        .isEqualTo(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Player player = createGameWithPlayerBalanceOf(35);

    player.playerBets(30);
    player.playerLoses();

    assertThat(player.playerBalance())
        .isEqualTo(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Player player = createGameWithPlayerBalanceOf(40);

    player.playerBets(15);

    assertThat(player.playerBalance())
        .isEqualTo(25);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Player player = createGameWithPlayerBalanceOf(18);

    assertThat(player.playerBalance())
        .isEqualTo(18);
  }


  private Player createGameWithPlayerBalanceOf(int amount) {
    Player player = new Player();
    player.playerDeposits(amount);
    return player;
  }
}