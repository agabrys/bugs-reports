package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v289;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializer;

public class SerializerModifierXmlSerializer extends AbstractXmlSerializer {

    @Override
    protected void configureMapper(final XmlMapper mapper) {
        mapper.registerModule(create());
    }

    @SuppressWarnings("serial")
    public static Module create() {
        final SimpleModule module = new SimpleModule();

        module.setSerializerModifier(new XmlBeanSerializerModifier() {

            @Override
            public JsonSerializer<?> modifyArraySerializer(final SerializationConfig config, final ArrayType valueType,
                    final BeanDescription beanDesc, final JsonSerializer<?> serializer) {
                final JsonSerializer<?> modifiedSerializer = super.modifyArraySerializer(config, valueType, beanDesc, serializer);
                return new PrintEmptyElementsJsonSerializer(modifiedSerializer, o -> ((Object[]) o).length == 0);
            }

            @Override
            public JsonSerializer<?> modifyMapSerializer(SerializationConfig config, MapType valueType, BeanDescription beanDesc,
                    JsonSerializer<?> serializer) {
                final JsonSerializer<?> modifiedSerializer = super.modifyMapSerializer(config, valueType, beanDesc, serializer);
                return new PrintEmptyElementsJsonSerializer(modifiedSerializer, o -> ((Map<?, ?>) o).isEmpty());
            }

            @Override
            public JsonSerializer<?> modifyCollectionSerializer(final SerializationConfig config, final CollectionType valueType,
                    final BeanDescription beanDesc, final JsonSerializer<?> serializer) {
                final JsonSerializer<?> modifiedSerializer = super.modifyCollectionSerializer(config, valueType, beanDesc, serializer);
                return new PrintEmptyElementsJsonSerializer(modifiedSerializer, o -> ((Collection<?>) o).isEmpty());
            }

            @Override
            public JsonSerializer<?> modifyCollectionLikeSerializer(final SerializationConfig config, final CollectionLikeType valueType,
                    final BeanDescription beanDesc, final JsonSerializer<?> serializer) {
                final JsonSerializer<?> modifiedSerializer = super.modifyCollectionLikeSerializer(config, valueType, beanDesc, serializer);
                return new PrintEmptyElementsJsonSerializer(modifiedSerializer, o -> ((Collection<?>) o).isEmpty());
            }
        });
        return module;
    }

    private static class PrintEmptyElementsJsonSerializer extends JsonSerializer<Object> {

        private final JsonSerializer<Object> serializer;
        private final Predicate<Object> predicate;

        @SuppressWarnings("unchecked")
        public PrintEmptyElementsJsonSerializer(final JsonSerializer<?> serializer, final Predicate<Object> predicate) {
            this.serializer = (JsonSerializer<Object>) serializer;
            this.predicate = predicate;
        }

        @Override
        public void serialize(final Object object, final JsonGenerator generator, final SerializerProvider provider)
                throws IOException, JsonProcessingException {

            if (predicate.test(object)) {
                generator.writeStartObject();
                generator.writeEndObject();
            } else {
                serializer.serialize(object, generator, provider);
            }
        }
    }
}
