class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n*n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int ct = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size>0) {
                int id = q.poll();

                if (id==n*n) {
                    return ct;
                }

                for (int i=id+1; i<=Math.min(id+6, n*n); i++) {
                    int[] ps = transformIdToPosition(i, n);
                    int val = board[ps[0]][ps[1]];
                    int nextId = i;

                    if (val != -1) {
                        nextId = val;
                    }

                    if(visited[nextId]) {
                        continue;
                    }
                    
                    q.offer(nextId);
                    visited[nextId] = true;
                }
                size--;
            }
            ct++;
        }

        return -1;
    }

    private int[] transformIdToPosition(int id, int n) {
        int r = (id-1)/n;
        int c = (id-1)%n;
        if (r%2==1) {
            c = n-1-c;
        }
        return new int[]{n-1-r,c};
    }

    private int transformPositionToId(int[] pos, int n) {
        int r = pos[0];
        int c = pos[1];
        if (r%2==1) {
            c = n-1-c;
        }
        return (n-1-r)*n+c+1;
    }
}
