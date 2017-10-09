package almeida.fernando.frapp.filereader.enums;

public enum ReaderType {

	CSV("csv"), PDF("pdf"), TXT("txt");

	private String type;

	private ReaderType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}
