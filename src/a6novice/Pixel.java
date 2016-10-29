package a6novice;

public interface Pixel {
	/*Pixel interface defines the public methods
	 * available to pixels; pixels can retrieve
	 * their red, blue, green and intensity values,
	 * blend with other pixels, lighten, darken,
	 * and check whether they are equal to other pixels
	 */
	public double getRed();
	public double getBlue();
	public double getGreen();
	public double getIntensity();
	public char getChar();
	
	public Pixel blend(Pixel p, double weight);
	public Pixel lighten(double factor);
	public Pixel darken(double factor);
	
	public boolean equals(Pixel p);
}
