package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v289;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializer;

public class SerializationProviderXmlSerializer extends AbstractXmlSerializer {

    @Override
    protected void configureMapper(final XmlMapper mapper) {
        final XmlSerializerProvider provider = new XmlSerializerProvider(new XmlRootNameLookup());
        provider.setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(final Object value, final JsonGenerator jgen, final SerializerProvider provider) throws IOException {
                jgen.writeString("");
            }
        });
        mapper.setSerializerProvider(provider);
    }
}
