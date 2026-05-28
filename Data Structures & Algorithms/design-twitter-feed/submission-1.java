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
            int index = currTweets.size() - 1;
            int[] recentTweet = currTweets.get(index);

            maxheap.offer(new int[] {recentTweet[0], recentTweet[1], id, index});
        }

        ArrayList<Integer> feed = new ArrayList<>();

        while (!maxheap.isEmpty() && feed.size() < 10)
        {
            int[] recent = maxheap.poll();

            feed.add(recent[1]);

            int index = recent[3];
            int id = recent[2];

            if (index > 0) {
                int[] nextTweet = tweets.get(id).get(index - 1);

                maxheap.offer(new int[] {nextTweet[0], nextTweet[1], id, index - 1});
            }
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
