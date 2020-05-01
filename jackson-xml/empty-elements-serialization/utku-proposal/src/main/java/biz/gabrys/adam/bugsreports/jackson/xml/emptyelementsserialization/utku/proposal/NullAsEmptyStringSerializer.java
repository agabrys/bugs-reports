package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.utku.proposal;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

public class NullAsEmptyStringSerializer extends JsonSerializer<Object> {

    private static final String EMPTY_STRING = "";

    private final StringSerializer stringSerializer = new StringSerializer();

    @Override
    public void serialize(final Object value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        stringSerializer.serialize(EMPTY_STRING, gen, serializers);
    }
}
