package io.door2door.analytics.base.logger;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import io.door2door.analytics.base.Logger;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Test class for {@link Logger}.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23)
public class LoggerTest {

    private Logger logger;

    @Before
    public void setUp() {
        ShadowLog.reset();
        ShadowLog.stream = System.out;
        logger = new Logger(true);
    }

    @Test
    public void shouldLogOnDebugLevel() {
        // given
        String tag = "TEST_TAG";
        String message = "Debug log without throwable";

        // when
        logger.d(tag, message);

        // then
        assertLogs(Log.DEBUG, tag, message);
    }

    @Test
    public void shouldLogOnDebugLevelWithThrowable() {
        // given
        String tag = "TEST_TAG";
        String message = "Debug log with throwable";
        Throwable throwable = new RuntimeException();

        // when
        logger.d(tag, message, throwable);

        // then
        assertLogs(Log.DEBUG, tag, message, throwable);
    }

    @Test
    public void shouldNotLogOnDebugLevelIfLoggingIsNotEnabled() {
        // given
        String tag = "TEST_TAG";
        String message = "Debug log without throwable";
        Logger disabledLogger = new Logger(false);

        // when
        disabledLogger.d(tag, message);

        // then
        assertThat(ShadowLog.getLogs().isEmpty()).isEqualTo(true);
    }

    @Test
    public void shouldLogOnWarningLevel() {
        // given
        String tag = "TEST_TAG";
        String message = "Warning log without throwable";

        // when
        logger.w(tag, message);

        // then
        assertLogs(Log.WARN, tag, message);
    }

    @Test
    public void shouldLogOnWarningLevelWithThrowable() {
        // given
        String tag = "TEST_TAG";
        String message = "Warning log with throwable";
        Throwable throwable = new RuntimeException();

        // when
        logger.w(tag, message, throwable);

        // then
        assertLogs(Log.WARN, tag, message, throwable);
    }

    @Test
    public void shouldNotLogOnWarningLevelIfLoggingIsNotEnabled() {
        // given
        String tag = "TEST_TAG";
        String message = "Warning log without throwable";
        Logger disabledLogger = new Logger(false);

        // when
        disabledLogger.w(tag, message);

        // then
        assertThat(ShadowLog.getLogs().isEmpty()).isEqualTo(true);
    }

    @Test
    public void shouldLogOnErrorLevel() {
        // given
        String tag = "TEST_TAG";
        String message = "Error log without throwable";

        // when
        logger.e(tag, message);

        // then
        assertLogs(Log.ERROR, tag, message);
    }

    @Test
    public void shouldLogOnErrorLevelWithThrowable() {
        // given
        String tag = "TEST_TAG";
        String message = "Error log with throwable";
        Throwable throwable = new RuntimeException();

        // when
        logger.e(tag, message, throwable);

        // then
        assertLogs(Log.ERROR, tag, message, throwable);
    }

    @Test
    public void shouldNotLogOnErrorLevelIfLoggingIsNotEnabled() {
        // given
        String tag = "TEST_TAG";
        String message = "Error log without throwable";
        Logger disabledLogger = new Logger(false);

        // when
        disabledLogger.e(tag, message);

        // then
        assertThat(ShadowLog.getLogs().isEmpty()).isEqualTo(true);
    }

    private void assertLogs(int level, String tag, String message) {
        assertLogs(level, tag, message, null);
    }

    private void assertLogs(int level, String tag, String message, Throwable throwable) {
        assertThat(ShadowLog.getLogs().size()).isEqualTo(1);
        assertThat(ShadowLog.getLogs().get(0).msg).isEqualTo(message);
        assertThat(ShadowLog.getLogs().get(0).throwable).isEqualTo(throwable);
        assertThat(ShadowLog.getLogs().get(0).tag).isEqualTo(tag);
        assertThat(ShadowLog.getLogs().get(0).type).isEqualTo(level);
    }

}