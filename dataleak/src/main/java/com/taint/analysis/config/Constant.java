package com.taint.analysis.config;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;

/**
 * Constant
 */
public class Constant {

  private static final String CONFIG_FILE_NAME = Constant.class.getClassLoader().getResource("config.json").getPath();
  public static  String SOURCE_FILE_NAME ;
  public static  String MAIN_CLASS;
  public static  String EDGE_CONFIG_PROPERTIES;
  public static void loadConstant() throws IOException {
    String configFileInfo = FileUtils.readFileToString(new File(CONFIG_FILE_NAME), "UTF-8");
    Gson gson = new Gson();
    HashMap<String, String> map =  gson.fromJson(configFileInfo, HashMap.class);

    SOURCE_FILE_NAME = map.get("source");
    MAIN_CLASS = map.get("main_class");
    EDGE_CONFIG_PROPERTIES = map.get("edge_config");
  }
}
