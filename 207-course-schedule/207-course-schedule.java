// Topological sort using Adjacency Matrix

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0){
                inDegree[ready]++;
                matrix[pre][ready] = 1;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        
        while (!queue.isEmpty()){
            int current = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++){
                if (matrix[current][i] == 1){
                    if (--inDegree[i] == 0){
                        queue.offer(i);
                    }
//                    matrix[current][i] = 0;
                }
            }
//            for (int j = 0; j < inDegree.length; j++){
//                if (inDegree[j] == 0){
//                    queue.offer(j);
//                }
//            }
        }
        return count == numCourses; 
    }
}