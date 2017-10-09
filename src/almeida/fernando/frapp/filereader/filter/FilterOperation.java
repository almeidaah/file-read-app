package almeida.fernando.frapp.filereader.filter;

import java.util.List;

import almeida.fernando.frapp.filereader.chooser.ItemChooser;
import almeida.fernando.frapp.filereader.enums.UserOption;
import almeida.fernando.frapp.filereader.model.City;

public class FilterOperation {
	

	/**
	 * Handle user operations here
	 * 
	 * @param columns
	 * @param cities
	 */
	public static void doOperations(List<String> columns, List<City> cities) {

		ItemChooser chooser = new ItemChooser();

		UserOption option = null;

		while (option != UserOption.NONE) {
			

			option = chooser.chooseOption();

			switch (option) {
			case CHOOSE_COUNT:
				System.out.println("Total Size  is : " + cities.size());
				break;

			case CHOOSE_COUNT_DISTINCT:
				String column = chooser.chooseColumn(columns);
				System.out.println("Column Selected : " + column);

				Long totalDistinct = FilterUtils.filterDistinctByColumn(column, cities);
				System.out.println("Total distinct " + column + " values : " + totalDistinct);
				break;

			case CHOOSE_FILTER:
				column = chooser.chooseColumn(columns);
				String value = chooser.chooseValue();
				List<City> filteredList = FilterUtils.filterByColumnAndValue(column, value, cities);

				columns.forEach(col -> {
					System.out.print(col + " ");
				});
				
				filteredList.forEach(city -> {
					System.out.println(city + " ");
				});

			default:
				break;

			}

		}


	}

}
