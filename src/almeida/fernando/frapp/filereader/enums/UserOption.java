package almeida.fernando.frapp.filereader.enums;

public enum UserOption {

	NONE(0), CHOOSE_COUNT(1), CHOOSE_COUNT_DISTINCT(2), CHOOSE_FILTER(3);
	
	private Integer option;

	private UserOption(Integer option) {
		this.option = option;
	}
	
	public Integer getOption() {
		return option;
	}
	
}
