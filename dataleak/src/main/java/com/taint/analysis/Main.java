package com.taint.analysis;

import com.taint.analysis.config.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static String benchmark = "mall-admin";
    public static String analysisAlgorithm = "cha";

    public static void main(String[] args) throws IOException {
        //Load the path information in source.json file.
        Constant.loadConstant();

        //SetUpApplication implements a common interface that supports all data flow analysis of taint wrappers.
        SetUpApplication application = new SetUpApplication();

        //Create and set up a taint wrapper

        File taintWrapperFile = new File(System.getProperty("user.dir") + File.separator + "soot-infoflow/EasyTaintWrapperSource.txt");
        application.setTaintWrapper((new EasyTaintWrapper(taintWrapperFile)));

        //The main part of the program
        application.runInfoflow(System.getProperty("user.dir") + File.separator + "soot-infoflow-android/SourcesAndSinks-"+ benchmark +".txt");
    }
}
