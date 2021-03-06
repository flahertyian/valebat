public class MazeTile {
	boolean isAdjacent; 
	boolean alreadyThere; 
	boolean enterence; 
	boolean exit; 
	boolean wall; 
	int visits;
	boolean hasWest; 
	boolean hasEast; 
	boolean hasNorth; 
	boolean hasSouth; 
	boolean containsPlayer;
	public MazeTile() {
		isAdjacent = false;
		alreadyThere = false;
		enterence = false;
		exit = false;
		wall = false;
		visits = 0;
		hasWest = false;
		hasEast = false;
		hasNorth = false;
		hasSouth = false;
		containsPlayer = false;
	}
	//adds the player to the board(ARRAY)
	public void addPlayer(){
		containsPlayer = true;
	}
	public void removePlayer(){
		containsPlayer = false;
	}
	//all are self-explanitory.
	public void setAdjacent() {
		isAdjacent = true;
	}

	public boolean getIsAdjacent() {
		return isAdjacent;
	}
	
	public void resetThere() {
		alreadyThere = false;
	}
	
	public void resetAdjacent() {
		isAdjacent = false;
	}

	public void setThere() {
		alreadyThere = true;
	}

	public boolean getThere() {
		return alreadyThere;
	}

	public void setStart() {
		enterence = true;
	}

	public boolean getStart() {
		return enterence;
	}

	public void setExit() {
		exit = true;
	}

	public boolean getExit() {
		return exit;
	}

	public void setWall() {
		wall = true;
	}

	public boolean getWall() {
		return wall;
	}

	public void visit() {
		visits++;
	}

	public int getVisits() {
		return visits;
	}

	public boolean[] getDirection() {
		boolean[] directions = {hasNorth, hasSouth, hasEast, hasWest};
		return directions;
	}
	public boolean getIsPlayer(){
		return containsPlayer;
	}

	public void setNorth() {
		hasNorth = true;
	}

	public void setSouth() {
		hasSouth = true;
	}

	public void setWest() {
		hasWest = true;
	}

	public void setEast() {
		hasEast = true;
	}
}