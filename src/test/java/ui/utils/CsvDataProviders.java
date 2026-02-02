package ui.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvDataProviders {

    @DataProvider(name = "userData", parallel = true)
    public static Iterator<Object[]> getUserData() throws IOException {
        return readCsv("src/test/resources/uiSource/users.csv");
    }

    @DataProvider(name = "issueData", parallel = true)
    public static Iterator<Object[]> getIssueData() throws IOException {
        return readCsv("src/test/resources/uiSource/issues.csv");
    }

    @DataProvider(name = "projectData", parallel = true)
    public static Iterator<Object[]> getProjectsData() throws IOException {
        return readCsv("src/test/resources/uiSource/projects.csv");
    }

    @DataProvider(name = "authData", parallel = true)
    public static Iterator<Object[]> getAuthData() throws IOException {
        return readCsv("src/test/resources/uiSource/authData.csv");
    }


    private static Iterator<Object[]> readCsv(String path) throws IOException {
        List<Object[]> data = new ArrayList<>();

        try (Reader in = new FileReader(path)) {
            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .setIgnoreHeaderCase(true)
                    .setTrim(true).get();

            Iterable<CSVRecord> records = format.parse(in);
            for (CSVRecord record : records) {
                data.add(record.toList().toArray());
            }
        }
        return data.iterator();
    }
}
