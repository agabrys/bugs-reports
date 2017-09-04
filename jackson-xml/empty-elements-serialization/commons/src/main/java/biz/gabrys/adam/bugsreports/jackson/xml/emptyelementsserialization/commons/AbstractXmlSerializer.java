package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons;

import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public abstract class AbstractXmlSerializer {

    public String toXml(final Collection<ReportView> reports) throws IOException {
        final XmlMapper mapper = new XmlMapper();
        configureMapper(mapper);
        return mapper.writerWithDefaultPrettyPrinter().withRootName("report").writeValueAsString(reports);
    }

    protected abstract void configureMapper(XmlMapper mapper);
}
