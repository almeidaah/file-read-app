package almeida.fernando.frapp.filereader.reader;

import java.util.List;

import almeida.fernando.frapp.filereader.model.City;

/**
 * @author almeida
 * @param filename
 *            - Name of file
 * @param cities
 *            - Map of cities(identified by IBGE id) which will be filled
 */
public interface FileReader {

	/**
	 * Read a file and put into a list
	 * 
	 * @param fileName
	 *            - name of file that will be read
	 * @param cities
	 * @param columns
	 */
	public void read(String fileName, List<City> cities, List<String> columns);

	// This functional method actually does not do anything here
	default void write() {

	}
}
