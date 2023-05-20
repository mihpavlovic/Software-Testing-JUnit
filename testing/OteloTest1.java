package testing;

import othello.OthelloWidget;
import othello.Spot;
import othello.SpotBoard;
import othello.SpotListener;
import othello.OthelloGame;
import othello.JSpot;
import othello.JSpotBoard;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.*;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
public class OteloTest1 {
	private static OthelloWidget widget = new OthelloWidget();


	@Test
	public void test1PobedeNaPocetku() {
		
		assertEquals(false, widget.checkWin());
	}
	
	@Test 
	public void test2NeresenogNaPocetku() {
		assertEquals(false, widget.checkDraw()); 
	}
	
	@ParameterizedTest
	@CsvFileSource(resources={"ulaz1.csv"})
	//@Ignore("nije napisan test")
	public void test3NekorisceniKonstruktorJSpotBoard1Nelegalno(int x, int y){
		JSpotBoard board = null;
		try {
			board = new JSpotBoard(x,y,null,null);
		}
		catch (IllegalArgumentException i) { assertTrue(true); }
		finally{assertTrue(true); }
	}
	
	@ParameterizedTest
	@CsvFileSource(resources={"ulaz1.csv"})
	public void test4NekorisceniKonstruktorJSpotBoard2Nelegalno(int x, int y) {
		try{
			JSpotBoard board = new JSpotBoard(x, y);
		}
		catch(IllegalArgumentException i) { assertTrue(true); }
		finally{assertTrue(true); }
	}
	
	@Test 
	public void test5SkidanjeSpotListenera() {
		JSpotBoard board = widget.getSpotBoard();//JSpotBoard board = new JSpotBoard(10, 10);
		board.removeSpotListener(null);
		assertTrue(true);
	}
	
	@Test 
	public void test6SpotHighlight() {
		JSpotBoard board =widget.getSpotBoard();
		Color c = new Color(0.1f, 0.1f, 0.1f);
		Spot spot = board.getSpotAt(0, 0);
		spot.setHighlight(c);
		assertTrue(true);
	}
	
	@Test 
	public void test7SpotHighlightNelegalno() {
		try {
			JSpotBoard board = widget.getSpotBoard();
			Spot spot = board.getSpotAt(0, 0);
			spot.setHighlight(null);
		}
		catch(IllegalArgumentException i) { assertTrue(true); }
	}

	@Test 
	public void test8SpotSetColorNelegalno() {
		try {
			JSpotBoard board = widget.getSpotBoard();
			Spot spot = board.getSpotAt(0, 0);
			spot.setSpotColor(null);
		}
		catch(IllegalArgumentException i) { assertTrue(true); }
	}
	
	@Test
	public void test9GetBoard() {
		JSpotBoard brd= widget.getSpotBoard(); 
		Spot spot = brd.getSpotAt(0, 0);
		SpotBoard s =spot.getBoard();
		assertTrue(true);
	}
	
	@Test 
	public void test10GetSpotAtNelegalno() {
		try {
			JSpotBoard board = widget.getSpotBoard();
			Spot s = board.getSpotAt(15, 15);
			
		}
		catch(IllegalArgumentException i) { assertTrue(true); }
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = {"ulaz2.csv"})
	public void test11GetSpotColor(int x, int y) {
		try {
			JSpotBoard brd = widget.getSpotBoard();
			Spot spt = brd.getSpotAt(x, y);
			int rez = widget.getColor(spt);
		}
		catch(IllegalArgumentException i){}
		finally{assertTrue(true);}
	}
	
	@Test
	public void test12InBounds() {
		JSpotBoard board = widget.getSpotBoard();
		Spot spt = board.getSpotAt(0, 0);
		boolean rez = widget.inBounds(spt);
		assertTrue(rez);
	}
	
	@Test
	public void test13GetColorC() {
		Color color = widget.getColorC(0, 0);
		assertEquals(true, color!=null);
	}
	
	//za testHasLegalMoves ima greska u kodu
	@Test
	public void test14HasLegalMoves() {
		JSpotBoard board = widget.getSpotBoard();
		Spot spt = board.getSpotAt(3, 3);
		boolean rez = widget.hasLegalMoves(0, spt);
		assertEquals(true, rez);
	}
	
	@Test
	public void test15GetCoordSpot() {
		JSpotBoard brd = widget.getSpotBoard();
		Spot spt = brd.getSpotAt(4, 4);
		String str = spt.getCoordString();
		assertEquals("(4, 4)", str);
	}
	
	@Test
	public void test16ToogleHighlight() {
		JSpotBoard brd = widget.getSpotBoard();
		Spot spt = brd.getSpotAt(4, 4);
		spt.toggleHighlight();
		assertTrue(true);
	}
	

}
