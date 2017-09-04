package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v289;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializer;
import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializerTest;

public class SerializationInclusionXmlSerializerTest extends AbstractXmlSerializerTest {

    @Override
    protected AbstractXmlSerializer createSerializer() {
        return new SerializationInclusionXmlSerializer();
    }
}
