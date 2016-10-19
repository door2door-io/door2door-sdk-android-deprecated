package io.door2door.analytics.network;

import io.door2door.analytics.network.model.EventRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * An interface for the retrofit library.
 */
public interface RetrofitService {

    /**
     * Send an event to the backend.
     *
     * @param eventRequest the event request.
     * @return response from the server in an RX observable form.
     */
    @POST("events")
    Observable<Void> postEvent(@Body EventRequest eventRequest);
}
