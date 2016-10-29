package a6jedi;

import java.util.Iterator;

public class ZigZagPixelIterator implements Iterator<Pixel> {

	//ZigZagPixelIterator iterates through the pixels in a picture
	//beginning in the top left and proceeding in a "zigzag" fashion
	
	private Picture pictureIter;
	private int nextX=0;
	private int nextY=0;
	
	
	public ZigZagPixelIterator(Picture pictureIter) {
		this.pictureIter = pictureIter;
	}

	@Override
	public boolean hasNext() {
		//hasNext checks whether the next Pixel has an out-of-range height 
		//or width index
		//if so, it returns false
		if(nextX>=pictureIter.getWidth()||
			nextY>=pictureIter.getHeight()){
			return false;
		} else{
			return true;
		}
	}

	@Override
	public Pixel next() {
		//next returns the next Pixel, and updates the nextIndex
		//it checks several different cases before updating, to account
		// for the various bounds(left, right, top, bottom) of the Picture
		Pixel returnpixel = pictureIter.getPixel(nextX, nextY);
		if(((nextX+nextY)%2)==0){//even diagonal
			if(nextX==(pictureIter.getWidth()-1)){ // right bound
				nextY++;
			}
			else if(nextY==0){ // top bound
				nextX++;
			}
			else{ //generally, even diagonals go up and right
				nextX++;
				nextY--;
			}
		} else{ //odd diagonal
			if(nextY==(pictureIter.getHeight()-1)){
				nextX++;
			}
			else if(nextX==0){ // left bound
				nextY++;
			}
			else{ //generally, odd diagonals go down and left
				nextX--;
				nextY++;
			}
		}

		return returnpixel;
		
	}

}
