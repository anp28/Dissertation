package animation;

public class Circle {
	
	private int x , y;
	private int radius = 0;
	int maxRadius;
	private int thickness;
	private short[] colour;
	private int degradeTime;
	
	/**
	 * @return the degradeTime
	 */
	public int getDegradeTime() {
		return degradeTime;
	}
	/**
	 * @param degradeTime the degradeTime to set
	 */
	public void setDegradeTime(int degradeTime) {
		this.degradeTime = degradeTime;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	/**
	 * @return the thickness
	 */
	public int getThickness() {
		return thickness;
	}
	/**
	 * @param thickness the thickness to set
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	/**
	 * @return the colour
	 */
	public short[] getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(short[] colour) {
		this.colour = colour;
	}
	public void setMaxRadius(int radius){
		this.maxRadius = radius;
	}
	public int getMaxRadius() {
		// TODO Auto-generated method stub
		return maxRadius;
	}
	
	
	

}
