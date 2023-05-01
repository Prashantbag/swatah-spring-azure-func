package com.vccl.vmfi_boot.azurehandler;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.vccl.vmfi_boot.domains.Banks;
import com.vccl.vmfi_boot.util.ResponseStructure;

public class BanksHandler extends AzureSpringBootRequestHandler<Object, ResponseStructure>{
    
    
    @FunctionName("getBanksList")
    public ResponseStructure get(
            @HttpTrigger(name = "bankGetRequest", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<List<Banks>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody(), context);
    }

    @FunctionName("saveBank")
    public ResponseStructure save(
            @HttpTrigger(name = "userSaveRequest", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Banks>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody().get(), context);
    }

}
