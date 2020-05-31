package com.project.business_layer.mediator;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.handler.command.AddBoardHandler;
import com.project.business_layer.mediator.handler.command.AddCardHandler;
import com.project.business_layer.mediator.handler.command.RegisterHandler;
import com.project.business_layer.mediator.handler.query.GetBoardHandler;
import com.project.business_layer.mediator.handler.query.GetBoardsHandler;
import com.project.business_layer.mediator.handler.query.GetCardsHandler;
import com.project.business_layer.mediator.handler.query.LoginHandler;
import com.project.business_layer.mediator.request.TRequest;
import com.project.business_layer.mediator.request.command.AddBoardCommand;
import com.project.business_layer.mediator.request.command.AddCardCommand;
import com.project.business_layer.mediator.request.command.RegisterCommand;
import com.project.business_layer.mediator.request.query.GetBoardQuery;
import com.project.business_layer.mediator.request.query.GetBoardsQuery;
import com.project.business_layer.mediator.request.query.GetCardsQuery;
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
        _handlerMap.put(GetBoardsQuery.class, GetBoardsHandler.class);
        _handlerMap.put(GetCardsQuery.class, GetCardsHandler.class);
        _handlerMap.put(GetBoardQuery.class, GetBoardHandler.class);

        _handlerMap.put(RegisterCommand.class, RegisterHandler.class);
        _handlerMap.put(AddBoardCommand.class, AddBoardHandler.class);
        _handlerMap.put(AddCardCommand.class, AddCardHandler.class);

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
