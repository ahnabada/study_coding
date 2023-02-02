package com.customizer.tester;

import jaemisseo.man.util.Util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;

public class TestRunner {
    private final List<String> EXCLUDE_SOLUTION_CLASS_PREFIX = Arrays.asList("_test");
    Class[] solutionClasses;
    String solutionMethod = "solution";
    BiConsumer<Object, Object> checkerBiConsumer;

    public TestRunner targetClass(String... solutionPacakges) {
        List<Class> classes = new ArrayList<>();
        for (String pkg : solutionPacakges) {
            try{
                List<Class> foundClasses = Util.findAllClasses(pkg);
                classes.addAll( foundClasses );

            }catch(Exception e){
                e.printStackTrace();
            }
        };

        Class[] classArray = classes.toArray(new Class[0]);
        targetClass(classArray);
        return this;
    }

    public TestRunner targetClass(Class... solutionClasses){
        List<Class> list = new ArrayList<>();

        //Filter
        for (Class c : solutionClasses){
            boolean classIsExclusion = EXCLUDE_SOLUTION_CLASS_PREFIX.stream().anyMatch( prefix -> c.getSimpleName().startsWith(prefix) );
            if (!classIsExclusion){
                list.add( c );
            }
        }

        this.solutionClasses = list.toArray(new Class[0]);

        return this;
    }

    public TestRunner targetMethod(String solutionMethod){
        this.solutionMethod = solutionMethod;
        return this;
    }

    public TestRunner checker(BiConsumer<Object, Object> checker){
        this.checkerBiConsumer = checker;
        return this;
    }

    public List<TestResult> test(TestCase... tcs) throws Exception {
        List<TestResult> results = new ArrayList<>();
        List<Throwable> errors = new ArrayList<>();

        for (TestCase tc : tcs) {
                try {
                    List<TestResult> testResults = testOneCase(tc);
                    results.addAll(testResults);

                }catch(AssertionError e){
                    errors.add(e);
                }catch(Exception e){
                    errors.add(e);
                    throw e;
                }
        }

        TestReport.report(results);
        TestReport.checkError(results);

        return results;
    }

    public List<TestResult> testOneCase(TestCase tc) throws Exception {
        List<TestResult> testResults = new ArrayList<>();

        if (solutionClasses == null || solutionClasses.length == 0)
            throw new Exception("Does not exists solution class.");

        Arrays.asList(solutionClasses).forEach(s -> {
                TestResult result = test(s, tc.parameters, tc.expected);
                testResults.add( result );
        });

        return testResults;
    }

    public TestResult test(Class solutionClass, Object[] parameters, Object expectedResult){
        TestResult testResult = new TestResult();
        testResult.setParameters( parameters );
        testResult.setExpected( expectedResult );
        testResult.setSolutionClass( solutionClass );

        Class<?>[] parameterClasses = new Class<?>[parameters.length];
        Method method = null;
        Object solutionInstance = null;
        Object result = null;

//        for (int i = 0; i < parameters.length; i++) {
//            parameterClasses[i] = parameters[i].getClass();
//        }
//
//        try {
//            method = solutionClass.getMethod(solutionMethod, parameterClasses);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }

        for (Method m : solutionClass.getMethods()) {
            if (m.getName().equals(solutionMethod)){
                method = m;
                parameterClasses = m.getParameterTypes();
            }
        }
        testResult.setMethod( method );

        try {
            solutionInstance = solutionClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        testResult.setInstance( method );

        try {
            testResult.setStartTime( new Date().getTime() );
            Object[] param = null;
            if (parameterClasses.length == 1){
                param = new Object[]{ parameters };
            }else{
                param = parameters;
            }
            try{
                result = method.invoke(solutionInstance, param);
            }catch(Exception e){
                result = method.invoke(solutionInstance, parameters);
            }
            testResult.setFinishTime( new Date().getTime() );

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            e.printStackTrace();
        }
        testResult.setResult( result );

        try{
            checkerBiConsumer.accept(expectedResult, result);
        }catch(AssertionError ae){
//                ae.printStackTrace();
            testResult.setError(ae);
        }

        return testResult;
    }

}