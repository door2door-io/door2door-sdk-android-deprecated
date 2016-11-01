package io.door2door.analytics.network;

import io.door2door.analytics.network.model.TripRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * An interface for the retrofit library.
 */
public interface RetrofitService {

    /**
     * Send a trip event event to the backend.
     *
     * @param tripRequest the request body.
     * @return response from the server in an RX observable form.
     */
    @POST("trips")
    Observable<Void> postTripEvent(@Body TripRequest tripRequest);
}
