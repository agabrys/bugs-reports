package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public abstract class AbstractXmlSerializerTest {

    protected abstract AbstractXmlSerializer createSerializer();

    @Test
    public void testToXml() throws IOException {
        final Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("amp", "&");
        payload.put("empty", Collections.emptyList());
        final Date date = new Date();
        final ReportView reportView = new ReportView(payload, date, "system");

        // when
        final String xml = createSerializer().toXml(Arrays.asList(reportView));

        // then
        Assertions.assertThat(xml).isNotBlank();
        final String xmlWithoutNewLInes = xml.replace("\n", "").replace("\r", "");

        final StringBuilder expected = new StringBuilder();
        expected.append("<report>");
        expected.append("  <item>");
        expected.append("    <payload>");
        expected.append("      <amp>&amp;</amp>");
        expected.append("      <empty></empty>");
        expected.append("    </payload>");
        expected.append("    <changingUser>system</changingUser>");
        expected.append("    <timestamp>" + date.getTime() + "</timestamp>");
        expected.append("  </item>");
        expected.append("</report>");

        Assertions.assertThat(xmlWithoutNewLInes).isEqualTo(expected.toString());
    }
}
