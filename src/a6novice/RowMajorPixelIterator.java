package a6novice;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RowMajorPixelIterator implements Iterator<Pixel> {
	
	//RowMajorPixelIterator iterates through the pixels in a picture
	//beginning in the top left and proceeding across each row
	
	private int nextIndexX;
	private int nextIndexY;
	private Picture pictureIter;
	
	public RowMajorPixelIterator(Picture p) {
		this.nextIndexX= 0;
		this.nextIndexY= 0;
		this.pictureIter = p;
	}

	@Override
	public boolean hasNext() {
		//hasNext checks whether the next Pixel has an out-of-range height index
		//if so, it returns false
		if(this.nextIndexY>=pictureIter.getHeight()){
			return false;
		} else{
			return true;
		}
	}

	@Override
	public Pixel next() {
		//next returns the next Pixel, and updates the nextIndex
		//it checks whether it is at the end of a row, and if so,
		//moves to the beginning of the next row
		if(this.hasNext()==false){
			throw new NoSuchElementException("All pixels traversed");
		}
		Pixel returnPixel = pictureIter.getPixel(nextIndexX, nextIndexY);
		if(pictureIter.getWidth()-1>nextIndexX){
			nextIndexX+=1;
		} else{
			nextIndexX=0;
			nextIndexY+=1;
		}
		return returnPixel;
	}
}
