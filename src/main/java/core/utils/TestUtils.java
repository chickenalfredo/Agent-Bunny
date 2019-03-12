package core.utils;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * A utility class for JUnit that will test all accessors of a class and return
 * whether or not the test passed or failed. 
 * <source: https://github.com/OpenPojo/openpojo/wiki/Tutorial-2.-Simple-Bulk-Validation,-Single-Package>
 */
public class TestUtils {

    private static final Validator ACCESSOR_VALIDATOR = ValidatorBuilder.create().with(new GetterTester()).with(new SetterTester()).build();

    /**
     * Validates all accessors of the provided class 
     * 
     * @param   the class to be validated
     */
    public static void validateAccessors(final Class<?> clazz) {
        ACCESSOR_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }
}
