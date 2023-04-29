package com.vccl.vmfi_boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vccl.vmfi_boot.domains.Banks;
import com.vccl.vmfi_boot.repository.BankRepository;

@Repository
public class BanksDao {
    
    @Autowired
    BankRepository bankRepository;

    public List<Banks> getAllBanks(){
        return bankRepository.findAll();
    }
}
