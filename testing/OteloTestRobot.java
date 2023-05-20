package testing;


import othello.OthelloGame;
import othello.OthelloWidget;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class OteloTestRobot {
	
	private static Robot r = null;
	private static final int polje = 65;
	private static final int goreOffset = 30;
	private static final int sirinaOffset = 5;
	
	private static void postaviNaPoljeIKlikni(int x, int y) {
		r.mouseMove(sirinaOffset + polje*x, goreOffset + polje*y );
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	private static Robot makeRobot() throws AWTException {
		if(r ==null)
			r = new Robot();
		return r;
	}
	@Before
	public void pre() throws AWTException {
		OthelloGame.main(null);
		r = makeRobot();
		
	}
	
	@Test 
	//@Ignore
	public void test1PraznoPolje() {
		postaviNaPoljeIKlikni(0,0);
		r.delay(100);
		assertTrue(true);
	}
	
	@Test 
	//@Ignore
	public void test2PunoPolje() {
		postaviNaPoljeIKlikni(4,4);
		r.delay(100);
		assertTrue(true);
	}
	
	@Test 
	public void test3RestartDugme() {
		r.mouseMove(sirinaOffset + polje*7, goreOffset + polje*8 - 10 );
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		r.delay(100);
	}
	
	
	@Test 
	public void test4PobedaCrni() {		
		postaviNaPoljeIKlikni(5,4);
		r.delay(100);
		postaviNaPoljeIKlikni(3,5);
		r.delay(100);
		postaviNaPoljeIKlikni(2,4);
		r.delay(100);
		postaviNaPoljeIKlikni(5,5);
		r.delay(100);
		postaviNaPoljeIKlikni(4,6);
		r.delay(100);
		postaviNaPoljeIKlikni(5,3);
		r.delay(100);
		postaviNaPoljeIKlikni(6,4);
		r.delay(100);
		postaviNaPoljeIKlikni(4,5);
		r.delay(100);
		postaviNaPoljeIKlikni(4,2);
		r.delay(100);
		postaviNaPoljeIKlikni(1,1);
		r.delay(100);
		postaviNaPoljeIKlikni(4,2);
		r.delay(100);
	}
	
	@Test
	public void test5KlikniVisePuta() {
		postaviNaPoljeIKlikni(3,3);
		r.delay(100);
		postaviNaPoljeIKlikni(3,3);
		r.delay(100);
		postaviNaPoljeIKlikni(4,4);
		r.delay(100);	
		postaviNaPoljeIKlikni(4,4);
		r.delay(100);	
	}
}
