class Solution {
    
    public int findCircleNum(int[][] isConnected) {

    int v = isConnected.length;
    boolean[] vis = new boolean[v];
    int cnt = 0;

    for (int i = 0; i < v; i++) {
      if (!vis[i]) {
        cnt++;
        dfs(i, isConnected, vis);
      }
    }

    return cnt;
  }

  private void dfs(int node, int[][] adj, boolean[] vis) {

    vis[node] = true;

    for (int adjNode = 0; adjNode < adj.length; adjNode++) {

      if (adj[node][adjNode] == 1 && !vis[adjNode]) {

        dfs(adjNode, adj, vis);
      }
    }
  }
}