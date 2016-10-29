package a6novice;

import java.util.Iterator;

public interface Picture extends Iterable<Pixel>{
	/*Picture interface defines the public methods
	 * available to pictures; pictures can retrieve
	 * their height and width, set individual pixels,
	 * retrieve individual pixels, determine the number
	 * of pixels in a given intensity range, and print
	 * the characters which make them up
	 */
	int getWidth();
	int getHeight();
	void setPixel(int x, int y, Pixel p);
	Pixel getPixel(int x, int y);
	int countRange(double low, double high);
	void print();
	SubPicture extract(int xOffset, int yOffset, int width, int height);
	public void setPixel(Coordinate c, Pixel p);
	public Pixel getPixel(Coordinate c);
	public SubPicture extract(Coordinate cornerA, Coordinate cornerB);
	public Iterator<Pixel> iterator();
}
