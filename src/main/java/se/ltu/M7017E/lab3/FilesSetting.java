package se.ltu.M7017E.lab3;

/**
 * This class must be used to define where the files are stored on the server
 */
public class FilesSetting {

	private String mainFolder;

	public FilesSetting() {
		mainFolder = new String("/tmp/sip_voicemail/");
	}

	/**
	 * Get the folder where the file is stored
	 * 
	 * @return name of the folder
	 */
	public String getMainFolder() {
		return this.mainFolder;
	}
}
