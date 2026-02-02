package com.shakirali.rental.services.impl;

import com.shakirali.rental.beans.RentStatus;
import com.shakirali.rental.entity.Tenant;
import com.shakirali.rental.entity.Transactions;
import com.shakirali.rental.repository.TenantRepository;
import com.shakirali.rental.repository.TransactionsRepository;
import com.shakirali.rental.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public void addTransaction(String name, String mobileNo, Double amount, LocalDate date) {
        Tenant tenant = tenantRepository.findByNameAndMobile_No(name, mobileNo);
        if (tenant == null) {
            throw new RuntimeException("Tenant not found");
        }

        Transactions transactions = setTransaction(name, mobileNo, amount, date);
        validations(transactions);
        transactionsRepository.save(transactions);
        updateTenantDetailsAfterTransaction(tenant, amount);
    }

    private Transactions setTransaction(String name, String mobileNo, Double amount, LocalDate date) {
        Transactions transactions = new Transactions();
        Tenant tenant = new Tenant();
        tenant.getId().setName(name);
        tenant.getId().setMobileNo(mobileNo);
        transactions.setTenant(tenant);
        transactions.setAmount(amount);
        transactions.setPaymentDate(date);

        return transactions;
    }

    private void validations(Transactions transactions) {
        boolean validate = false;
        // Checking Tenant
        if(transactions == null){
            throw new IllegalArgumentException("Transactions cannot be null");
        }
        // Validating Start Date
        if(transactions.getAmount() == 0) {
            throw new RuntimeException("Enter valid transaction amount");
        }
        // Validating Starting Rent and Updating Current Rent
        if(transactions.getPaymentDate() == null) {
            transactions.setPaymentDate(LocalDate.now());
        }
    }

   private void updateTenantDetailsAfterTransaction(Tenant tenant, Double amount) {
       tenant.setRemainingRent(tenant.getRemainingRent() - amount);
       if(tenant.getRemainingRent() <= 0) {
           tenant.setRentStatus(RentStatus.PAID);
       } else {
           tenant.setRentStatus(RentStatus.DUE);
       }

       tenantRepository.save(tenant);
   }

}
