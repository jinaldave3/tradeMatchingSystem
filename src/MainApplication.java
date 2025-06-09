import service.TradeDataIngestionService;
import service.TradeMatchingEngine;
import service.CommunicationService;
import service.ReportingService;
import service.MonitoringService;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {

        System.out.println("Starting Trade Matching and Affirmation System...");

        // Initialize Services
        TradeDataIngestionService ingestionService = new TradeDataIngestionService();
        TradeMatchingEngine matchingEngine = new TradeMatchingEngine();
        CommunicationService communicationService = new CommunicationService();
        ReportingService reportingService = new ReportingService();
        MonitoringService monitoringService = new MonitoringService();

        // Start Services
        ingestionService.startIngestion();
        matchingEngine.startMatching();
        reportingService.startReporting();
        monitoringService.startMonitoring();

        // Sample Data
        simulateTradeDataIngestion(ingestionService, matchingEngine, communicationService, reportingService);

        // User Input for stopping the services
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter 'stop' to terminate the system.");
            while (!scanner.nextLine().equalsIgnoreCase("stop")) {
                System.out.println("Invalid command. Enter 'stop' to terminate.");
            }
        } finally {
            scanner.close();  // Ensure the scanner is closed
        }

        // Shutdown Services
        ingestionService.stopIngestion();
        matchingEngine.stopMatching();
        reportingService.stopReporting();
        monitoringService.stopMonitoring();

        System.out.println("Trade Matching and Affirmation System terminated.");
    }

    private static void simulateTradeDataIngestion(
            TradeDataIngestionService ingestionService,
            TradeMatchingEngine matchingEngine,
            CommunicationService communicationService,
            ReportingService reportingService) {

        String trade1 = "Trade001|FX|Buy|1000|USD";
        String trade2 = "Trade002|IRS|Sell|500|EUR";
        String trade3 = "Trade003|FX|Buy|3000|GBP";

        ingestionService.ingestTradeData(trade1);
        ingestionService.ingestTradeData(trade2);
        ingestionService.ingestTradeData(trade3);

        matchingEngine.processTrade("Trade001", trade1);
        matchingEngine.processTrade("Trade002", trade2);
        matchingEngine.processTrade("Trade003", trade3);

        communicationService.sendFIXMessage("Trade001 Matched");
        reportingService.addTradeData("Trade001", trade1);
    }
}