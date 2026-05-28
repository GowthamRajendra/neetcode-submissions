class Twitter {

    private HashMap<Integer, ArrayList<int[]>> tweets;
    private HashMap<Integer, HashSet<Integer>> following;
    private int timestamp;

    public Twitter() {
        timestamp = 0;
        tweets = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<int[]>());
        tweets.get(userId).add(new int[] {timestamp, tweetId});
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        follow(userId, userId); // follow yourself

        for (int id : following.get(userId))
        {
            if (!tweets.containsKey(id)) continue;

            ArrayList<int[]> currTweets = tweets.get(id);

            int i = currTweets.size() - 1; // end of list has more recent tweets
            int max = 10;  // store 10 of user's tweets

            while (max > 0 && i > -1)
            {
                maxheap.offer(currTweets.get(i));
                i--;
                max--;
            }
        }

        ArrayList<Integer> feed = new ArrayList<>();

        while (!maxheap.isEmpty() && feed.size() < 10)
        {
            feed.add(maxheap.poll()[1]);
        }

        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        } 
    }
}
