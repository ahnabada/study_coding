package com.customizer.tester.display;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class LastPartOfPackageNameDisplay extends DisplayNameGenerator.Standard {

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        String lastPartOfDotPath = extractLastPartOfDotPath(testClass.getPackage().getName());
        return lastPartOfDotPath;
    }

    private static String extractLastPartOfDotPath(String dotPath){
        String lastPartOfDotPath = "";
        String[] splitedPackageNameArray = dotPath.split("\\.");
        if (splitedPackageNameArray.length > 0)
            lastPartOfDotPath= splitedPackageNameArray[splitedPackageNameArray.length -1];
        return lastPartOfDotPath;
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return super.generateDisplayNameForNestedClass(nestedClass);
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return super.generateDisplayNameForMethod(testClass, testMethod);
    }
}
