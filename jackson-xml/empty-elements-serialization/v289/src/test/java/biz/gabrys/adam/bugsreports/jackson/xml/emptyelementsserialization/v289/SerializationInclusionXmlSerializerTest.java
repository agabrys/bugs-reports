package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v289;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.XmlSerializer;
import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.XmlSerializerTest;

public class SerializationInclusionXmlSerializerTest extends XmlSerializerTest {

    @Override
    protected XmlSerializer createSerializer() {
        return new SerializationInclusionXmlSerializer();
    }
}
