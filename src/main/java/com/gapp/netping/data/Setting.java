package com.gapp.netping.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gapp.netping.data.listener.ListenerData;
import com.gapp.netping.data.structure.Params;
import com.gapp.netping.data.util.Common;
import java.io.IOException;

public class Setting extends Common {

  private static final String IDENTIDY = "Setting";
  private static final String FILE = "data/setting.json";
  private Params data;
  
  public Setting(ListenerData listener) {
    super(Setting.FILE, Setting.IDENTIDY);
    super.prepare(listener);
  }

  public Setting readData() throws IOException {
    this.data = super.readDataClass(new TypeReference<Params>() {});
    return this;
  }

  public Params getData() {
    return this.data;
  }

  public void saveData () throws IOException {
    super.saveData(this.data);
  }
}
