package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.v290;

import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializer;
import biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons.AbstractXmlSerializerTest;

public class EmptyElementAsNullXmlSerializerTest extends AbstractXmlSerializerTest {

    @Override
    protected AbstractXmlSerializer createSerializer() {
        return new EmptyElementAsNullXmlSerializer();
    }
}
