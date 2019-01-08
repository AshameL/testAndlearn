package dataStruction.图;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;          // 顶点的个数
    private LinkedList<Integer> adj[];// 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }

    }

    public void addEdge(int s, int t) { // 无向图一条边存储两次
        adj[s].add(t);
        adj[t].add(s);
    }

    // 搜索s到t的最短路径
    public void bfs(int s, int t) { // v:图的顶点数
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;  // 记录已经被访问过的节点。避免重复访问。
        Queue<Integer> queue = new LinkedList();
        queue.offer(s);
        int[] prev = new int[v]; // 搜索路径，但是是反向路径。
        for (int i = 0; i < v; ++i) { // 初始化路径
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    // 深度优先
    private boolean found = false;

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i)
            prev[i] = -1;
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true)
            return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for(int i=0;i<adj[w].size();++i){
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q]=w;
                recurDfs(q,t,visited,prev);
            }
        }

    }

    //__________________________
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }
}
