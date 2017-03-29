package io.door2door.analytics.network;

import io.door2door.analytics.network.model.TripRequest;
import retrofit2.http.Body;
import retrofit2.http.Header;
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
     * @param authorization the authorization header.
     * @return response from the server in an RX observable form.
     */
    @POST("trips")
    Observable<Void> postTripEvent(@Header("Authorization") String authorization, @Body TripRequest tripRequest);
}
