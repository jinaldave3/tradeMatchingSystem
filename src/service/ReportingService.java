package service;

import java.util.HashMap;
import java.util.Map;

public class ReportingService {

    private Map<String, String> reports = new HashMap<>();

    public void startReporting() {
        System.out.println("Reporting Service Started.");
    }

    public void addTradeData(String tradeId, String data) {
        reports.put(tradeId, data);
        System.out.println("Report Generated for: " + tradeId);
    }

    public void stopReporting() {
        System.out.println("Reporting Service Stopped.");
    }
}
