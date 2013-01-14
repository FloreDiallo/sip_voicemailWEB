package se.ltu.M7017E.lab3;

public class FilesSetting {

	private String mainFolder;
	private String saveFolder;

	public FilesSetting() {
		mainFolder = new String("/tmp/sip_voicemail/");
		saveFolder = new String("/home/");
	}

	public void setSaveFolder(String new_saveFolder) {
		this.saveFolder = new_saveFolder;
	}

	public String getSaveFolder() {
		return this.saveFolder;
	}

	public String getMainFolder() {
		return this.mainFolder;
	}
}
