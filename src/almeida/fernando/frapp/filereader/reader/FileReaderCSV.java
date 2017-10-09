package almeida.fernando.frapp.filereader.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

import almeida.fernando.frapp.filereader.model.City;

public class FileReaderCSV implements FileReader {

	private final String EXTENSION = ".csv";
	
	@Override
	public void read(String fileName, List<City> cities, List<String> columns) {
		try {

			List<String> lines = Files.readAllLines(Paths.get(fileName + this.EXTENSION ));

			columns.addAll(Arrays.asList(lines.get(0).split(",")));
			
			// Skip first line and starts iterating
			lines.subList(1, lines.size()).forEach(line -> {

				Object[] lineValues = line.split(",");

				City city = new City();

				city.setIbge_id(new Integer((String) lineValues[0]));

				city.setUf(String.valueOf(lineValues[1]));
				city.setName(String.valueOf(lineValues[2]));
				city.setCapital(Boolean.valueOf((String) lineValues[3]));

				city.setLon(new Float((String) lineValues[4]));
				city.setLat(new Float((String) lineValues[5]));

				String noAccentName = Normalizer.normalize(city.getName(), Normalizer.Form.NFD);

				// Unaccent unicode text
				city.setNameNoAccents(noAccentName.replaceAll("\\p{M}", ""));

				city.setAlternative_names(String.valueOf(lineValues[7]));
				city.setMicroregion(String.valueOf(lineValues[8]));
				city.setMesoregion(String.valueOf(lineValues[9]));

				cities.add(city);
			});

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
