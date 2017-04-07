package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Attempt;
import main.FinalFrame;

import org.junit.Before;
import org.junit.Test;


public class FinalFrameShould {
	private FinalFrame finalFrame;

	@Before
	public void setup() {
		finalFrame = new FinalFrame();
	}

	@Test
	public void BeCreated() {
		assertNotNull(finalFrame);
	}
	
	@Test
	public void HaveInitializedAttemptsInAFinalFrame() {
		int expected = 3;
		ArrayList<Attempt> attempts = finalFrame.getAttempts();
		assertEquals(expected, attempts.size());
	}
}
