package io.door2door.analytics.api;

import com.google.common.io.Files;

import org.apache.maven.artifact.ant.shaded.StringUtils;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import io.door2door.analytics.DummyModelsCreatorUtil;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.api.model.SearchTripEvent;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.mockito.Mockito.when;

/**
 * Test class for the integration tests for {@link MobilityAnalytics}.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23, manifest = Config.NONE)
public class MobilityAnalyticsIntegrationTest {

    private MobilityAnalytics mobilityAnalytics;

    @Mock
    private InitializationParameters initParams;
    private MockWebServer server;

    @Before
    public void setUp() throws IOException, InterruptedException {
        System.setProperty("user.timezone", "UTC");

        MockitoAnnotations.initMocks(this);
        ShadowLog.stream = System.out;
        server = new MockWebServer();
        server.enqueue(new MockResponse().setBody("Success"));

        String mockBaseUrl = String.format("http://%s:%s", server.getHostName(), server.getPort());
        when(initParams.getBaseUrl()).thenReturn(mockBaseUrl);
        when(initParams.isLoggerEnabled()).thenReturn(true);
        mobilityAnalytics = new MobilityAnalytics(RuntimeEnvironment.application, initParams);
    }

    @After
    public void cleanUp() throws IOException {
        server.shutdown();
    }

    @Test
    public void shouldRecordSearchTripEvent() throws InterruptedException, JSONException {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil
                .getDummySearchTripEventBuilder()
                .build();

        // when
        mobilityAnalytics.recordEvent(event);

        // then
        RecordedRequest request = server.takeRequest();
        String requestBody = removeRequestSpecificValues(request.getBody().readUtf8());
        String expectedRequestBody = getTextContentFromResources("search_trip_event_request.json");
        JSONAssert.assertEquals(expectedRequestBody, requestBody, true);
    }

    private String removeRequestSpecificValues(String requestBody) {
        return requestBody
                .replaceAll("\"search\",\"timestamp\":\".*?\",", "\"search\",")
                .replaceAll("\"device_id\":\".*?\",", "");
    }

    private String getTextContentFromResources(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            List<String> strings = Files.readLines(file, Charset.forName("UTF-8"));
            return StringUtils.join(strings.iterator(), "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
