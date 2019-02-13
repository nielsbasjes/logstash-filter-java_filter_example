package nl.example.logstash;

import co.elastic.logstash.api.Configuration;
import co.elastic.logstash.api.Context;
import co.elastic.logstash.api.LogstashPlugin;
import co.elastic.logstash.api.PluginConfigSpec;
import co.elastic.logstash.api.v0.Filter;
import org.apache.commons.lang3.StringUtils;
import org.logstash.Event;

import java.util.Collection;
import java.util.Collections;

// IMPORTANT: class name must match plugin name
@LogstashPlugin(name = "reverse_string")
public class ReverseString implements Filter {

    public static final PluginConfigSpec<String> SOURCE_CONFIG =
            Configuration.stringSetting("source", "message");

    private String sourceField;

    public ReverseString(Configuration config, Context context) {
        // constructors should validate configuration options
        this.sourceField = config.get(SOURCE_CONFIG);
    }

    @Override
    public Collection<Event> filter(Collection<Event> events) {
        for (Event e : events) {
            Object f = e.getField(sourceField);
            if (f instanceof String) {
                e.setField(sourceField, StringUtils.reverse((String)f));
            }
        }
        return events;
    }

    @Override
    public Collection<PluginConfigSpec<?>> configSchema() {
        // should return a list of all configuration options for this plugin
        return Collections.singletonList(SOURCE_CONFIG);
    }
}
