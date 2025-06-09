package service;

import java.util.HashMap;
import java.util.Map;

public class TradeMatchingEngine {

    private Map<String, String> tradeBook = new HashMap<>();

    public void startMatching() {
        System.out.println("Matching Engine Started.");
    }

    public void processTrade(String tradeId, String tradeData) {
        tradeBook.put(tradeId, tradeData);
        System.out.println("Processing Trade: " + tradeId);
    }

    public void stopMatching() {
        System.out.println("Matching Engine Stopped.");
    }
}