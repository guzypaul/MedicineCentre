package by.guzypaul.medicinecentre.dao.reader;

/**
 * The type Data base properties reader exception.
 */
public class DataBasePropertiesReaderException extends Exception{
    /**
     * Instantiates a new Data base properties reader exception.
     */
    public DataBasePropertiesReaderException() {
    }

    /**
     * Instantiates a new Data base properties reader exception.
     *
     * @param message the message
     */
    public DataBasePropertiesReaderException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Data base properties reader exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DataBasePropertiesReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Data base properties reader exception.
     *
     * @param cause the cause
     */
    public DataBasePropertiesReaderException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Data base properties reader exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public DataBasePropertiesReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
