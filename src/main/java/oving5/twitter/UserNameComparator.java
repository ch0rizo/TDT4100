package oving5.twitter;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount o1, TwitterAccount o2) {
        return o1.getUserName().charAt(0) - o2.getUserName().charAt(0);
    }
}
