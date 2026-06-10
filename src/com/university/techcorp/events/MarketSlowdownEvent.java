package com.university.techcorp.events;

import com.university.techcorp.domain.Company;

public class MarketSlowdownEvent implements GameEvent {
    public void apply(Company company) {
        company.reduceCash(5000);
        company.decreaseReputation(5);
    }

    public String getName() {
        return "Market slowdown: company lost 5000 cash and 5 reputation.";
    }
}