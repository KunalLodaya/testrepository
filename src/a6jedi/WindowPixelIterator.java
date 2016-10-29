package a6jedi;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class WindowPixelIterator implements Iterator<SubPicture> {

	//The WindowPixelIterator iterates through a series of subpictures
	// of a source picture, as if a "window" were being slid across
	// the picture, with the window starting in the
	// upper left and incrementing across each row
	
	private int windowWidth;
	private int windowHeight;
	private Picture pictureIter;
	private int nextX;
	private int nextY;
	
	public WindowPixelIterator(Picture p, int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.pictureIter = p;
		nextX = 0;
		nextY = 0;
	}

	@Override
	public boolean hasNext() {
		//hasNext checks whether the next SubPicture 
		//has an out-of-range height index
		//if so, it returns false
		if(nextY+windowHeight>pictureIter.getHeight()){
			return false;
		} else{
			return true;
		}
	}

	@Override
	public SubPicture next() {
		//next returns the next SubPicture, and updates the nextIndex
		//it checks whether it is at the end of a row, and if so,
		//moves to the beginning of the next row
		if(this.hasNext()==false){
			throw new NoSuchElementException("All pixels traversed");
		}
		SubPicture returnPicture = pictureIter.extract(nextX, nextY, windowWidth, windowHeight);
		nextX+=1;
		if(nextX+windowWidth>pictureIter.getWidth()){
			nextX=0;
			nextY+=1;
		}
		return returnPicture;
	}

}
