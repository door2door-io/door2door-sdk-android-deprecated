package io.door2door.analytics.base;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Test class for {@link DateFormattingHelper}.
 */
public class DateFormattingHelperTest {

    private DateFormattingHelper dateFormattingHelper;

    @Before
    public void setUp() {
        dateFormattingHelper = new DateFormattingHelper();
    }

    @Test
    public void shouldGetDefaultDateFormat() {
        // given

        // when
        String defaultDateFormat = dateFormattingHelper.getDefaultDateFormat();

        // then
        assertThat(defaultDateFormat).isEqualTo("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
    }

}