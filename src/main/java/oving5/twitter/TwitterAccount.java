package oving5.twitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {
    private String username;
    private ArrayList<TwitterAccount> followers;
    private ArrayList<Tweet> tweets;
    private int tweetCount = 0;
    private int reTweetCount = 0;

    public TwitterAccount(String username) {
        this.username = username;
        this.tweets = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public String getUserName() {
        return username;
    }

    public int getFollowerCount() {
        return followers.size();
    }

    public void follow(TwitterAccount account) {
        if (this == account ) {
            throw new IllegalArgumentException("Du kan ikke follow deg selv!");
        }
        account.followers.add(this);
    }

    public void unfollow(TwitterAccount account) {
        if (this == account) {
            throw new IllegalArgumentException("Du kan ikke unfollowe deg selv!");
        }
        else if (!account.followers.contains(this)) {
            throw new IllegalArgumentException("Du følger ikke denne personen!");
        }
        account.followers.remove(this);
    }

    boolean isFollowing(TwitterAccount account) {
        return account.followers.contains(this);
    }

    boolean isFollowedBy(TwitterAccount account) {
        return this.followers.contains(account);
    }

    public void tweet(String text) {
        Tweet tweet = new Tweet(this, text);
        this.tweetCount++;
        this.tweets.add(tweet);
    }

    public void retweet(Tweet tweet) {
        if (this == tweet.getOwner()) {
            throw new IllegalArgumentException("Can't retweet oneself");
        }
        Tweet retweet = new Tweet(this, tweet);
        // getOwner gir den som eier tweet/eller retweet.
        // Vi må finne den som opprinnelig lagde tweeten og inkremere der og!
        // ------
        if (tweet.originalTweet == null) {
            this.tweetCount++;
            tweet.getOwner().reTweetCount++;
            this.tweets.add(retweet);
        }
        else {
            this.tweetCount++;
            tweet.originalTweet.getOwner().reTweetCount++;
            this.tweets.add(retweet);
        }
    }

    public Tweet getTweet(int i) {
        int tweetSize = tweets.size();
        return tweets.get(tweetSize - i);
    }

    public int getTweetCount() {
        return this.tweetCount;
    }

    public int getRetweetCount() {
        return reTweetCount;
    }

    public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
        if (comparator == null) {
            return this.followers;
        }
        List<TwitterAccount> sortedList = new ArrayList<>();
        sortedList.sort(comparator);
        return sortedList;
    }

    @Override
    public String toString() {
        return this.username;
    }

    public static void main(String[] args) {
        TwitterAccount jon = new TwitterAccount("JonathanMos");
        TwitterAccount chris = new TwitterAccount("ChrisNg");
        TwitterAccount maria = new TwitterAccount("MariaMels");

        ArrayList<oving5.twitter.TwitterAccount> followers = new ArrayList<>();
        followers.add(jon);
        followers.add(chris);
        
        FollowersCountComparator compareFollow = new FollowersCountComparator();

        System.out.println(followers);
        chris.follow(jon);
        // jon.follow(chris);
        System.out.println(chris.followers);
        System.out.println(jon.followers);
    }
}
