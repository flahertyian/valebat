public class MazeGenerator {
	public int width;
	public int height;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private MazeTile[][] board;

	public MazeGenerator(int width, int height, int startX, int startY, int endX, int endY) {
		//initializes the board.
		this.width = width;
		this.height = height;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		board = new MazeTile[width + 2][height + 2];
		initialize();

	}
	public void initialize() {
		for (int i = 0; i < width; i++) {
			for (int x = 0; x < height; x++) {
//				System.out.println(i +  "|" + x);
				board[i][x] = new MazeTile();
			}
		}
		int backs = 0;
		int track = 0;
		int x = startX;
		int y = startY;
		int spaces = 0;
		//System.out.println(board.size());
		board[startX][startY].setStart();
		board[endX][endY].setExit();
		boolean works = false;
		boolean alternate = false;
		//Creates the board
		while (!works) {
			boolean one = false;
			boolean two = false;
			boolean three = false;
			boolean four = false;
			//If it reaches the end of the maze, go back to the start
			if (board[x][y].getExit()) {
				board[x][y].setThere();
				x = startX;
				y = startY;	
			}
			//if the maze can't be finished (determined by having had to backtrack 10 * the area of the map)...
			//...it resets the maze so that it can try again
			if (backs >= height * width * 100) {
				//changes backs and spaces back to 0
				backs = 0;
				spaces = 0;
				//puts the generator back at the start
				x = startX;
				y = startY;	
		        //lets us know it happened
				track++;
				System.out.println(track);
				for (int i = 0; i < width; i++) {
					for (int o = 0; o < height; o++) {
						board[i][o].resetAdjacent();
						board[i][o].resetThere();						
					}
				}
			}
			//they check if there are unvisited adjacent spaces
			if (x > 1) {
				one = (!board[x-1][y].getIsAdjacent() && !board[x-1][y].getThere());
			}
			if (x < width - 2) {
				two = (!board[x+1][y].getIsAdjacent() && !board[x+1][y].getThere());
			}
			if (y > 1) {
				three = (!board[x][y-1].getIsAdjacent() && !board[x][y-1].getThere());
			}
			if (y < height - 2) {
				four = (!board[x][y+1].getIsAdjacent() && !board[x][y+1].getThere());
			}
			//if there is at least 1 available adjacent space
			if ((one || two || three || four) && !board[x][y].getExit()) {
				int tempX = x;
				int tempY = y;
				int maybeX = 0;
				int maybeY = 0;
				//Test where the next space should be
				while (maybeX == 0 && maybeY == 0) {
					boolean exited = false;
					//makes it so if the adjacent space is the end, it goes there 
					if(x > 1) {
						if(board[x-1][y].getExit() && !board[x-1][y].getThere()) {
							maybeX = -1;
							exited = true;
						}
					} if(x < width - 2) {
						if(board[x+1][y].getExit() && !board[x+1][y].getThere()) {
							exited = true;
							maybeX = 1;
						}
					} if(y > 1) {
						if(board[x][y-1].getExit() && !board[x][y-1].getThere()) {
							exited = true;
							maybeY = -1;
						}
					} if(y < height - 2) {
						if(board[x][y+1].getExit() && !board[x][y+1].getThere()) {
							exited = true;
							maybeY = 1;
						}
					}
					//chooses whether next space will be East, West or neither and checks its availability
					if (!exited) {
						//zero is there to make a change in y as likely as one in x 
						boolean zero = ((int)(Math.random() * 4 - 2) == 0);
						//if x will change
						if (!zero) {
							//as long as there isn't a value for the change in x
							while (maybeX == 0) {
								//x will be -1, 0, or 1
								maybeX = (int)(Math.random() * 4 - 2);
								//if the value for x doesn't work...
								if ((maybeX == -1 && x < 2) || (maybeX == 1 && x > width - 3)) {
									//maybeX resets
									maybeX = 0;
								}
							}
						//if y will change
						} else {
							//as long as there isn't a value for the change in y
							while (maybeY == 0) {
								//y will be -1, 0, or 1
								maybeY = (int)(Math.random() * 4 - 2);
								//if the value for y doesn't work...
								if ((maybeY == -1 && y < 2) || (maybeY == 1 && y > height - 3)) {
									//maybeY resets
									maybeY = 0;
								}
							}
						}
						//if the new point is going to be a wall or has already been established as a path...
						if (board[x + maybeX][y + maybeY].getIsAdjacent() || board[x + maybeX][y + maybeY].getThere()) {
							//maybeX and maybeY reset
							maybeX = 0;
							maybeY = 0;
						}
					}
				}
				//spaces is there to make sure the maze is long enough
				spaces++;
				//guarantees a workable maze
				x += maybeX;
				y += maybeY;
				//once the new point is selected...
				//sets the tile as a visited one
				board[tempX][tempY].setThere();
				if (tempX != 0) {
					//sets the adjacent ones as adjacent
					board[tempX - 1][tempY].setAdjacent();
					//and sets directional data
					board[tempX - 1][tempY].setWest();
				}
				if (tempX != width - 1) {
					//sets the adjacent ones as adjacent
					board[tempX + 1][tempY].setAdjacent();
					//and sets directional data
					board[tempX + 1][tempY].setEast();
				}
				if (tempY != 0) {
					//sets the adjacent ones as adjacent
					board[tempX][tempY - 1].setAdjacent();
					//and sets directional data
					board[tempX][tempY - 1].setNorth();
				}
				if (tempY != height - 1) {
					//sets the adjacent ones as adjacent
					board[tempX][tempY + 1].setAdjacent();
					//and sets directional data
					board[tempX][tempY + 1].setSouth();
				}
				alternate = true;
			//if there aren't any available adjacent spaces...
			} else if (!alternate){
				//marks all spots as not adjacent
				for (int i = 0; i < width; i++) {
					for (int o = 0; o < height; o++) {
						board[i][o].resetAdjacent();
					}
				}
				//re-marks all the adjacent spots as adjacent except the ones only adjacent to the current space.
				for (int i = 0; i < width; i++) {
					for (int o = 0; o < height; o++) {
						if (board[i][o].getThere() && !(i ==x && o==y)) {
							if (i != 0) {
								board[i - 1][o].setAdjacent();
							}
							if (o != 0) {
								board[i][o - 1].setAdjacent();
							}
							if (i != width - 1) {
								board[i + 1][o].setAdjacent();
							}
							if (o != height - 1) {
								board[i][o + 1].setAdjacent();
							}
						}
					}
				}
				alternate = true;
			} else {
				//backs is used to determine how many times it has backtracked
				backs++;
				//boolean hasMoved tells if they have backtracked
				boolean hasMoved = false;
				while (!hasMoved) {
					int direct = (int) (Math.random() * 4);
					if (direct == 0) {
						if (x > 1) {
							//if you can move west, do so
							if (board[x-1][y].getThere() && !hasMoved) {
								board[x][y].setThere();
								x -= 1;
								hasMoved = true;
							}
						}
					}
					if (direct == 1) {
						if (y < height - 2) {
							//if you can move north and haven't moved, do so
							if (board[x][y+1].getThere() && !hasMoved) {
								board[x][y].setThere();
								y += 1;
								hasMoved = true;
							}
						}
					}
					if (direct == 2) {
						if (x < width - 2) {
							//if you can move East and haven't moved, do so
							if (board[x+1][y].getThere() && !hasMoved) {
								board[x][y].setThere();
								x += 1;
								hasMoved = true;
							}
						}
					}
					if (direct == 3) {
						if (y > 1) {
							//if you can move south and haven't moved, do so
							if (board[x][y-1].getThere() && !hasMoved) {
								board[x][y].setThere();
								y -= 1;
								hasMoved = true;
							}
						}
					}
				}
				alternate = false;
			}
			//tests if the maze reaches from the start to the end & is long enough
			works = test(spaces);
			//set's the cardinal directions for the adjacent tiles
			for (int i = 0; i < height; i++) {
				for (int o = 0; o < width; o++) {
					if (i > 0) {
						if (board[i - 1][o].getThere()) {
							board[i - 1][o].setWest();
						}
					}
					if (i < height - 1) {
						if (board[i + 1][o].getThere()) {
							board[i + 1][o].setEast();
						}
					}
					if (o > 0) {
						if (board[i][o- 1].getThere()) {
							board[i][o - 1].setNorth();
						}
					}
					if (o < width - 1) {
						if (board[i][o + 1].getThere()) {
							board[i][o + 1].setWest();
						}
					}
				}
			}
		}
		System.out.println("Maze is done!");
		printBoard();
	}
//-------------------PRINTS OUT BOARD--------------------------------------
		public void printBoard(){
			int space = 0;
			//for (int u = 0; u <= height; u++) {
				//System.out.print("##");
			//}
			//System.out.println("#");
			for (int c = 0; c < width; c++) {
				//System.out.print("# ");
				for (int u = 0; u < height; u++) {
					if (board[c][u].getThere()) {
						// if (board[c][u].getStart()) {
						// 	System.out.print("S ");
						// } else if (board[c][u].getExit()) {
						// 	System.out.print("E ");
						// } else {
						// 	System.out.print("  ");
						// }
						space++;
					} else{
						//System.out.print("# ");
						//--------------------------NECESSARY-------------------------------------
						board[c][u].setWall();					
						//------------------------------------------------------------------------
					} 
				}
//				System.out.println("#");
			}
//			for (int u = 0; u <= height; u++) {
//				System.out.print("##");
//			}
//		System.out.println("#");
//		System.out.println();
//		System.out.println(space);
//------------------------------------------------------------------------
		}
	
	
	//tests if the maze works
	public boolean test(int spaces) {
//-------------------PRINTS OUT BOARD--------------------------------------
//		for (int c = 0; c < width; c++) {
//			for (int u = 0; u < height; u++) {
//				if (board[c][u].getThere()) {
//					System.out.print("O ");
//				} else if (board[c][u].getIsAdjacent()){
//					System.out.print("W ");
//				} else {
//					System.out.print("X ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println();
//------------------------------------------------------------------------
		boolean works = (board[endX][endY].getThere() && spaces > ((height * width) / 2));
		return works;
	}
	
	//returns the board
		//for when this becomes an object
	public MazeTile[][] getBoard() {
		return board;
	}
}
