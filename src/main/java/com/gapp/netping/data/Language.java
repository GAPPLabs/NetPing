package com.gapp.netping.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gapp.netping.data.listener.ListenerData;
import com.gapp.netping.data.structure.Text;
import com.gapp.netping.data.util.Common;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


public class Language extends Common {

  private static final String IDENTIDY = "Language";
  private static final String FILE = "data/language.json";
  
  private Map<String, Text> data;
  
  public Language(ListenerData listener) {
    super(Language.FILE, Language.IDENTIDY);
    super.prepare(listener);
  }

  public Language readData() throws IOException {
    this.data = super.readDataClass(new TypeReference<Map<String, Text>>() {});
    return this;
  }

  public Map<String, Text> getData() {
    return this.data;
  }
  
  public Text getData(String language) {
    return this.data.get(language);
  }
  
  public Set<String> getLanguages() {
    return this.data.keySet();
  }
  
  public void saveData () throws IOException {
    super.saveData(this.data);
  }
}