package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.utku.proposal;

import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializer;

/**
 * Utku Ozdemir proposal
 * @see https://stackoverflow.com/a/57527302/4944847
 */
public class SerializerModifierXmlSerializer extends AbstractXmlSerializer {

    @Override
    protected void configureMapper(final XmlMapper mapper) {
        final NullToEmptyPropertySerializerModifier modifier = new NullToEmptyPropertySerializerModifier();
        final SerializerFactory serializerFactory = BeanSerializerFactory.instance.withSerializerModifier(modifier);
        mapper.setSerializerFactory(serializerFactory);
    }
}
