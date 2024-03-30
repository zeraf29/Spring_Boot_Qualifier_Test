package com.example.springbootpractice.qualifier.actions;

import com.example.springbootpractice.qualifier.Action;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class A_Action implements Action {
    A_Action(){
        System.out.println(11);
    }
}
