package io.door2door.analytics.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * The enum Action.
 */
public enum Action {

    /**
     * Search action.
     */
    @SerializedName("search")
    SEARCH,
    /**
     * Interest action.
     */
    @SerializedName("insert")
    INTEREST,
    /**
     * Book action.
     */
    @SerializedName("book")
    BOOK,
    /**
     * Begin action.
     */
    @SerializedName("begin")
    BEGIN,
    /**
     * Pay action.
     */
    @SerializedName("pay")
    PAY,
    /**
     * End action.
     */
    @SerializedName("end")
    END,
    /**
     * Cancel action.
     */
    @SerializedName("cancel")
    CANCEL;

}
