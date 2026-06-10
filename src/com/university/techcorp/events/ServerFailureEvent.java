package com.university.techcorp.events;

import com.university.techcorp.domain.Company;

public class ServerFailureEvent implements GameEvent {
    public void apply(Company company) {
        company.reduceCash(3000);
    }

    public String getName() {
        return "Server failure: company lost 3000 cash.";
    }
}