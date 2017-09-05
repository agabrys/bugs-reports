package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons;

import java.io.IOException;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public abstract class XmlSerializerTest {

    protected abstract XmlSerializer createSerializer();

    @Test
    public void testToXml() throws IOException {
        final Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("text", "text");
        payload.put("emptyList", Collections.emptyList());
        payload.put("emptyMap", Collections.emptyMap());
        payload.put("emptyArray", new Object[0]);
        payload.put("enum", Month.APRIL);
        payload.put("null", null);
        payload.put("objectWithNulls", new TypeWithNulls());
        payload.put("objectWithEmpty", new TypeWithEmpty());
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
        expected.append("      <text>text</text>");
        expected.append("      <emptyList/>");
        expected.append("      <emptyMap/>");
        expected.append("      <emptyArray/>");
        expected.append("      <enum>APRIL</enum>");
        expected.append("      <null/>");
        expected.append("      <objectWithNulls>");
        expected.append("        <nullEnum/>");
        expected.append("        <nullList/>");
        expected.append("        <nullMap/>");
        expected.append("        <nullArray/>");
        expected.append("      </objectWithNulls>");
        expected.append("      <objectWithEmpty>");
        expected.append("        <emptyList/>");
        expected.append("        <emptyMap/>");
        expected.append("        <emptyArray/>");
        expected.append("      </objectWithEmpty>");
        expected.append("    </payload>");
        expected.append("    <timestamp>" + date.getTime() + "</timestamp>");
        expected.append("    <changingUser>system</changingUser>");
        expected.append("  </item>");
        expected.append("</report>");

        System.out.println(xml);
        Assertions.assertThat(xmlWithoutNewLInes).isEqualTo(expected.toString());
    }

    public static class TypeWithNulls {
        private Month nullEnum;
        private List<String> nullList;
        private Map<String, String> nullMap;
        private Object[] nullArray;

        public Month getNullEnum() {
            return nullEnum;
        }

        public List<String> getNullList() {
            return nullList;
        }

        public Map<String, String> getNullMap() {
            return nullMap;
        }

        public Object[] getNullArray() {
            return nullArray;
        }
    }

    public static class TypeWithEmpty {
        private final List<String> emptyList = Collections.emptyList();
        private final Map<String, String> emptyMap = Collections.emptyMap();
        private final Object[] emptyArray = new Object[0];

        public List<String> getEmptyList() {
            return emptyList;
        }

        public Map<String, String> getEmptyMap() {
            return emptyMap;
        }

        public Object[] getEmptyArray() {
            return emptyArray;
        }
    }
}
