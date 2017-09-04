package biz.gabrys.adam.bugsreports.jackson.xml.emptyelementsserialization.commons;

import java.util.Date;
import java.util.Map;

public class ReportView {
    private final Map<String, Object> payload;
    private final Date timestamp;
    private final String changingUser;

    public ReportView(final Map<String, Object> payload, final Date timestamp, final String changingUser) {
        this.payload = payload;
        this.timestamp = timestamp;
        this.changingUser = changingUser;
    }

    public String getChangingUser() {
        return changingUser;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }
}
