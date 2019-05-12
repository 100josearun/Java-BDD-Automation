package Managers;

import Dataproperties.ConfigReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderObject = new FileReaderManager();
	private static ConfigReader configReaderObject;
	
	private FileReaderManager(){
	}
	
	public static FileReaderManager getInstance() {
		return fileReaderObject;
	}
	
	public ConfigReader getConfigReader() {
		return (configReaderObject==null)?new ConfigReader():configReaderObject;
	}
	
	

}
