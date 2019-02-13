package org.logstash.filters.nl.example.logstash;

import co.elastic.logstash.api.Configuration;
import co.elastic.logstash.api.Context;
import org.junit.Assert;
import org.junit.Test;
import org.logstash.Event;

import java.util.Collection;
import java.util.Collections;

public class ReverseStringTest {

    @Test
    public void testJavaExampleFilter() {
        String        sourceField = "foo";
        Configuration config      = new Configuration(Collections.singletonMap("source", sourceField));
        Context       context     = new Context();
        ReverseString filter      = new ReverseString(config, context);

        Event e = new Event();
        e.setField(sourceField, "abcdef");
        Collection<Event> results = filter.filter(Collections.singletonList(e));

        Assert.assertEquals(1, results.size());
        Assert.assertEquals("fedcba", e.getField(sourceField));
    }
}
