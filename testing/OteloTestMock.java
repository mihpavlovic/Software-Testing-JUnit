package testing;


import org.junit.*;

import othello.JSpot;
import othello.JSpotBoard;
import othello.OthelloWidget;
import othello.Spot;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.easymock.EasyMock;


public class OteloTestMock {
	private static OthelloWidget widget = new OthelloWidget();
	
	@Test
	public void test1Mock() {
		Spot test = EasyMock.createMock(JSpot.class);
		EasyMock.expect(test.getCoordString()).andReturn("(4, 4)");
		EasyMock.replay(test);
		assertEquals("(4, 4)", widget.getSpotBoard().getSpotAt(4, 4).getCoordString());
	}
	
	@Test
	public void test2Mock() {
		Spot test = EasyMock.createMock(JSpot.class);
		EasyMock.expect(test.isEmpty()).andReturn(true);
		EasyMock.replay(test);	
		assertEquals(false, widget.getSpotBoard().getSpotAt(4, 4).isEmpty());
	}
	
	@Test 
	public void test3Mock() {
		JSpotBoard test = EasyMock.createMock(JSpotBoard.class);
		EasyMock.expect(test.getSpotWidth()).andReturn(8);
		EasyMock.replay(test);
		assertEquals(8, widget.getSpotBoard().getSpotWidth());
	}
	
	@Test 
	public void test4Mock() {
		JSpotBoard test = EasyMock.createMock(JSpotBoard.class);
		EasyMock.expect(test.getSpotHeight()).andReturn(8);
		EasyMock.replay(test);
		assertEquals(8, widget.getSpotBoard().getSpotHeight());
	}
}
