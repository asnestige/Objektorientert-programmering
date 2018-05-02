package objectstructures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TwitterAccount {
	private String username;
	private Collection <TwitterAccount> follows = new ArrayList <TwitterAccount>();
	private Collection <TwitterAccount> followers = new ArrayList <TwitterAccount>();
	private List <Tweet> tweets = new ArrayList <Tweet>();
	
	public TwitterAccount (String username) {
		this.username = username; 
	}
	
	public String toString() {
		return "Username: " + getUserName() + " - " + getTweetCount() + " tweets";
	}
	
	public String getUserName () {
		return username; 
	}
	
	public void follow(TwitterAccount account) { //denne (this) kontoen starter å følge account
		if (this == account) {
			throw new IllegalStateException("You cannot follow yourself.");
		}
		if (! follows.contains(account)) {
			follows.add(account); 
			account.followers.add(this);
		}
	}

	public void unfollow(TwitterAccount account) { //slutt å følge account
		if (follows.contains(account)) {
			follows.remove(account);
			account.followers.remove(this);
		}
	}

	public boolean isFollowing(TwitterAccount account) { //returnerer om denne kontoen følger account
		return follows.contains(account); 
	}

	public boolean isFollowedBy(TwitterAccount account) { //returnerer om account følger denne kontoen
		return followers.contains(account); 
	}

	public void tweet(String text) { //lager en ny tweet for denne kontoen
		tweets.add(new Tweet(this, text)); 
	}

	public void retweet(Tweet tweet) { //retweeter tweet fra denne kontoen
		if (tweet.getOriginalTweet() != null)
			tweets.add(new Tweet(this, tweet.getOriginalTweet())); 
		else {
			tweets.add(new Tweet(this, tweet)); 
		}
	}

	public Tweet getTweet(int i) { //returner tweet nummer i, der 1 er den nyeste, 2 den nest nyeste, … (merk rekkefølgen!)
		return tweets.get(tweets.size() - i); 
	}

	public int getTweetCount() { //returner antall tweets til kontoen
		return tweets.size();
	}

	public int getRetweetCount() { //returner antall retweets av tweets fra denne kontoen
		int count = 0;
		for (Tweet tweet : tweets) 
				count += tweet.getRetweetCount();
		return count;
	}
	
}