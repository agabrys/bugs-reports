package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.utku.proposal;

import java.util.List;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class NullToEmptyPropertySerializerModifier extends BeanSerializerModifier {

    private final NullAsEmptyStringSerializer serializer = new NullAsEmptyStringSerializer();

    @Override
    public List<BeanPropertyWriter> changeProperties(final SerializationConfig config, final BeanDescription beanDesc,
            final List<BeanPropertyWriter> beanProperties) {

        for (BeanPropertyWriter beanProperty : beanProperties) {
            beanProperty.assignNullSerializer(serializer);
        }
        return beanProperties;
    }
}
