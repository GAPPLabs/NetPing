package com.gapp.netping.data.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gapp.netping.data.listener.ListenerData;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public abstract class Common {
  
  private final String file;
  private final String identify;
  
  private ObjectMapper objectMapper;
  private File objectFile;
  private ListenerData listener;

  public Common(String file, String identify) {
    this.file = file;
    this.identify = identify;
  }
  
  public void prepare(ListenerData listener) {
    this.listener = listener;
    this.objectMapper = new ObjectMapper();
    this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    this.objectFile = new File(this.file);
  }
  
  public <T> T readDataClass(TypeReference<?> reference) throws IOException {
    return (T) this.objectMapper.readValue(this.objectFile, reference);
  }
  
  public <K, V> Map<K, V> readDataMap(TypeReference<?> reference) throws IOException {
    return (Map<K, V>) this.objectMapper.readValue(this.objectFile, reference);
  }
  
  public <T> void saveData(T data) throws IOException {
    this.objectMapper.writeValue(this.objectFile, data);
    propagateEvent();
  }
  
  private void propagateEvent() {
    this.listener.saveData(this.identify);
  }
}
