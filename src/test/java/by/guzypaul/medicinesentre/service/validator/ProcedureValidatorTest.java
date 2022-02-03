package by.guzypaul.medicinesentre.service.validator;

import by.guzypaul.medicinecentre.entity.Procedure;
import by.guzypaul.medicinecentre.entity.Qualification;
import by.guzypaul.medicinecentre.service.checker.FileFormatChecker;
import by.guzypaul.medicinecentre.service.validator.ProcedureValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProcedureValidatorTest {
    ProcedureValidator procedureValidator;
    Procedure testProcedure;
    private FileFormatChecker formatChecker;

    @BeforeEach
    void setUp() {
        procedureValidator = new ProcedureValidator();
        formatChecker = mock(FileFormatChecker.class);
        testProcedure = new Procedure("surgery", "default.jpg", BigDecimal.valueOf(500),
                "removing something extra ", 30, Qualification.SURGEON);
    }

    @Test
    void validateRightProcedureTest() {
        when(formatChecker.checkImgFormat("default.jpg")).thenReturn(true);
        Assert.assertTrue(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateNullProcedureTest() {
        Assert.assertFalse(procedureValidator.validateProcedure(null));
    }

    @Test
    void validateProcedureWithInvalidNameTest() {
        testProcedure.setName("F");
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithNullNameTest() {
        testProcedure.setName(null);
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithInvalidImageNameTest() {
        testProcedure.setImageName("ds");
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithNullImageNameTest() {
        testProcedure.setImageName(null);
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithInvalidPriceTest() {
        testProcedure.setPrice(BigDecimal.valueOf(-2));
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithNullPriceTest() {
        testProcedure.setPrice(null);
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithInvalidDescriptionTest() {
        testProcedure.setDescription("sur");
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithNullDescriptionTest() {
        testProcedure.setDescription(null);
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }

    @Test
    void validateProcedureWithInvalidDurationTest() {
        testProcedure.setDuration(3);
        Assert.assertFalse(procedureValidator.validateProcedure(testProcedure));
    }
}
