package a6jedi;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TilePixelIterator implements Iterator<SubPicture> {

	//The TilePixelIterator iterates through a series of subpictures
	// of a source picture, as if they were sets
	// of "tiles", with the tiles starting in the
	// upper left and incrementing across each row.
	// Partial tiles are not created
	
	
	private Picture pictureIter;
	private int tileHeight;
	private int tileWidth;
	private int nextX;
	private int nextY;
	
	
	public TilePixelIterator(Picture p, int tileWidth, int tileHeight) {
		this.pictureIter = p;
		this.tileWidth=tileWidth;
		this.tileHeight = tileHeight;
		nextX=0;
		nextY=0;
	}

	@Override
	public boolean hasNext() {
		//hasNext checks whether the next SubPicture 
		//has an out-of-range height index
		//if so, it returns false
		if(nextY+tileHeight>pictureIter.getHeight()){
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
		SubPicture returnPicture = pictureIter.extract(nextX, nextY, tileWidth, tileHeight);
		nextX+=tileWidth;
		if(nextX+tileWidth>pictureIter.getWidth()){
			nextX=0;
			nextY+=tileHeight;
		}
		return returnPicture;
	}
}
