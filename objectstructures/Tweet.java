package objectstructures;

public class Tweet {
	private String text;
	private TwitterAccount account; 
	private Tweet originalTweet = null; 
	private int count = 0; 
	
	public Tweet (TwitterAccount account, String text) { //Ny tweet
		this.account = account; 
		this.text = text; 
	}
	
	public Tweet (TwitterAccount account, Tweet originalTweet) { //Retweet eller unntak om tweeten er fra egen konto 
		Tweet retweeted = originalTweet.getOriginalTweet(); 
		if (originalTweet.getOwner() == account || retweeted != null && retweeted.getOwner() == account) {
			throw new IllegalArgumentException("You can not retweet your own tweet...");
		}
		this.account = account; 
		this.originalTweet = (retweeted != null ? retweeted : originalTweet);
		this.text = this.originalTweet.getText();
		
		originalTweet.count ++ ; 
		
	}
	
	@Override
	public String toString() {
		return "" + account.getUserName() + ": " + getText() + (originalTweet == null ? "" : " - retweet of " + originalTweet.getOwner().getUserName()) + "";
	}
	
	public String getText() {
		return text;
	}
	public TwitterAccount getOwner() {
		return account; 
	}
	
	public Tweet getOriginalTweet() { //Returnerer retweet eller "null"
		return originalTweet;
	}
	
	public int getRetweetCount( ) {
		return count; 
	}
}