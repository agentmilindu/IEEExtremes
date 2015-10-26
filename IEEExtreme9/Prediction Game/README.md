#Problem Statement

In a Prediction Game, two or more players attempt to predict the score of a series of upcoming sporting competitions. Each player's predictions are then evaluated based on the sum of the categories listed below. These descriptions use the following variables:

S1: Actual score earned by team 1.

S2: Actual score earned by team 2.

P1: A player's predicted score for team 1.

P2: A player's predicted score for team 2.

*Point System*

Winner: 10 points if they correctly picked the winner, i.e. the team with more points at the end of the competition.

Team 1 Score: Maximum(0, 5 - |S1 - P1|). In other words, if they pick the correct score for Team 1, they earn 5 points. If they were off by one in their prediction, they earn 4 points. If they are off by two, they earn 3 points, and so on. If they are off by 5 or more points, they earn 0 points in this category.

Team 2 Score: Maximum(0, 5 - |S2 - P2|).

Point Spread: Maximum(0, 5 - |(P1 - P2) - (S1 - S2)|). In other words, if the player predicts the correct number of points by which one team beats another, they earn 5 points. If they are off by one, they are 4 points, and so on. If they are off by 5 or more points, they earn 0 points in this category.

Some, but perhaps not all, of the competition scores have been received. Your task is to provide a list of players who might end up with the highest point total when all scores are recorded.

Notes:

Whenever we refer to a "game," we are referring to the "Prediction Game." When we refer to a competition, we mean the sporting event that teams are playing.

No competition will end in a tie. In addition, the players are not allowed to predict a tie score as a final result for a competition.

The smallest score possible in a competition is 0 points. The maximum possible score in a competition is 200 points.

A player can earn points in the Team 1 Score, Team 2 Score, and Point Spread categories, even if they do not correctly pick the winner. For example, if a player predicts a score of 24-17 (i.e. 24 points for team 1 and 17 points for team 2) and the final result is 23-30, the player would earn 4 points for the Team 1 Score category (since the difference between the prediction (24) and the true score (23) is only one, he would get 5-1=4 points). He would receive no points for the Team 2 Score category or for the Point Spread since they are both off by more than 5 points. Similarly, if a player predicted a score of 10-9 and the actual score was 9-10, the player would earn a total of 11 points as follows: 4 points for Team 1 Score (again 5-1=4 points since the difference between the predicted and the actual score is 1), 4 points for Team 2 Score (for the same reason as with scoring analysis for Team 1), and 3 points for the Point Spread (since according to the formula the point spread is |(P1 - P2) - (S1 - S2)| = |(9-10) - (10-9)|=|-1-1|=|-2|=2, and thus the score obtained for this prediction should equal 5 - Spread = 5 - 2 = 3 points).

##Input Format

The first line of input contains an integer t, 1 <= t <= 20, indicating how many test cases are in the input.

Each test case follows in the following format. First comes a line with two space separated integers, p and c, where p indicates how many players there are, and c indicates how many competitions are being played.

The following is repeated for each of the p players. The first line contains the player's name. Then follows c lines with two space separated integers. These are the predictions for this player. The first of these prediction lines contains P1 and P2 for the first competition. The second contains the predicted scores for the second competition, and so on.

Finally there are c lines indicating the (possibly) partial results for the competition. The first competition's result is reported on the first of these lines, the second competition's on the second of these lines, and so on. Each of these lines will contain two space separated values. If the score for the team is known, the values will be integers giving the score. If the result of the competition has not yet reported, the line will read ? ?.

Notes:

Each player's name is unique. All of the names are comprised of an initial uppercase letter, followed by up to 30 lowercase letters.

2 <= p <= 20

1 <= c <= 1000

Either both scores will be given or neither will be given. You will never be given a competition result where only one of the scores has not yet been reported.

##Output Format

For each of the test cases, you should output a line containing, in alphabetical order, a space-separated list of the players who could earn the maximum number of points. If there is only one winner possible, then only the winner's name should be reported on a line of its own.

##Sample Input
```
3
2 3
Alice
14 17
20 7
30 7
Bob
20 7
21 17
14 13
14 17
17 13
? ?
2 3
Dave
14 17
20 17
30 7
Chuck
20 10
27 17
30 7
? ?
27 17
30 7
3 1
Francis
14 7
Eve
10 21
George
7 30
0 1
```
##Sample Output
```
Alice
Chuck Dave
Eve George
```

##Explanation

There are three test cases.

Test Case 1

In the first competition, Alice predicted a score of 14-17, which was also the actual score. She earned 25 points for this prediction (10 points for the winner and 5 points in each of the other categories).

In the second competition, Alice predicted a score of 20-7, and the actual score was 17-13. She earned 12 points for this prediction, 10 points for the correct winner and 2 points for the score prediction for team 1 [ 5 - |20 - 17| = 2 ].

In the first competition, Bob predicted a score of 20-7, and the actual score was 14-17. He earned 0 points for this competition, because he was wrong about the winner, and he was off by more than 5 on both team scores and on the point spread.

In the second competition, Bob predicted a score of 21-17, and the actual score was 17-13. He earns 17 points for this prediction (10 points for picking the winner, 1 point for team 1 score, 1 point for team 2 score, and 5 points for correctly predicting the spread).

With these known results, Alice is leading Bob, 37 points to 17 points. Since both Alice and Bob picked the same winner for the third competition, there is no way for Bob to catch up. Therefore you would output just "Alice" for this test case.

Test Case 2

In this test case, Dave currently has 40 points: 15 points from the second competition (10 points for picking the winner and 5 points for picking team 2's score), and 25 points for picking the correct score for the third competition. Chuck has 50 points for picking the correct scores in the second and third competitions.

Suppose the result of the first competition was 10-17. Then, Dave would end with 57 points and Chuck would end with 50 points.

On the other hand, suppose the result was 30-0. Then Chuck would end with 60 points and Dave would end with 40.

Therefore, since either Chuck or Dave could end with the highest number of points in the game, you would output "Chuck Dave" (since "Chuck" comes before "Dave" in alphabetical order).

Test Case 3

Here all of the results are in, and Eve and George have the high score of 10 points each.

Inspirational Quote

Here's a quote to reward you for reading the entire problem, and inspire you to solve it!

"It's tough to make predictions, especially about the future." - Yogi Berra