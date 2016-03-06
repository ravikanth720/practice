package algorithms;

public class Mooshak {
	
	public int movesToCheese(int[][] maze){
		int n = maze.length;
		int m = maze.length>0?maze[0].length:0;
		System.out.println(n+"  =  "+m );
		
		traverse(maze, 0, 0);
		
		return 0;
	}
	
	public int traverse(int[][] maze, int i, int j){
		if(maze[i][j] == 9){
			return 1;
		}else if(maze[i+1][j] != 0){
			traverse(maze, i+1, j);
		}else if(maze[i][j+1] != 0){
			traverse(maze, i+1, j);
		}else if(maze[i][j] != 0){
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
				
	}
}
