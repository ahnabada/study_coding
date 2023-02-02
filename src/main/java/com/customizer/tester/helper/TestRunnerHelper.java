package com.customizer.tester.helper;

import com.customizer.tester.display.LastPartOfPackageNameDisplay;
import jaemisseo.man.util.Util;
import com.customizer.tester.TestRunner;
import org.junit.jupiter.api.DisplayNameGeneration;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@DisplayNameGeneration(LastPartOfPackageNameDisplay.class)
public class TestRunnerHelper {

    protected static HashMap<String, List<Class>> classesMap = new HashMap<>();
    protected static HashMap<String, TestRunner> testRunnerMap = new HashMap<>();
    protected String packageName = this.getClass().getPackage().getName();


    public TestRunner testRunner() throws IOException, ClassNotFoundException {
        TestRunner testRunner = testRunnerMap.get(packageName);
        if (testRunner == null){
            List<Class> classList = findClasses(packageName);
            Class[] classArray = classList.toArray(new Class[0]);

            testRunner = new TestRunner().targetClass( classArray );
            testRunnerMap.put(packageName, testRunner);
        }

        return testRunner;
    }

    public List<Class> findClasses(String packageName) throws IOException, ClassNotFoundException {
        List<Class> classList = classesMap.get(packageName);
        if (classList == null){
            classList = Util.findAllClasses(packageName);
            classesMap.put(packageName, classList);
        }

        return classList;
    }

}
