package com.customizer.tester;

public class TestCase {
        Object[] parameters;
        Object expected;
        public TestCase parameters(Object... parameters){
            this.parameters = parameters;
            return this;
        }
        public TestCase expected(Object result){
            this.expected = result;
            return this;
        }

    }