package a6adept;

public class PictureImpl extends AnyPicture implements Picture {
	
	private Pixel[][] frame;
	
	public PictureImpl(int width, int height){
		// new pictures have a height, width, and 'frame',
		// a 2-D array which maps all of their individual
		// pixels; the frame takes both Gray and Color Pixels,
		// and is initialized with pixels of intensity and
		// RGB values all equal to .5
		super(width, height);
		
		
		this.frame = new Pixel[height][width];
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				this.frame[i][j] = new ColorPixel (0.5, 0.5, 0.5);
			}
		}
	}



	public void setPixel(int x, int y, Pixel p) {
		// Pixel being set must have a valid coordinate
		if(x>this.width-1
				|| y>this.height-1
				|| x<0
				|| y<0
				|| p==null){
			throw new RuntimeException("Your coordinate is out of bounds");
		}
			
		this.frame[y][x] = p;
	}

	public Pixel getPixel(int x, int y) {
		// Pixel being retrieved must have a valid coordinate
		if(x>this.width-1
				|| y>this.height-1
				|| x<0
				|| y<0){
			throw new RuntimeException("Your coordinate is out of bounds");
		}
		return this.frame[y][x];
	}

	public int countRange(double low, double high) {
		//countRange takes two values to create a range; 
		// it then iterates through each pixel in the Picture,
		// and counts how many pixels' intensities fall in the range
		int count = 0;
		if(low>high||
				low<0.0||
				low>1.0||
				high<0.0||
				high>1.0){
			throw new RuntimeException("High and/or low out of bounds");
		}
		for(int i=0; i<this.height; i++){
			for(int j=0; j<this.width; j++){
				if(this.frame[i][j].getIntensity()>=low && this.frame[i][j].getIntensity()<=high){
					count++;
				}
			}
		}
		return count;
	}

	public void print() {
		//prints out the 'picture', a series of lines with
		// a character for each pixel
		for(int i=0; i<this.height; i++){
			for(int j=0; j<this.width; j++){
				System.out.print(this.frame[i][j].getChar());
			}
			System.out.println();
		}

	}
}

