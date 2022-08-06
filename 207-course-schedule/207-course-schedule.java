// Topological sort using Adjacency Matrix

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        
        // build the graph as Adjacency Matrix
        for (int i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0){
                inDegree[ready]++;
                matrix[pre][ready] = 1;
            }
        }
        
        // add all the nodes with no incoming edges to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        
        while (!queue.isEmpty()){
            int course = queue.poll();
            count++;
            // remove all edges originating from 'course'
            for (int i = 0; i < numCourses; i++){
                if (matrix[course][i] == 1){
                    // if no incoming edges(means all prerequisites have been completed) add it to queue
                    if (--inDegree[i] == 0){
                        queue.offer(i);
                    }
//               matrix[current][i] = 0;  // this is not necessary, not included in Kahn's algorithm
                }
            }
        }
        // if count != numCourses then there is a cycle in the graph
        return count == numCourses; 
    }
}