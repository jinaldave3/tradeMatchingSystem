package service;

import java.util.concurrent.LinkedBlockingQueue;

public class TradeDataIngestionService {

    private LinkedBlockingQueue<String> tradeQueue = new LinkedBlockingQueue<>();

    public void startIngestion() {
        System.out.println("Ingestion Service Started.");
    }

    public void ingestTradeData(String data) {
        tradeQueue.offer(data);
        System.out.println("Ingested Trade Data: " + data);
    }

    public void stopIngestion() {
        System.out.println("Ingestion Service Stopped.");
    }
}