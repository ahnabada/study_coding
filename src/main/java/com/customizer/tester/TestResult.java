package com.customizer.tester;

import java.lang.reflect.Method;

public class TestResult {

    Object instance;
    Class solutionClass;
    Method method;
    Object[] parameters;
    Object expected;
    Object result;
    Throwable error;
    Long startTime;
    Long finishTime;



    Long getElapsedTime(){
        if (this.startTime == null || this.finishTime == null)
            return null;

        return this.finishTime - this.startTime;
    }
    void setError(Throwable error){
        this.error = error;
    }






    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public Class getSolutionClass() {
        return solutionClass;
    }

    public void setSolutionClass(Class solutionClass) {
        this.solutionClass = solutionClass;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Object getExpected() {
        return expected;
    }

    public void setExpectedResult(Object expected) {
        this.expected = expected;
    }

    public Throwable getError() {
        return error;
    }

    public void setExpected(Object expected) {
        this.expected = expected;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }
}