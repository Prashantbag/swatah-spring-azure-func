package com.vccl.vmfi_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vccl.vmfi_boot.domains.Banks;

public interface BankRepository extends JpaRepository<Banks,Integer> {
    
}
