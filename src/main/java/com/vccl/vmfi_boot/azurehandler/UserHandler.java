package com.vccl.vmfi_boot.azurehandler;

import com.vccl.vmfi_boot.domains.User;
import com.vccl.vmfi_boot.util.ResponseStructure;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.List;
import java.util.Optional;

public class UserHandler extends AzureSpringBootRequestHandler<Object, ResponseStructure> {

    @FunctionName("userSave")
    public ResponseStructure save(
            @HttpTrigger(name = "userSaveRequest", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody().get(), context);
    }

    @FunctionName("alluser")
    public ResponseStructure getAllUser(
            @HttpTrigger(name = "allUserRequest", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<List<User>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody(), context);
    }

    @FunctionName("userGet")
    public ResponseStructure get(
            @HttpTrigger(name = "userGetRequest", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage request,
            @BindingName("id") Integer id, ExecutionContext context) {
        return handleRequest(id, context);
    }

    @FunctionName("userDelete")
    public ResponseStructure delete(
            @HttpTrigger(name = "userDeleteRequest", methods = {HttpMethod.DELETE}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage request,
            @BindingName("id") Integer id, ExecutionContext context) {
        return handleRequest(id, context);
    }

    @FunctionName("userUpdate")
    public ResponseStructure update(
            @HttpTrigger(name = "userUpdateRequest", methods = {HttpMethod.PUT}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody().get(), context);
    }

    @FunctionName("userProfile")
    public ResponseStructure profile(
            @HttpTrigger(name = "userProfileRequest", methods = {HttpMethod.GET}, route = "profile/{id}", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage request,
            @BindingName("id") String id, ExecutionContext context) {
        return handleRequest(id, context);
    }
}