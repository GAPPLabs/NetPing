package com.gapp.netping.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gapp.netping.data.structure.Connection;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Host {

  private final ObjectMapper objectMapper;
  private final File objectFile;
  private final TypeReference<Map<String, Connection>> structureMapper;

  private Map<String, Connection> data;

  public Host() {
    this.objectMapper = new ObjectMapper();
    this.objectFile = new File("connection.json");
    this.structureMapper = new TypeReference<Map<String, Connection>>() {
    };
  }

  public Host compile() throws IOException {
    this.data = this.objectMapper.readValue(this.objectFile, this.structureMapper);
    return this;
  }

  public Map<String, Connection> getData() {
    return this.data;
  }
}
