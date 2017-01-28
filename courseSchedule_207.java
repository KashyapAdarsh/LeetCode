public class Solution {
    /* Learnt and implemented from Tushor Roy's video */
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] input = new boolean[numCourses][numCourses];
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> order = new Stack<Integer>();
        
        /* This array is required to check if there is a loop in a DFS call */
        boolean[] LoopChecker = new boolean[numCourses];
        
        /* Convert input into adjacency matrix */
        for (int i = 0; i < prerequisites.length; i++)
            input[prerequisites[i][0]][prerequisites[i][1]] = true;
       
        /* We ll start for each course */
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                canSchedule(i, visited, order, input, LoopChecker);
            }
        }
        
        /* If size of stack is less than num of courses then there is a loop
         * i.e. there is some mutual dependencies
         */
        return order.size() == numCourses ? true : false;
    }
    
    public void canSchedule(int i, Set<Integer> visited, Stack<Integer> order, boolean[][] input, boolean[] LoopChecker) {
        /* add node to visited set */
        visited.add(i);
        LoopChecker[i] = true;
        
        /* Get all its adjacent courses*/
        List<Integer> temp = getAdjacent(i, input, visited);
        for (Integer adj : temp) {
             /* if its adjacent course is already visited then we have a loop*/
             if(LoopChecker[adj] == true)
                return;
             if (visited.contains(adj))
                continue;
             canSchedule(adj, visited, order, input, LoopChecker);
        }
        /* Add the course to the stack */
        LoopChecker[i] = false;
        order.push(i);
    }
    
    public List<Integer> getAdjacent(int i, boolean[][] input, Set<Integer> visited) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int index = 0; index < input[0].length; index++){
            if (input[i][index] == true) {
                temp.add(index);
            }
        }
        return temp;
    }
}