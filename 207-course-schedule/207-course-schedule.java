// Topological sort using Adjacency List implementation

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new List[numCourses];
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++){
            list[i] = new ArrayList();
        }
        
        // make the graph, define all the neighbours in list
        for (int i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            list[pre].add(ready);
            inDegree[ready]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        
        // remove prerequisites/edges and update count
        while (!queue.isEmpty()){
            int course = queue.poll();
            count++; 
            for (int i = 0; i < numCourses; i++){
                if (list[course].contains(i)){
                    if (--inDegree[i] == 0){
                        queue.offer(i);
                    }
 //                   list[course].remove(i);
                }
            }
        }
        return count == numCourses;
    }
}