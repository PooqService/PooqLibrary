package dev.pooq.pooqservice.core.constants;

import java.io.File;

public class Constants {

  public static final String VERSION = "1.0-BETA";

  public static final String PARENT = "/pooqservice/";
  public static final File PARENT_FILE = new File(PARENT);

  public static final String CONFIG = PARENT + "config/config.ps";
  public static final File CONFIG_FILE = new File(CONFIG);
}
