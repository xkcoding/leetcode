package com.xkcoding.leetcode.code785;

/**
 * <p>
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * <p>
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * <p>
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * <p>
 * <p>
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 * <p>
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 * <p>
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-07-16 12:39
 */
class Solution2 {
    boolean A = true;
    boolean B = false;
    Boolean[] nodes;

    /**
     * DFS 深度优先
     */
    public boolean isBipartite(int[][] graph) {
        int range = graph.length;

        nodes = new Boolean[graph.length];
        for (int i = 0; i < range; i++) {
            if (nodes[i] == null) {
                if (!dfs(i, A, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node, boolean type, int[][] graph) {
        nodes[node] = type;

        for (int neighbor : graph[node]) {
            if (nodes[neighbor] == null) {
                if (!dfs(neighbor, nodes[node] == A ? B : A, graph)) {
                    return false;
                }
            } else if (nodes[node].equals(nodes[neighbor])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isBipartite(test));
    }
}