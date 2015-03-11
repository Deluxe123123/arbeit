package unitTests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import swings.Alien1;
import swings.Spaceinvaders;
import swings.Fenster;

public class FirstUnit {
	Spaceinvaders spaceInvaders;
	Fenster fenster;
	Alien1 alien1;
	
	@Before
	public void setUp() throws Exception {
		fenster = new Fenster();
		spaceInvaders = new Spaceinvaders(fenster);
		alien1 = new Alien1();
		alien1.setPosition(14, 3);
	}
	
	@Test
	public void result_should_be_false_if_figure_can_be_hitted_extreme1() {
		Point p�nktchen = new Point (100000,10000);
		assertFalse(alien1.hitable(p�nktchen));
	}
	
	@Test
	public void result_should_be_false_if_figure_can_be_hitted_extreme2() {
		Point p�nktchen = new Point (0,0);
		assertFalse(alien1.hitable(p�nktchen));
	}
	
	@Test
	public void result_should_be_false_if_figure_can_be_hitted_extreme3() {
		Point p�nktchen = new Point (1,1);
		assertFalse(alien1.hitable(p�nktchen));
	}

	@Test
	public void result_should_be_true_index_equals_5() {
		Point p�nktchen = new Point (14,4);
		assertEquals((alien1.getSmallIndex(p�nktchen)),5);
	}
	
	@Test
	public void result_should_be_false_index_equals_5() {
		Point p�nktchen = new Point (14,4);
		assertNotEquals((alien1.getSmallIndex(p�nktchen)),6);
	}
	

	@Test
	public void result_should_be_false_if_figure_can_be_hitted1() {
		Point p�nktchen = new Point (14,3);
		assertFalse(alien1.hitable(p�nktchen));
	
	}
	
	@Test
	public void result_should_be_true_if_figure_can_be_hitted2() {
		Point p�nktchen = new Point (15,3);
		assertTrue(alien1.hitable(p�nktchen));
	
	}
	
	@Test
	public void result_should_be_true_if_figure_can_be_hitted3() {
		Point p�nktchen = new Point (16,3);
		assertTrue(alien1.hitable(p�nktchen));
	
	}
	
	@Test
	public void result_should_be_true_if_figure_can_be_hitted4() {
		Point p�nktchen = new Point (17,3);
		assertTrue(alien1.hitable(p�nktchen));
	
	}
	
	@Test
	public void result_should_be_false_if_figure_can_be_hitted5() {
		Point p�nktchen = new Point (18,3);
		assertFalse(alien1.hitable(p�nktchen));
	
	}
	
	@Test
	public void result_should_be_true_if_figure_can_be_hitted6() {
		Point p�nktchen = new Point (14,4);
		assertTrue(alien1.hitable(p�nktchen));
	
	}
	@Test
	public void result_should_be_true_if_figure_can_be_hitted7() {
		Point p�nktchen = new Point (15,4);
		assertTrue(alien1.hitable(p�nktchen));
	
	}
	@Test
	public void result_should_be_true_if_figure_can_be_hitted8() {
		Point p�nktchen = new Point (16,4);
		assertTrue(alien1.hitable(p�nktchen));
	
	}
	@Test
	public void result_should_be_true_if_figure_can_be_hitted9() {
		Point p�nktchen = new Point (17,4);
		assertTrue(alien1.hitable(p�nktchen));
	
	}
	@Test
	public void result_should_be_true_if_figure_can_be_hitted10() {
		Point p�nktchen = new Point (18,4);
		assertTrue(alien1.hitable(p�nktchen));
	
	}	
	
}
