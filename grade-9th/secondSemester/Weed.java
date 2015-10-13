public class Weed{
	private int xcor, ycor;
	private boolean click = false;
	public Weed(int x, int y,boolean click){
		xcor = x;
		ycor = y;
		click = click;
	}
	public int getX(){
		return xcor;
	}
	public int getY(){
		return ycor;
	}
	public boolean getClick(){
		return click;
	}
}
