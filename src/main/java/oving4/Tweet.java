package oving4;

public class Tweet {
    private TwitterAccount account;
    private String text;
    private Tweet originalTweet;
    private int reTweetCount;

    public Tweet(TwitterAccount account, String text) {
        this.originalTweet = this;
        this.account = account;
        this.text = text;
        this.reTweetCount = 0;
    }

    public Tweet(TwitterAccount account, Tweet origTweet) {
        if (account == origTweet.account) {
            throw new IllegalArgumentException("Can't retweet oneself");
        }
        this.originalTweet = origTweet;
        this.account = account;
        this.text = origTweet.text;
        this.originalTweet.reTweetCount++;
    }

    public String getText() {
        return originalTweet.text;
    }

    public TwitterAccount getOwner() {
        return account;
    }

    public Tweet getOriginalTweet() {
        if (this == originalTweet) {
            return null;
        }
        return originalTweet;
    }

    public int getRetweetCount() {
        return reTweetCount;
    }

    public static void main(String[] args) {
        TwitterAccount account1 = new TwitterAccount("Christofferhn");
        TwitterAccount account2 = new TwitterAccount("MariaMels");
        TwitterAccount account3 = new TwitterAccount("JonathanMos");
        Tweet tweet = new Tweet(account1, "Hei alle");
        Tweet reTweet1 = new Tweet(account2, tweet);
        Tweet reTweet2 = new Tweet(account3, reTweet1);

        System.out.println(tweet.getOrginalTweet());
        System.out.println(reTweet1.getOrginalTweet());
        System.out.println(reTweet2.getOwner());

    }
}
