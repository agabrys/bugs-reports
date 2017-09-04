package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v290;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializer;

public class EmptyElementAsNullXmlSerializer extends AbstractXmlSerializer {

    @Override
    protected void configureMapper(final XmlMapper mapper) {
        mapper.configure(FromXmlParser.Feature.EMPTY_ELEMENT_AS_NULL, false);
    }
}
