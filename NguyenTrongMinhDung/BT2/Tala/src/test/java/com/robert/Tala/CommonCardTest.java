package com.robert.Tala;

import static org.junit.Assert.*;

import org.junit.*;

import com.robert.Tala.CommonCard.Suit;

public class CommonCardTest {
	CommonCard card1, card2;
	
	@Before
	public void setUp(){
		card1 = new CommonCard(3, CommonCard.Suit.Spades, 1);
		card2 = Pack.getCardAt(5);
	}
	
	@Test
	public void testToString(){
		assertEquals("3 Bich", card1.toString());
	}
	
	/*
	@Test
	public void testInit() {
		try {
			CommonCard card = new CommonCard("2 Bich");
			assertEquals(2, card.getCardNumber());
			assertEquals(Suit.spades, card.getSuit());
			
			card = new CommonCard("A Bich");
			assertEquals(14, card.getCardNumber());
			assertEquals(Suit.spades, card.getSuit());
			
			card = new CommonCard("A Co");
			assertEquals(14, card.getCardNumber());
			assertEquals(Suit.hearts, card.getSuit());
		}
		catch(Exception e) {}
	}
	*/
	
	@Test
	public void testCardEquivalentFalse() {
		assertFalse(card1.equals(Pack.getCurrentPack()));
		
		assertFalse(card1.equals(card2));
	}
	
	@Test
	public void testCardEquivalentTrue() {
		card2 = Pack.getCardAt(4);
		
		assertTrue(card1.equals(card1));
		assertTrue(card1.equals(card2));
	}
	
	@Test
	public void testCardClone() {
		CommonCard card3 = card1.clone();
		
		assertTrue(card1.equals(card3));
	}
}
