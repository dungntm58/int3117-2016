package com.robert.Tala;

public class CommonCard {
	public static enum Suit{spades, clubs, diamonds, hearts};
	private int cardNumber;
	private Suit suit;
	private int level;
	private boolean chose;
	
	public CommonCard(int cardNumber, Suit suit, int level){
		this.cardNumber = cardNumber;
		this.suit = suit;
		this.level = level;
	}
	
	/*
	public CommonCard(String s) throws Exception {
		String[] comp = s.split(" ");
		
		try {
			Integer number = Integer.valueOf(comp[0]);
			this.cardNumber = number;
		}
		catch (NumberFormatException e) {
			switch (comp[0]) {
			case "J":
				this.cardNumber = 11;
				break;
			case "Q":
				this.cardNumber = 12;
				break;
			case "K":
				this.cardNumber = 13;
				break;
			case "A":
				this.cardNumber = 14;
				break;
			default:
				throw new Exception("Incompatible card");
			}
		}
		
		switch (comp[1]) {
		case "Ro" :
			this.suit = Suit.diamonds;
			break;
		case "Co" :
			this.suit = Suit.hearts;
			break;
		case "Bich":
			this.suit = Suit.spades;
			break;
		case "Nhep":
			this.suit = Suit.clubs;
			break;
		default:
			throw new Exception("Incompatible card");
		}
	}
	*/
	
	public CommonCard(int cardNumber, Suit suit) {
		this.cardNumber = cardNumber;
		this.suit = suit;
	}
	
	public CommonCard clone(){
		return new CommonCard(cardNumber, suit, level);
	}
	
	public int getCardNumber() {
		return Integer.valueOf(cardNumber);
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getSuitName() {
		return suit.name();
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public int getLevel() {
		return Integer.valueOf(level);
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public boolean beChosen(){
		return chose;
	}
	
	public void notBeChosen(){
		chose = false;
	}
	
	public void setToBeChosen(boolean value){
		chose = value;
	}
	
	public String toString(){
		String nameOfCardNumber = "", nameOfSuit = null;
		
		if (cardNumber < 10)
			nameOfCardNumber += (char)(cardNumber + 48);
		else
			if (cardNumber > 10)
				switch(cardNumber){
					case 11:{
						nameOfCardNumber = "J";
						break;
					}
					case 12:{
						nameOfCardNumber = "Q";
						break;
					}
					case 13:{
						nameOfCardNumber = "K";
						break;
					}
					case 14:{
						nameOfCardNumber = "A";
						break;
					}
				}
			else
				nameOfCardNumber = "10";
		
		switch(suit){
			case spades:{
				nameOfSuit = "Bich";
				break;
			}
			case clubs:{
				nameOfSuit = "Nhep";
				break;
			}
			case diamonds:{
				nameOfSuit = "Ro";
				break;
			}
			case hearts:{
				nameOfSuit = "Co";
				break;
			}
		}
		return (level > 0) ? nameOfCardNumber + " " + nameOfSuit : "Joker";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		
		if (obj instanceof CommonCard) {
			CommonCard otherCard = (CommonCard)obj;
			
			return otherCard.cardNumber == this.cardNumber && otherCard.suit == this.suit;
		}
		else
			return false;
	}
}
