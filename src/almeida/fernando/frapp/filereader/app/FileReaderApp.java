package almeida.fernando.frapp.filereader.app;

import java.util.ArrayList;
import java.util.List;

import almeida.fernando.frapp.filereader.enums.ReaderType;
import almeida.fernando.frapp.filereader.filter.FilterOperation;
import almeida.fernando.frapp.filereader.model.City;
import almeida.fernando.frapp.filereader.reader.FileReader;
import almeida.fernando.frapp.filereader.reader.FileReaderCSV;
import almeida.fernando.frapp.filereader.reader.FileReaderPDF;
import almeida.fernando.frapp.filereader.reader.FileReaderTXT;

public class FileReaderApp {

	// CSV By Default
	private static final ReaderType type = ReaderType.CSV;

	private static List<String> columns = new ArrayList<String>();
	private static List<City> cities = new ArrayList<City>();

	public static void main(String[] args) {

		FileReader reader = null;

		switch (type) {
			case CSV:
				reader = new FileReaderCSV();
				break;
	
			case PDF:
				reader = new FileReaderPDF();
				break;
	
			case TXT:
				reader = new FileReaderTXT();
	
			default:
				System.out.println("Type not supported yet.");
				reader = null;
		}

		if (reader != null) {
			reader.read("cidades", cities, columns);
			FilterOperation.doOperations(columns, cities);
		}
		
		System.out.println("BYE!");

	}

}
