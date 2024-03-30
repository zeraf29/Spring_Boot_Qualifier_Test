package com.example.springbootpractice.qualifier;

import com.example.springbootpractice.qualifier.actions.ActionStarter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActionConfig {

    @Bean
    public ActionPostProcessor actionPostProcessor(){
        return new ActionPostProcessor();
    }

    @Bean
    public Action[] Actions(){
        return new Action[]{};
    }

    @Bean
    public ActionStarter ActionStarter(
            Action[] actions,
            @Qualifier("Actions") Action[] qActions){
        int length = actions.length;
        int qLength = qActions.length;
        System.out.println(length);
        System.out.println(qLength);
        return new ActionStarter();
    }
}
