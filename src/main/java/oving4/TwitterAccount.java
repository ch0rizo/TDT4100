package oving4;

import java.util.ArrayList;

public class TwitterAccount {
    private String username;
    private TwitterAccount account;
    private ArrayList<Tweet> tweets;
    private int tweetCount = 0;
    private int reTweetCount = 0;

    public TwitterAccount(String username) {
        this.username = username;
        this.tweets = new ArrayList<>();
    }

    public String getUserName() {
        return username;
    }

    public void follow(TwitterAccount account) {
        if (this.account == account) {
            throw new IllegalArgumentException("Du kan ikke follow deg selv!");
        }
        this.account = account;
    }

    public void unfollow(TwitterAccount account) {
        if (this == account) {
            throw new IllegalArgumentException("Du kan ikke unfollowe deg selv!");
        }
        if (this.account == account) {
            this.account = null;
        }
    }

    boolean isFollowing(TwitterAccount account) {
        if (this.account == account) {
            return true;
        }
        return false;
    }

    boolean isFollowedBy(TwitterAccount account) {
        if (account.account == this) {
            return true;
        }
        return false;
    }

    public void tweet(String text) {
        Tweet tweet = new Tweet(this, text);
        this.tweetCount++;
        this.tweets.add(tweet);
    }

    public void retweet(Tweet tweet) {
        Tweet retweet = new Tweet(this, tweet);
        tweet.getOwner().reTweetCount++;
        this.tweetCount++;
        this.tweets.add(retweet);
    }

    public Tweet getTweet(int i) {
        int tweetSize = tweets.size();
        return tweets.get(tweetSize - i);
    }

    public int getTweetCount() {
        return this.tweetCount;
    }

    public int getRetweetCount() {
        return this.reTweetCount;
    }

    @Override
    public String toString() {
        return this.username;
    }

    public static void main(String[] args) {
        TwitterAccount jon = new TwitterAccount("JonathanMos");
        TwitterAccount chris = new TwitterAccount("ChrisNg");
        TwitterAccount maria = new TwitterAccount("MariaMels");

        jon.follow(chris);
        System.out.println(jon.account);
        System.out.println(jon.isFollowing(chris));

        jon.unfollow(chris);
        System.out.println(jon.isFollowing(chris));

        jon.tweet("Heihei");
        chris.retweet(jon.getTweet(1));
        System.out.println(chris.getTweetCount());

        maria.retweet(jon.getTweet(1));
        System.out.println(jon.getRetweetCount());
        

        /*
        System.out.println(account1.isFollowing(account2));
        account1.unfollow(account2);
        System.out.println(account2.isFollowing(account1));


        account1.tweet("HEi eldste");
        account1.tweet("HEi nest nyeste");
        account1.tweet("HEi nyest");
        System.out.println(account1.getTweet(2).getText());
        System.out.println(account1.getTweetCount());
         */
    }
}
