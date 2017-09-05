package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons;

import java.io.IOException;
import java.util.Collection;

public interface XmlSerializer {

    String toXml(Collection<ReportView> reports) throws IOException;
}
