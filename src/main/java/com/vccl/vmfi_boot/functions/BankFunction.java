package com.vccl.vmfi_boot.functions;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vccl.vmfi_boot.domains.Banks;
import com.vccl.vmfi_boot.service.BankService;
import com.vccl.vmfi_boot.util.ResponseStructure;

@Configuration
public class BankFunction {
 
   @Autowired
   BankService bankservice;

    @Bean("getBanksList")
    public Supplier<ResponseStructure> getAllBanks() {
        return () -> bankservice.getAllBanks();
    }

    @Bean("saveBank")
    public Function<Banks,ResponseStructure> saveBank() {
        return bank -> bankservice.saveBank(bank);
    }
   
}
