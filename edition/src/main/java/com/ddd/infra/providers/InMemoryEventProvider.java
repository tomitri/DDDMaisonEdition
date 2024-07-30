package com.ddd.infra.providers;

import com.ddd.domain.event.Event;
import com.ddd.domain.event.EventProvider;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryEventProvider implements EventProvider {

    private List<Event> queue;

    @Override
    public void publish(Event event) {
        if (queue == null) queue =  new ArrayList<>();
        queue.add(event);
    }

    @Override
    public Event get() {
        return queue.getLast();
    }

    @Override
    public void remove(Event event) {
        queue.remove(event);
    }

}
