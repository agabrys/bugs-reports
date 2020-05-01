package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.utku.proposal;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.XmlSerializer;
import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.XmlSerializerTest;

public class SerializerModifierXmlSerializerTest extends XmlSerializerTest {

    @Override
    protected XmlSerializer createSerializer() {
        return new SerializerModifierXmlSerializer();
    }
}
