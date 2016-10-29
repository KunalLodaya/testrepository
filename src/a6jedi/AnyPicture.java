package a6jedi;

import java.util.Iterator;


public abstract class AnyPicture implements Picture {
	protected int width;
	protected int height;
	public AnyPicture(int width, int height){
		if(width < 0 ||
				height < 0
				|| width == 0
				|| height == 0){
			throw new IllegalArgumentException("Height and weight must be greater than 0");
		}
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	abstract public void setPixel(int x, int y, Pixel p);
	@Override
	abstract public Pixel getPixel(int x, int y);

	@Override
	abstract public int countRange(double low, double high);

	@Override
	abstract public void print();
	
	@Override
	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		SubPicture newpicture = new SubPictureImpl(this, xOffset, yOffset, width, height);
		return newpicture;
	}
	
	public void setPixel(Coordinate c, Pixel p){
		setPixel(c.getX(), c.getY(), p);
	}
	
	public Pixel getPixel(Coordinate c){
		return getPixel(c.getX(), c.getY());
	}

	public SubPicture extract(Coordinate cornerA, Coordinate cornerB){
		int rightCornerX;
		int rightCornerY;
		int leftCornerX;
		int leftCornerY;
		if (cornerB.getX()>cornerA.getX()){
			rightCornerX=cornerB.getX();
			leftCornerX=cornerA.getX();
		} else{
			rightCornerX=cornerA.getX();
			leftCornerX=cornerB.getX();
		}
		if (cornerB.getY()>cornerA.getY()){
			rightCornerY=cornerB.getY();
			leftCornerY=cornerA.getY();
		} else{
			rightCornerY=cornerA.getY();
			leftCornerY=cornerB.getY();
		}
		SubPicture newpicture = new SubPictureImpl(this, leftCornerX,
				leftCornerY, rightCornerX-leftCornerX+1,
				rightCornerY-leftCornerY+1);
		return newpicture;

	}
	public Iterator<Pixel> iterator(){
		return new RowMajorPixelIterator(this);
	}

	public Iterator<Pixel> sample(int initX, int initY, int dx, int dy){
		return new SamplePixelIterator(this, initX, initY, dx, dy);
	}

	public Iterator<SubPicture> window(int windowWidth, int windowHeight){
		return new WindowPixelIterator(this, windowWidth, windowHeight);
	}
	
	public Iterator<SubPicture> tile(int tileWidth, int tileHeight){
		return new TilePixelIterator(this, tileWidth, tileHeight);
	}
	
	public Iterator<Pixel> zigzag(){
		return new ZigZagPixelIterator(this);
	}
	
}
