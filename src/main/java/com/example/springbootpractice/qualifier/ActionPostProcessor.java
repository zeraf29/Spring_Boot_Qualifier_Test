package com.example.springbootpractice.qualifier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;

public class ActionPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("Actions")){
            List<Action> actions = new ArrayList<>();
            actions.add((Action) context.getBean("a_Action"));
            actions.add((Action) context.getBean("b_Action"));
            actions.add((Action) context.getBean("c_Action"));

            bean = actions.toArray(new Action[actions.size()]);
        }
        return bean;
    }

}
