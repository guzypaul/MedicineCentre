package by.guzypaul.medicinesentre.service.checker;

import by.guzypaul.medicinecentre.service.checker.FileFormatChecker;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileFormatCheckerTest {
    private FileFormatChecker formatChecker;

    @BeforeEach
    void setUp() {
        formatChecker = new FileFormatChecker();
    }

    @Test
    void checkJpgFormatTest() {
        Assert.assertTrue(formatChecker.checkImgFormat("picture.jpg"));
    }

    @Test
    void checkGifFormatTest() {
        Assert.assertTrue(formatChecker.checkImgFormat("picture.gif"));
    }

    @Test
    void checkPngFormatTest() {
        Assert.assertTrue(formatChecker.checkImgFormat("picture.png"));
    }

    @Test
    void checkBmpFormatTest() {
        Assert.assertTrue(formatChecker.checkImgFormat("picture.bmp"));
    }

    @Test
    void checkInvalidFormatTest() {
        Assert.assertFalse(formatChecker.checkImgFormat("video.mp4"));
    }
}
