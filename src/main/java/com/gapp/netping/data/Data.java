package com.gapp.netping.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gapp.netping.data.structure.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Data {

  private final ObjectMapper objectMapper;
  private final InputStream objectFile;
  private final TypeReference<Map<String, Map<String, Constants>>> structureMapper;
  
  private Map<String, Map<String, Constants>> data;

  public Data() {
    this.objectMapper = new ObjectMapper();
    this.objectFile = Data.class.getClassLoader().getResourceAsStream("command.json");
    this.structureMapper = new TypeReference<Map<String, Map<String, Constants>>>() {};
  }

  public Data compile() throws IOException {
    this.data = this.objectMapper.readValue(this.objectFile, this.structureMapper);
    return this;
  }

  public Map<String, Map<String, Constants>> getData() {
    return this.data;
  }
  
  public Constants getData(String languaje, String system) {
    return this.data.get(languaje).get(system);
  }
}
