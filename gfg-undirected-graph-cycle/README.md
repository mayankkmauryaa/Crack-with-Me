<h2><a href="https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1">GFG - Undirected Graph Cycle</a></h2>
<h3>Medium</h3>
<hr>

<p>Given an undirected graph with <strong>V</strong> vertices and <strong>E</strong> edges, represented by a 2D list <strong>edges[][]</strong> where each element <code>[u, v]</code> denotes an edge between vertex <em>u</em> and vertex <em>v</em>, determine whether the graph contains a cycle.

` Note:` The graph may consist of multiple disconnected components.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="Graph with a cycle" src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/891735/Web/Other/blobid1_1743510240.jpg" style="width: 483px; height: 342px;" />
<pre>
<strong>Input:</strong> V = 4, E = 4
edges = [[0, 1], [0, 2], [1, 2], [2, 3]]

<strong>Output:</strong> true

<strong>Explanation:</strong>
1 → 2 → 0 → 1 forms a cycle.

</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="Graph without a cycle" src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/891735/Web/Other/blobid2_1743510254.jpg" style="width: 483px; height: 342px;" />
<pre>
<strong>Input:</strong> V = 4, E = 3
edges = [[0, 1], [1, 2], [2, 3]]

<strong>Output:</strong> false

<strong>Explanation:</strong>
No cycle exists in the graph.

</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>
<ul>
    <li><code>1 ≤ V, E ≤ 10^5</code></li>
    <li><code>0 ≤ edges[i][0], edges[i][1] &lt; V</code></li>
</ul>
