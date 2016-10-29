package a6jedi;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SamplePixelIterator implements Iterator<Pixel> {

	//SamplePixelIterator iterates through a "sample" of the pixels
	// in a picture, producing pixels at regular intervals,
	//proceeding across each row
	
	private int dx;
	private int dy;
	private Picture pictureIter;
	private int nextIndexX;
	private int nextIndexY;
	private int initX;
	
	
	public SamplePixelIterator(Picture pictureIter, int initX, int initY, int dx, int dy){
		this.pictureIter=pictureIter;
		nextIndexX=initX;
		nextIndexY=initY;
		this.dx=dx;
		this.dy=dy;
		this.initX=initX;
	}

	@Override
	public boolean hasNext() {
		//hasNext checks whether the next Pixel has an out-of-range height index
		//if so, it returns false
		if(nextIndexY>=pictureIter.getHeight()){
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
		if(pictureIter.getWidth()-dx>nextIndexX){
			nextIndexX+=dx;
		} else{
			nextIndexX=initX;
			nextIndexY+=dy;
		}
		return returnPixel;
	}

}
