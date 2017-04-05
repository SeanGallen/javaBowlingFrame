package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import main.NonFinalFrame;
import main.Attempt;
import main.FinalFrame;
import main.Frame;
import main.Game;
import main.ScoringManager;

public class ScoringManagerShould {
  private ScoringManager manager;
  private Game game;

  @Before
  public void setup() {
    game = new Game();
    manager = new ScoringManager();
  }

  @Test
  public void BeCreated() {
    assertNotNull(manager);
  }

  @Test
  public void ScoreAGame() {
    playNonFinalFrame(1, 1, 2);
    playNonFinalFrame(2, 3, 4);

    int expectedScore = 10;
    int score = manager.score(game);

    assertEquals(expectedScore, score);
  }

  @Test
  public void ScoreAGameWithASpare() {
    playNonFinalFrame(1, 3, 7);
    playNonFinalFrame(2, 3, 4);

    int expectedScore = 20;
    int score = manager.score(game);

    assertEquals(expectedScore, score);
  }

  @Test
  public void ScoreAGameWithAStrike() {
    playNonFinalFrame(0, 10, 0);
    playNonFinalFrame(1, 3, 4);

    int expectedScore = 24;
    int score = manager.score(game);

    assertEquals(expectedScore, score);
  }

  @Test
  public void ScoreAPerfectGame() {
    playNonFinalFrame(0, 10, 0);
    playNonFinalFrame(1, 10, 0);
    playNonFinalFrame(2, 10, 0);
    playNonFinalFrame(3, 10, 0);
    playNonFinalFrame(4, 10, 0);
    playNonFinalFrame(5, 10, 0);
    playNonFinalFrame(6, 10, 0);
    playNonFinalFrame(7, 10, 0);
    playNonFinalFrame(8, 10, 0);
    playFinalFrame(9, 10, 10, 10);

    int expectedScore = 300;
    int score = manager.score(game);

    assertEquals(expectedScore, score);
  }

  private Frame playNonFinalFrame(int frameIndex, int firstAttempt, int secondAttempt) {
    NonFinalFrame frame = (NonFinalFrame) game.getFrames().get(frameIndex);

    ArrayList<Attempt> attempts = frame.getAttempts();

    Attempt attempt1 = attempts.get(0);
    Attempt attempt2 = attempts.get(1);

    attempt1.setPinsKnockedDown(firstAttempt);
    attempt2.setPinsKnockedDown(secondAttempt);

    frame.markAsComplete();

    return frame;
  }

  private Frame playFinalFrame(int frameIndex, int firstAttempt, int secondAttempt, int thirdAttempt) {
    FinalFrame frame = (FinalFrame) game.getFrames().get(frameIndex);

    ArrayList<Attempt> attempts = frame.getAttempts();

    Attempt attempt1 = attempts.get(0);
    Attempt attempt2 = attempts.get(1);
    Attempt attempt3 = attempts.get(2);

    attempt1.setPinsKnockedDown(firstAttempt);
    attempt2.setPinsKnockedDown(secondAttempt);
    attempt3.setPinsKnockedDown(thirdAttempt);

    frame.markAsComplete();

    return frame;
  }

}
