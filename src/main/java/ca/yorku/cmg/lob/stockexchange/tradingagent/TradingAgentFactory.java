package ca.yorku.cmg.lob.stockexchange.tradingagent;

import ca.yorku.cmg.lob.stockexchange.StockExchange;
import ca.yorku.cmg.lob.stockexchange.events.NewsBoard;
import ca.yorku.cmg.lob.trader.Trader;

public class TradingAgentFactory extends AbstractTradingAgentFactory {

    @Override
    public TradingAgent createAgent(String type, String style, Trader t, StockExchange e, NewsBoard n) {

        ITradingStrategy strategy;

        if (style.equalsIgnoreCase("Aggressive")) {
            strategy = new AggressiveTradingStrategy(t, e);
        } else if (style.equalsIgnoreCase("Conservative")) {
            strategy = new ConservativeTradingStrategy(t, e);
        } else {
            throw new IllegalArgumentException("Unknown style: " + style);
        }

        if (type.equalsIgnoreCase("Retail")) {
            return new TradingAgentRetail(t, e, n, strategy);
        } 
        else if (type.equalsIgnoreCase("Institutional")) {
            return new TradingAgentInstitutional(t, e, n, strategy);
        } 
        else {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
