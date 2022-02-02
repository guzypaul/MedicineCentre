package by.guzypaul.medicinecentre.dao.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Data base properties reader.
 */
public class DataBasePropertiesReader {
    private static final String URL = "C:\\Users\\skysnaker\\IdeaProjects\\MedicineCentre\\src\\main\\resources\\data_base.properties";
    private static final String URL_KEY = "url";
    private static final String DRIVER_NAME = "driverName";
    private final Properties properties;

    /**
     * Instantiates a new Data base properties reader.
     *
     * @throws DataBasePropertiesReaderException the data base properties reader exception
     */
    public DataBasePropertiesReader() throws DataBasePropertiesReaderException {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(URL);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new DataBasePropertiesReaderException(e);
        }
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Read url string.
     *
     * @return the string
     */
    public String readURL() {
        return properties.getProperty(URL_KEY);
    }

    /**
     * Read driver name string.
     *
     * @return the string
     */
    public String readDriverName(){
        return properties.getProperty(DRIVER_NAME);
    }
}
