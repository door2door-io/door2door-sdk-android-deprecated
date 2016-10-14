package io.door2door.analytics.data;

import io.door2door.analytics.data.model.BaseResponse;
import io.door2door.analytics.data.model.EventRequest;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * An interface for the retrofit library.
 */
public interface RetrofitService {

    /**
     * Send an event to the backend.
     *
     * @param uuid         the UUID.
     * @param eventRequest the event request.
     * @return response from the server.
     */
    @POST("someUrl.com")
    Observable<BaseResponse> postEvent(@Header("userId") String uuid,
                                       @Body EventRequest eventRequest);
}
