package io.door2door.analytics.network.model;

/**
 * Network model for updating events.
 */
public class UpdateEvent extends BaseEvent {

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
