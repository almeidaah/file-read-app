package almeida.fernando.frapp.filereader.filter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import almeida.fernando.frapp.filereader.model.City;

public class FilterUtils {
	
	public static Long filterDistinctByColumn(String column, List<City> cities) {

		switch (column) {
			case "ibge_id":
				return cities.stream().filter(distinctByKey(City::getIbge_id)).count();
			case "uf":
				return cities.stream().filter(distinctByKey(City::getUf)).count();
			case "name":
				return cities.stream().filter(distinctByKey(City::getName)).count();
			case "capital":
				return cities.stream().filter(distinctByKey(City::getCapital)).count();
			case "lon":
				return cities.stream().filter(distinctByKey(City::getLon)).count();
			case "lat":
				return cities.stream().filter(distinctByKey(City::getLat)).count();
			case "no_accents":
				return cities.stream().filter(distinctByKey(City::getNameNoAccents)).count();
			case "alternative_names":
				return cities.stream().filter(distinctByKey(City::getAlternative_names)).count();
			case "microregion":
				return cities.stream().filter(distinctByKey(City::getMicroregion)).count();
			case "mesoregion":
				return cities.stream().filter(distinctByKey(City::getMesoregion)).count();
		}

		return 0l;

	}
	
	public static List<City> filterByColumnAndValue(String column, String value, List<City> cities) {

		switch (column) {
			case "ibge_id":
				return cities.stream().filter(c -> c.getIbge_id().equals(Integer.valueOf(value))).collect(Collectors.toList());
			case "uf":
				return cities.stream().filter(c -> c.getUf().equals(value)).collect(Collectors.toList());
			case "name":
				return cities.stream().filter(c -> c.getName().equals(value)).collect(Collectors.toList());
			case "capital":
				return cities.stream().filter(c -> c.getCapital().equals(Boolean.valueOf(value))).collect(Collectors.toList());
			case "lon":
				return cities.stream().filter(c -> c.getLon().equals(Double.valueOf(value))).collect(Collectors.toList());
			case "lat":
				return cities.stream().filter(c -> c.getLat().equals(Double.valueOf(value))).collect(Collectors.toList());
			case "no_accents":
				return cities.stream().filter(c -> c.getNameNoAccents().equals(value)).collect(Collectors.toList());
			case "alternative_names":
				return cities.stream().filter(c -> c.getAlternative_names().equals(value)).collect(Collectors.toList());
			case "microregion":
				return cities.stream().filter(c -> c.getMicroregion().equals(value)).collect(Collectors.toList());
			case "mesoregion":
				return cities.stream().filter(c -> c.getMesoregion().equals(value)).collect(Collectors.toList());
		}
		
		return null;
	}
	
	private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
