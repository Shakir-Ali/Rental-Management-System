package com.shakirali.rental.services;

import java.time.LocalDate;

public interface TransactionsService {

    public void addTransaction(String name, String mobileNo, Double amount, LocalDate date);

}
