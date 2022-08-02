package com.taint.analysis.sourceandsink;

import com.taint.analysis.config.Constant;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;

public class EntryPointManager {

    private List<SootMethod> entryPoints;

    public EntryPointManager() {
        entryPoints = new ArrayList<>();
    }

    public void loadJavaEntryPoints() {

        Chain<SootClass> classes = Scene.v().getApplicationClasses();
        HashSet<String> customizeEntryPoints = getCustomizeEntryPoints();

        for (SootClass sc : classes) {
            for (SootMethod method : sc.getMethods()) {
                if (!method.isAbstract()) entryPoints.add(method);
            }
        }
    }

    public static HashSet<String> getCustomizeEntryPoints() {
        HashSet<String> customizeEntryPoints = new HashSet<>();
        String sourceFileName = Constant.SOURCE_FILE_NAME;

        try {
            String configFileInfo = FileUtils.readFileToString(new File(sourceFileName), "UTF-8");
            Gson gson = new Gson();
            JsonArray array = gson.fromJson(configFileInfo, JsonArray.class);
            for (JsonElement element : array) {
                JsonObject object = element.getAsJsonObject();
                customizeEntryPoints.add(object.get("method").getAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customizeEntryPoints;
    }

    public List<SootMethod> getEntryPoints() {
        return entryPoints;
    }
}
