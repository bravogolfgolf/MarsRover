package rover;

public class North extends Direction {

	@Override
	Compass getDirection() {
		return Compass.N;
	}

	@Override
	Direction turnRight() {
		return new East();
	}

	@Override
	Direction turnLeft() {
		return new West();
	}

	@Override
	Point goForward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if (onTopEdgeOfGrid(y, planet)) y = wrapToBottomEdgeOfGrid(y);
		else y = moveUpOnGrid(y);
		return new Point(x, y);
	}

	private boolean onTopEdgeOfGrid(int y, Grid planet) {
		return y == planet.getHeight();
	}

	private int wrapToBottomEdgeOfGrid(int y) {
		return y = 0;
	}

	private int moveUpOnGrid(int y) {
		return y += 1;
	}
	
	@Override
	Point goBackward(Point position, Grid planet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Point goBackward(int x, int y, Grid planet) {
		if(onBottomEdgeOfGrid(y)) y = wrapToTopEdgeOfGrid(y, planet);
		else y = moveDownOnGrid(y);
		return new Point(x, y);
	}

	private boolean onBottomEdgeOfGrid(int y) {
		return y == 0;
	}

	private int wrapToTopEdgeOfGrid(int y, Grid planet) {
		return y = planet.getHeight();
	}

	private int moveDownOnGrid(int y) {
		return y -= 1;
	}
}