package io.door2door.analytics.api.model;

import io.door2door.analytics.network.model.Person;
import io.door2door.analytics.network.model.Place;

/**
 * Base abstract class for all events that can be sent by the SDK.
 */
public class Event {

    // TODO 2016-10-18 zlatko: temporary fields, no network models should be used here
    private Person actor;
    private Place object;

    /**
     * @return the actor.
     */
    public Person getActor() {
        return actor;
    }

    /**
     * @param actor the actor to set/
     */
    public void setActor(Person actor) {
        this.actor = actor;
    }

    /**
     * @return the object.
     */
    public Place getObject() {
        return object;
    }

    /**
     * @param object the object to set.
     */
    public void setObject(Place object) {
        this.object = object;
    }

}
