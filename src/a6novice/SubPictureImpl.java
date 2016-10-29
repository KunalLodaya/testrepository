package a6novice;

public class SubPictureImpl extends AnyPicture implements SubPicture {
	
	private Picture source;
	private int xOffset;
	private int yOffset;
	
	
	public SubPictureImpl(Picture source, int xOffset, int yOffset, int width, int height){
		/* subpictures have a source picture from which they are created; the subpicture
		 * is defined by its own width and height, and xOffset and yOffset values
		 * which define its "origin" within the source picture
		 */
		super(width, height);
		if(xOffset>source.getWidth() ||
			yOffset>source.getHeight() ||
			(xOffset + width) > source.getWidth() ||
			(yOffset+height) > source.getHeight() ||
			(xOffset < 0)||
			(yOffset < 0))
			{
			throw new IllegalArgumentException("The parameters you passed are not legal");	
		}
		this.source = source;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	@Override
	public Picture getSource() {
		return source;
	}

	@Override
	public int getXOffset() {
		return xOffset;
	}

	@Override
	public int getYOffset() {
		return yOffset;
	}
	
	@Override
	public void setPixel(int x, int y, Pixel p) {
		//Pixel being gotten or set is within the source picture;
		// the setPixel and getPixel functions are therefore delegated
		// to the source picture
		source.setPixel(x+xOffset, y+yOffset, p);
		
	}
	@Override
	public Pixel getPixel(int x, int y) {
		return source.getPixel(x+xOffset, y+yOffset);
	}
	@Override
	public int countRange(double low, double high) {
		//countRange takes two values to create a range; 
		// it then iterates through each pixel in the SubPicture,
		// and counts how many pixels' intensities fall in the range
		// this iteration is delegated to the source
		int count = 0;
		for(int i = this.xOffset; i<this.width - this.xOffset; i++){
			for(int j = this.yOffset; j<this.height - this.yOffset; j++){
				if (source.getPixel(i, j).getIntensity()<=high &&
						source.getPixel(i, j).getIntensity()>=low){
					count++;
				}
			}
		}
		return count;
	}
	@Override
	public void print() {
		//prints out the 'picture', a series of lines with
		// a character for each pixel; the retrieval of the character
		// is again delegated to the source picture
		for(int j = this.yOffset; j<this.height - this.yOffset; j++){
			for(int i = this.xOffset; i<this.width - this.xOffset; i++){
				System.out.print(this.source.getPixel(i, j).getChar());
			}
			System.out.println();
		}
	}
	
}
