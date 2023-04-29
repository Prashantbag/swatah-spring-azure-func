package com.vccl.vmfi_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vccl.vmfi_boot.dao.BanksDao;
import com.vccl.vmfi_boot.util.ResponseStructure;

@Service
public class BankService {
    
    @Autowired
    BanksDao banksDao;

    public ResponseStructure getAllBanks() {
        ResponseStructure responseDTO = new ResponseStructure();
       
            responseDTO.setData(banksDao.getAllBanks());
            responseDTO.setStatus(true);
       
        return responseDTO;
    } 
}
