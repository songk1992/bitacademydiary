package practice04.prob5;

public class RectTriangle extends Shape{
	
	private double width;
	private double height;
	
	public RectTriangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (0.5 * width * height);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (width + height) + Math.pow((Math.pow(width, 2) + Math.pow(height, 2)), 0.5);
	}

}
