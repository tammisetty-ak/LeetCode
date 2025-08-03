class Twitter {
    private static int timeStamp = 0;

    private class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private Map<Integer, Tweet> userTweets; // user -> latest tweet
    private Map<Integer, Set<Integer>> follows; // user -> set of followees

    public Twitter() {
        userTweets = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timeStamp++);
        tweet.next = userTweets.get(userId);
        userTweets.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // add user's own tweets
        if (userTweets.containsKey(userId)) {
            maxHeap.offer(userTweets.get(userId));
        }

        // add followees' tweets
        for (int followeeId : follows.getOrDefault(userId, new HashSet<>())) {
            if (userTweets.containsKey(followeeId)) {
                maxHeap.offer(userTweets.get(followeeId));
            }
        }

        // get top 10
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            Tweet t = maxHeap.poll();
            res.add(t.id);
            if (t.next != null) maxHeap.offer(t.next);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
