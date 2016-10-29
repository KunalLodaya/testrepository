package a6adept;

public interface SubPicture extends Picture{
	/*SubPicture interface defines the public methods
	 * available to SubPictures; in addition to all of
	 * the methods available to pictures, sub pictures
	 * can retrieve their x and y offset values, as well
	 * as the source picture they are formed from
	 */
	Picture getSource();
	int getXOffset();
	int getYOffset();
}
