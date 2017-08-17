import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class FindTweetBot{

    //if something goes wrong, we might see a TwitterException
    public static void main(String... args) throws TwitterException{

        //access the twitter API using your twitter4j.properties file
        Twitter twitter = TwitterFactory.getSingleton();

        //create a new search
        Query query = new Query("\"your welcome\"");

        //get the results from that search
        QueryResult result = twitter.search(query);

        //iterate over every search result
        for(Status tweet : result.getTweets()){
            //print out the tweet
            System.out.println(tweet.getUser().getScreenName() + ":" + tweet.getText());
        }
    }
}
