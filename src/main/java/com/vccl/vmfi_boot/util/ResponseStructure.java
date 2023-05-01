package com.vccl.vmfi_boot.util;

import lombok.Data;

@Data
public class ResponseStructure {
    private String message;
    private boolean status;
    private Object data;

    
}
