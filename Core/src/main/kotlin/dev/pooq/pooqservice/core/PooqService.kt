package dev.pooq.pooqservice.core

import dev.pooq.pooqservice.core.constants.Constants
import dev.pooq.pooqservice.core.yaml.configuration.file.YamlConfiguration
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class PooqService {

  fun config() : YamlConfiguration{
    val file = File(Constants.CONFIG)
    val config: YamlConfiguration

    if(!file.exists()){
      Files.createFile(Path.of(Constants.CONFIG))

      val defaultConfig = YamlConfiguration.loadConfiguration(javaClass.getResourceAsStream("config.ps"))
      config = YamlConfiguration.loadConfiguration(file)

      for(s in defaultConfig.getKeys(false)){
        config.set(s, defaultConfig.get(s))
      }

      config.save(file)
    }

    return YamlConfiguration.loadConfiguration(file)
  }
}