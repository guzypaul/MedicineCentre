package by.guzypaul.medicinecentre.dao.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataBasePropertiesReader {
    private static final String URL = "C:\\Users\\skysnaker\\IdeaProjects\\MedicineCentre\\src\\main\\resources\\data_base.properties";
    private static final String URL_KEY = "url";
    private final Properties properties;

    public DataBasePropertiesReader() throws DataBasePropertiesReaderException {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(URL);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new DataBasePropertiesReaderException(e);
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String readURL() {
        return properties.getProperty(URL_KEY);
    }
}
