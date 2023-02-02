package com.customizer.tester;

import jaemisseo.man.AnsiMan;
import com.customizer.tester.helper.ReflectionAnalyzer;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class TestReport {

    public static void report(List<TestResult> testResults) throws InvocationTargetException, IllegalAccessException {
        for (TestResult result : testResults) {
            if (result.error == null){
                System.out.println( AnsiMan.testGreen("[Success] " +result.solutionClass.getCanonicalName()+ "." +result.method.getName()+ "") );
                System.out.println( "    - Result   : " +AnsiMan.testGreen(toString(result.result)) );
                System.out.println( "    - Expected : " +toString(result.expected) );
                System.out.println( "    - Time(ms) : " +result.getElapsedTime() );
            }else{
                System.out.println( AnsiMan.testRed("[Failed]  " +result.solutionClass.getCanonicalName()+ "." +result.method.getName()+ "") );
                System.out.println( "    - Result   : " +AnsiMan.testRed(toString(result.result)) );
                System.out.println( "    - Expected : " +toString(result.expected) );
                System.out.println( "    - Error    : " +result.error.getMessage());
            }
            System.out.println("");
        }
    }

    public static String toString(Object object){
        if (object == null)
            return null;

        if (object.getClass().isArray() || object instanceof Collection || object instanceof Map){
            return new ReflectionAnalyzer().toString(object);
        }

        return object.toString();
    }

    public static void checkError(List<TestResult> testResults) throws Exception {
        for (TestResult result : testResults) {
            if (result.error != null){
                throw new Exception(result.error);
            }
        }
    }
        
}