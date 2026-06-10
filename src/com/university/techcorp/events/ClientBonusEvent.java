package com.university.techcorp.events;

import com.university.techcorp.domain.Company;

public class ClientBonusEvent implements GameEvent {
    public void apply(Company company) {
        company.addCash(8000);
        company.increaseReputation(5);
    }

    public String getName() {
        return "Client bonus: company gained 8000 cash and 5 reputation.";
    }
}