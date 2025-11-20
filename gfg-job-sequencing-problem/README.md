<h2><a href="https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1">GFG - Job Sequencing Problem</a></h2>
<h3>Medium</h3>
<hr>

<p>You are given two arrays <strong>deadline[]</strong> and <strong>profit[]</strong> representing a list of jobs.  
Each job takes exactly <strong>1 unit</strong> of time to complete, and only one job can be performed at any given time slot.</p>

<p>A job yields its profit only if it is completed <strong>on or before</strong> its deadline.  
Your task is to schedule the jobs such that:</p>

<ul>
    <li>The maximum number of jobs are completed within their deadlines.</li>
    <li>The total earned profit is maximized.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> deadline[] = [4, 1, 1, 1]
        profit[]   = [20, 10, 40, 30]

<strong>Output:</strong> [2, 60]

<strong>Explanation:</strong>
Job 1 and Job 3 can be completed to get a maximum profit of 60 (20 + 40).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> deadline[] = [2, 1, 2, 1, 1]
        profit[]   = [100, 19, 27, 25, 15]

<strong>Output:</strong> [2, 127]

<strong>Explanation:</strong>
Job 1 and Job 3 can be completed earning a total profit of 127 (100 + 27).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> deadline[] = [3, 1, 2, 2]
        profit[]   = [50, 10, 20, 30]

<strong>Output:</strong> [3, 100]

<strong>Explanation:</strong>
Job 1, Job 3 and Job 4 can be completed, producing a total profit of 100 (50 + 20 + 30).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>
<ul>
    <li><code>1 ≤ deadline.size() = profit.size() ≤ 10^5</code></li>
    <li><code>1 ≤ deadline[i] ≤ deadline.size()</code></li>
    <li><code>1 ≤ profit[i] ≤ 500</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>Company Tags:</strong> Flipkart, Accolite, Microsoft</p>