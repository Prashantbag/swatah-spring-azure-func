package com.vccl.vmfi_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vccl.vmfi_boot.dao.BanksDao;
import com.vccl.vmfi_boot.domains.Banks;
import com.vccl.vmfi_boot.util.ResponseStructure;

@Service
public class BankService {
    
    @Autowired
    BanksDao banksDao;

    public ResponseStructure getAllBanks() {
        ResponseStructure responseDTO = new ResponseStructure();
       
            responseDTO.setData(banksDao.getAllBanks());
            responseDTO.setStatus(true);
            responseDTO.setMessage("Banks List");
        return responseDTO;
    } 

    public ResponseStructure saveBank(Banks bank) {
        ResponseStructure responseDTO = new ResponseStructure();
            
            Banks newbank= banksDao.saveBank(bank);
            responseDTO.setData(newbank);
            responseDTO.setStatus(true);
            responseDTO.setMessage("Data INserted");
       
        return responseDTO;
    }
    
}
