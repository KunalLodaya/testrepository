package a6test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

	private static final Coordinate COORDINATE1 = new Coordinate(3,3);
	private static final Coordinate COORDINATE2 = new Coordinate(5,5);
	private static final Coordinate ORIGIN = new Coordinate(0,0);
	private static final Pixel REDPIXEL = new ColorPixel(1,0,0);
	private static final Pixel GREENPIXEL = new ColorPixel(0,1,0);
	private static final Pixel BLUEPIXEL = new ColorPixel(0,0,1);
	
	
	@Test
	public void coordinateTest(){
		//Coordinate test determines correct implementation of
		// the Coordinate class by creating a new PictureImpl,
		// setting pixels, extracting a subpicture, and getting
		// pixels using coordinates
		Picture testPicture = new PictureImpl(6,6);
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				testPicture.setPixel(new Coordinate(i, j), GREENPIXEL);
			}
		}
		for(int i=3; i < 6; i++){
			for(int j=3; j < 6; j++){
				testPicture.setPixel(new Coordinate(i, j), REDPIXEL);
			}
		}
		SubPicture subpic = testPicture.extract(COORDINATE1, COORDINATE2);
		
		assertEquals("Coordinates not implemented correctly", GREENPIXEL, testPicture.getPixel(ORIGIN));
		assertEquals("Subpicture extraction not implemented correctly", REDPIXEL, subpic.getPixel(ORIGIN));
		
		
	}
	
	@Test
	public void iteratorTest(){
		//iteratorTest determines correct implementation of
		// the row major order iterator by creating a new picture,
		// setting specific pixels, and iterating through them
		Picture testPicture = new PictureImpl(6,6);
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 3; j++){
				testPicture.setPixel(new Coordinate(i, j), GREENPIXEL);
			}
		}
		for(int i=0; i < 6; i++){
			for(int j=3; j < 6; j++){
				testPicture.setPixel(new Coordinate(i, j), REDPIXEL);
			}
		}
		testPicture.setPixel(new Coordinate(1,0), BLUEPIXEL);
		
		Iterator<Pixel> testIterator = testPicture.iterator();
		assertEquals("hasNext() method did not return true at beginning of iteration", true, testIterator.hasNext());
		assertEquals("Iterator did not iterate correctly", GREENPIXEL, testIterator.next());
		assertEquals("Iterator did not iterate correctly", BLUEPIXEL, testIterator.next());

		
		
	}
}
