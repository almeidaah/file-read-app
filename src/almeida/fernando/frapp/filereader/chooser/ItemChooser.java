package almeida.fernando.frapp.filereader.chooser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import almeida.fernando.frapp.filereader.enums.UserOption;

public class ItemChooser {

	private static Scanner scanner;
	private static Scanner strScanner;

	{
		scanner = new Scanner(System.in);
		strScanner = new Scanner(System.in);
	}

	/**
	 * Show initial options for user
	 * 
	 * @param scanner
	 * @return
	 */
	public UserOption chooseOption() {

		Integer choice;

		System.out.println("========Choose an option========");
		System.out.println("1 - Count");
		System.out.println("2 - Distinct[column]");
		System.out.println("3 - Filter[column][value]");

		try {

			scanner = new Scanner(System.in);
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				return UserOption.CHOOSE_COUNT;
			case 2:
				return UserOption.CHOOSE_COUNT_DISTINCT;
			case 3:
				return UserOption.CHOOSE_FILTER;
			default:
				return UserOption.NONE;
			}
			
		} catch (InputMismatchException e) {
			System.out.println("========Insira um número válido!========");
		}

		return chooseOption();

	}

	/**
	 * Choose a column to be filtered
	 * 
	 * @param scanner
	 * @param columns
	 * @return
	 */
	public String chooseColumn(List<String> columns) {

		System.out.println("===Choose a column===");

		IntStream.range(0, columns.size()).forEach(index -> {
			System.out.println(index + " - " + columns.get(index));
		});

		try {
			scanner = new Scanner(System.in);

			Integer choice = scanner.nextInt();
			return columns.get(choice);
			
		} catch (InputMismatchException e) {
			System.out.println("========Insira um número válido!========");
		}

		return chooseColumn(columns);

	}

	/**
	 * Choose a value to be filtered with column property
	 * 
	 * @param scanner
	 * @return
	 */
	public String chooseValue() {
		System.out.println("===Enter a value===");
		return strScanner.nextLine();
	}

}
