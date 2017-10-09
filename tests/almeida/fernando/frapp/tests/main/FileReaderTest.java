package almeida.fernando.frapp.tests.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import almeida.fernando.frapp.filereader.filter.FilterUtils;
import almeida.fernando.frapp.filereader.model.City;
import almeida.fernando.frapp.filereader.reader.FileReader;
import almeida.fernando.frapp.filereader.reader.FileReaderCSV;

/**
 * Test class for CSV Reader
 * @author almeida
 *
 */
public class FileReaderTest {

	static List<String> columns;
	static List<City> rows;
	static FileReader reader;

	@BeforeClass
	public static void setup() {
		System.out.println("Setup Test");

		reader = new FileReaderCSV();
		columns = new ArrayList<String>();
		rows = new ArrayList<City>();
		reader.read("testfile", rows, columns);

	}

	@Test
	public void should_read_csv_file_sucessfully() {
		assertTrue(rows.size() > 0);
		assertTrue(columns.size() > 0);
	}

	@Test
	public void should_count_imported_lines() {
		assertTrue(rows.size() > 0);
	}

	/**
	 * This sholud be exactly the same length IBGE codes
	 */
	@Test
	public void should_count_distinct_ids() {
		String column = "ibge_id";
		Long totalDistinct = FilterUtils.filterDistinctByColumn(column, rows);
		assertEquals(Long.valueOf(5565), totalDistinct);
	}
	
	/**
	 * This test filter and count all the distinct states (UF)
	 */
	@Test
	public void should_count_distinct_uf() {
		String column = "uf";
		Long totalDistinct = FilterUtils.filterDistinctByColumn(column, rows);
		assertEquals(Long.valueOf(27), totalDistinct);
	}
	
	/**
	 * This test filter and count all the cities in one state
	 */
	@Test
	public void should_filter_same_uf() {
		String column = "uf";
		String value = "SC";
		List<City> filteredRows = FilterUtils.filterByColumnAndValue(column, value, rows);
		assertEquals(Long.valueOf(293), new Long(filteredRows.size()));
	}


	@AfterClass
	public static void done() {
		System.out.println("All test cases have been executed.");
	}
}
