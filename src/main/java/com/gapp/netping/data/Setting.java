package com.gapp.netping.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gapp.netping.data.structure.Params;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Setting {

  private final ObjectMapper objectMapper;
  private final File objectFile;
  private final TypeReference<Params> structureMapper;
  
  private Params data;

  public Setting() {
    this.objectMapper = new ObjectMapper();
    this.objectFile = new File("setting.json");
    this.structureMapper = new TypeReference<Params>() {};
  }

  public Setting compile() throws IOException {
    this.data = this.objectMapper.readValue(this.objectFile, this.structureMapper);
    return this;
  }

  public Params getData() {
    return this.data;
  }
}
