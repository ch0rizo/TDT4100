package oving5.twitter;

import java.util.ArrayList;
import java.util.Comparator;

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

    @Override
    public String toString() {
        return this.username;
    }

    public static void main(String[] args) {
        TwitterAccount jon = new TwitterAccount("JonathanMos");
        TwitterAccount chris = new TwitterAccount("ChrisNg");
        TwitterAccount maria = new TwitterAccount("MariaMels");

        jon.follow(chris);
        //System.out.println(jon.account);
        //System.out.println(jon.isFollowing(chris));

        jon.unfollow(chris);
        //System.out.println(jon.isFollowing(chris));

        jon.tweet("Heihei");
        System.out.println("Jon OG tweet: " + jon.getTweet(1));
        chris.retweet(jon.getTweet(1));
        System.out.println("Chris retweet: " + chris.getTweet(1));
        maria.retweet(chris.getTweet(1));
        System.out.println("Maria retweet: " + maria.getTweet(1));

        System.out.println(jon.getTweet(1));
        System.out.println(maria.getTweet(1).getOriginalTweet());

        ArrayList<TwitterAccount> accounts = new ArrayList<>();
        accounts.add(jon);
        accounts.add(chris);
        accounts.add(maria);

        Comparator<TwitterAccount> sortByAlph = new UserNameComparator();

        System.out.println(accounts);
        accounts.sort(sortByAlph);
        



        

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
