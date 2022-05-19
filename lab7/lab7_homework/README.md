I implemented the dictionary using a HashSet. I generated the words using aspell.

I implemented the scoring and the winners at the end of the game (or time) descending by score.

I used wait-notify approach to make sure that players wait their turn.

I implemented a timekeeper thread that runs concurrently with the player threads. his thread will display the running time of the game and it will stop the game if it exceeds a certain time limit.
