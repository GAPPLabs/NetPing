package com.gapp.netping.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gapp.netping.data.listener.ListenerData;
import com.gapp.netping.data.structure.Constants;
import com.gapp.netping.data.util.Common;
import java.io.IOException;
import java.util.Map;

public class Data extends Common {

  private static final String IDENTIDY = "Data";
  private static final String FILE = "data/command.json";
  
  private Map<String, Map<String, Constants>> data;
  
  public Data(ListenerData listener) {
    super(Data.FILE, Data.IDENTIDY);
    super.prepare(listener);
  }

  public Data readData() throws IOException {
    this.data = super.readDataClass(new TypeReference<Map<String, Map<String, Constants>>>() {});
    return this;
  }

  public Map<String, Map<String, Constants>> getData() {
    return this.data;
  }
  
  public Constants getData(String languaje, String system) {
    return this.data.get(languaje).get(system);
  }

  public void saveData () throws IOException {
    super.saveData(this.data);
  }
}
