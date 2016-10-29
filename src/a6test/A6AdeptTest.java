package a6test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

	// declaring class variables for testing - coordinates and pixels
			private static final Pixel REDPIXEL = new ColorPixel(1,0,0);
			private static final Pixel GREENPIXEL = new ColorPixel(0,1,0);
			private static final Pixel BLUEPIXEL = new ColorPixel(0,0,1);
			private static final Pixel BLACKPIXEL = new ColorPixel(0,0,0);
	
	@Test
	public void sampleTest(){
		Picture testPicture = new PictureImpl(8,8);
		for(int i=0; i<8; i++){
			for(int j=0; j<2; j++){
				testPicture.setPixel(i, j, REDPIXEL);
			}
			for(int j=2; j<4; j++){
				testPicture.setPixel(i, j, GREENPIXEL);
			}
			for(int j=4; j<6; j++){
				testPicture.setPixel(i, j, BLUEPIXEL);
			}
			for(int j=6; j<8; j++){
				testPicture.setPixel(i, j, BLACKPIXEL);
			}
		}
		Iterator<Pixel> testIterator = testPicture.sample(0, 0, 2, 2);
		assertEquals(REDPIXEL, testIterator.next());
		testIterator.next();testIterator.next();testIterator.next();
		assertEquals(GREENPIXEL, testIterator.next());
		testIterator.next();testIterator.next();testIterator.next();
		assertEquals(BLUEPIXEL, testIterator.next());
		testIterator.next();testIterator.next();testIterator.next();
		assertEquals(BLACKPIXEL, testIterator.next());

	}
	
	@Test
	public void windowTest(){
		Picture testPicture = new PictureImpl(8,8);
		for(int i=0; i<8; i++){
			for(int j=0; j<2; j++){
				testPicture.setPixel(j, i, REDPIXEL);
			}
			for(int j=2; j<4; j++){
				testPicture.setPixel(j, i, GREENPIXEL);
			}
			for(int j=4; j<6; j++){
				testPicture.setPixel(j, i, BLUEPIXEL);
			}
			for(int j=6; j<8; j++){
				testPicture.setPixel(j, i, BLACKPIXEL);
			}
		}
		Iterator<SubPicture> testIterator = testPicture.window(2, 2);
		assertEquals(REDPIXEL, testIterator.next().getPixel(0, 0));
		testIterator.next();
		assertEquals(GREENPIXEL, testIterator.next().getPixel(0, 0));
		testIterator.next();
		assertEquals(BLUEPIXEL, testIterator.next().getPixel(0, 0));
		testIterator.next();
		assertEquals(BLACKPIXEL, testIterator.next().getPixel(0, 0));
		testIterator.next();

	}
	

}
