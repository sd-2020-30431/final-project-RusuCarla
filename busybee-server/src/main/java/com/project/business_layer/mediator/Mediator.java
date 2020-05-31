package com.project.business_layer.mediator;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.handler.command.RegisterHandler;
import com.project.business_layer.mediator.handler.query.LoginHandler;
import com.project.business_layer.mediator.request.TRequest;
import com.project.business_layer.mediator.request.command.RegisterCommand;
import com.project.business_layer.mediator.request.query.LoginQuery;
import com.project.business_layer.mediator.response.TResponse;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final Map<Class<? extends TRequest>, Class<? extends IHandler<? extends TRequest, ? extends  TResponse>>> _handlerMap;

    public Mediator(){
        this._handlerMap = new HashMap<>();

        _handlerMap.put(LoginQuery.class, LoginHandler.class);

        _handlerMap.put(RegisterCommand.class, RegisterHandler.class);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T extends TRequest, R extends TResponse> IHandler<T, R> getHandler(T trequest){
        Class<? extends IHandler<? extends TRequest, ? extends TResponse>> specificHandler = _handlerMap.get(trequest.getClass());
        return (IHandler<T, R>) applicationContext.getBean(specificHandler);
    }
}
