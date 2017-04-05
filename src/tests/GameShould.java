package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Attempt;
import main.NonFinalFrame;
import main.Game;


public class GameShould {
	private Game game;
	
	@Before
	public void setup() {
		 game = new Game();
	}
	
	@Test
	public void BeCreated() {
		assertNotNull(game);
	}
	
	@Test
	public void HaveFrames() {
		assertTrue(game.getFrames() instanceof ArrayList);
	}
	
	@Test
	public void HaveTenFrames() {
		int expected = 10;
		assertEquals(expected, game.frames.size());
	}
	
	@Test
	public void GetCompletedFrames() {
		// TODO: finish test
	}
	
	@Test
	public void ReturnScore() {
		int numberOfPinsKnockedDown = 4;	
		game.updateScore(numberOfPinsKnockedDown);		
		assertEquals(4, game.getScore());
	}
		

}
