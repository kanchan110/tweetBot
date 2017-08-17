import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class ReplyTweetBot{

    //if something goes wrong, we might see a TwitterException
    public static void main(String... args) throws TwitterException{

        //access the twitter API using your twitter4j.properties file
        Twitter twitter = TwitterFactory.getSingleton();

        //create a new search
        Query query = new Query("\"your welcome\"");

        //get the results from that search
        QueryResult result = twitter.search(query);

        //get the first tweet from those results
        Status tweetResult = result.getTweets().get(0);

        //reply to that tweet
        StatusUpdate statusUpdate = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() +" I believe you meant \"you're\" here?");
        statusUpdate.inReplyToStatusId(tweetResult.getId());
        Status status = twitter.updateStatus(statusUpdate); 

        System.out.println("Done.");
    }
}
