package almeida.fernando.frapp.filereader.model;

public class City {

	private Integer ibge_id;
	private String uf;
	private String name;
	private Boolean capital;
	private Float lon;
	private Float lat;
	private String nameNoAccents;
	private String alternative_names;
	private String microregion;
	private String mesoregion;

	public Integer getIbge_id() {
		return ibge_id;
	}

	public void setIbge_id(Integer ibge_id) {
		this.ibge_id = ibge_id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public String getNameNoAccents() {
		return nameNoAccents;
	}

	public void setNameNoAccents(String nameNoAccents) {
		this.nameNoAccents = nameNoAccents;
	}

	public String getAlternative_names() {
		return alternative_names;
	}

	public void setAlternative_names(String alternative_names) {
		this.alternative_names = alternative_names;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}

	@Override
	public String toString() {
		return this.getIbge_id() + " - " + this.getUf() + " - " + this.getName() + " - " + this.getCapital() + " - "
				+ this.getLon() + " - " + this.getLat() + " - " + this.getNameNoAccents() + " - "
				+ this.getAlternative_names() + " - " + this.getMicroregion() + " - " + this.getMesoregion();
	}

}
