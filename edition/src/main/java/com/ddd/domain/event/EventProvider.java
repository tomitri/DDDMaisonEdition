package com.ddd.domain.event;

public interface EventProvider {

    void publish(Event event);
    Event get();

    void remove(Event event);
}
