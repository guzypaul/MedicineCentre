package by.guzypaul.medicinecentre.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * The type Copyright tag.
 */
public class CopyrightTag extends SimpleTagSupport {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String MESSAGE  = "@ Copyright by Guziy Paul 2022";

    /**
     * The type Navbar brand tag.
     */
    @Override
    public void doTag() {
        try {
            getJspContext().getOut().write(MESSAGE );
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
