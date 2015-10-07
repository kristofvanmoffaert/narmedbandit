# narmedbandit
N-Armed bandits (RL)

While pursuing my Phd in Machine Learning I implemented some Java applets for educational purposes. 
I created a toolbox where students could play with different reinforcement learning algorithms. Reinforcement 
learning is a branch of machine learning where the focus lies on learning from interaction. Reinforcement learning can be 
seen as the learning process that automatically takes place in people's minds while doing a task for the first time. 
Similar to how humans behave, the reinforcement learning algorithm tries out different actions and tries to build
a knowledge base that comprises the gathered wisdom. As time progresses and more actions are tried, the algorithm
has quite a good understanding of how the task can be solved and how the dynamics in the environment influences these actions. 
In the end, the algorithm will converge to the optimal policy which can, from that point on, be exploited. 

In this applet, I implemented:
- A single state environment with X actions that the user can specify himself
- For each action, the expected reward and deviation can be specified
- Different action selection strategies ranging from random, greedy, epsilon-greedy and softmax can be tried out
- The user can also
  - Change the parameters of each of the action selection strategies
  - Inspect different graphs, e.g., the average reward, the cumulative reward, percentage optimal actions, ...

  A screenshot of the app can be found below:
  
  ->![alt text](https://raw.githubusercontent.com/kristofvanmoffaert/narmedbandit/master/narmed.png)<-
