package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v289;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializer;

public class SerializationInclusionXmlSerializer extends AbstractXmlSerializer {

    @Override
    protected void configureMapper(final XmlMapper mapper) {
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }
}
