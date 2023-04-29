package com.vccl.vmfi_boot.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
    private String message;
    private boolean status;
    private T data;

    
}
