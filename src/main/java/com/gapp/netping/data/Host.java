package com.gapp.netping.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gapp.netping.data.listener.ListenerData;
import com.gapp.netping.data.structure.Connection;
import com.gapp.netping.data.util.Common;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Host extends Common {

  private static final String IDENTIDY = "Host";
  private static final String FILE = "data/connection.json";
  
  private Map<String, Connection> data;
  
  public Host(ListenerData listener) {
    super(Host.FILE, Host.IDENTIDY);
    super.prepare(listener);
  }

  public Host readData() throws IOException {
    this.data = super.readDataClass(new TypeReference<Map<String, Connection>>() {});
    return this;
  }

  public Map<String, Connection> getData() {
    return this.data;
  }
  
  public Set<String> getHosts() {
    return this.data.keySet();
  }
  
  public void saveData () throws IOException {
    super.saveData(this.data);
  }
}