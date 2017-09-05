package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v290;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.XmlSerializer;
import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.XmlSerializerTest;

public class EmptyElementAsNullXmlSerializerTest extends XmlSerializerTest {

    @Override
    protected XmlSerializer createSerializer() {
        return new EmptyElementAsNullXmlSerializer();
    }
}
