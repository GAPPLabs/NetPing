package com.gapp.netping.core;

import com.gapp.netping.core.util.Request;
import com.gapp.netping.data.structure.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Command {

  private final Constants constant;
  private final String [] metrics;

  public Command(Constants constant, String [] metrics) {
    this.constant = constant;
    this.metrics = metrics;
  }

  private String generateCommand(String host, int shipments, String extra) {
    return String.format("%s %s %s %s %s", this.constant.getCommand(), host, this.constant.getShipment(), shipments, extra);
  }

  public Request isReachable(String host, int shipments, String extra) throws IOException {
    String execCommand = this.generateCommand(host, shipments, extra);
    Process process = Runtime.getRuntime().exec(execCommand);
    try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String output = inputStream.lines().collect(Collectors.joining("\n"));
      inputStream.close();
      Map<String, Double> data = this.getData(output, shipments);
      if (data != null) data = this.getMetricData(data);
      return new Request(execCommand, data != null, data);
    }
  }

  private Map<String, Double> getData(String output, int shipments) {
    Map<String, Collection<Float>> data = new LinkedHashMap<>();

    for (Map.Entry<String, String> entry : this.constant.getRegex().getRegexs().entrySet()) {
      data.put(entry.getKey(), new ArrayList<>());
      Matcher matcher = Pattern.compile(entry.getValue()).matcher(output);
      while (matcher.find()) {
        data.get(entry.getKey()).add(Float.valueOf(matcher.group(1)));
      }
      if (data.get(entry.getKey()).isEmpty()) {
        return null;
      }
    }
    
    return new LinkedHashMap<String, Double>() {{
      for (Map.Entry<String, Collection<Float>> entry : data.entrySet()) {
        put("min_" + entry.getKey(), (double) Collections.min(entry.getValue()));
        put("mean_" + entry.getKey(), entry.getValue().stream().mapToDouble(Float::doubleValue).average().orElse(0.0));
        put("max_" + entry.getKey(), (double) Collections.max(entry.getValue()));
        put("loss_" + entry.getKey(), (1d - (entry.getValue().size() / (double) shipments)) * 100);
      }
    }};
  }
  
  private Map<String, Double> getMetricData(Map<String, Double> data) {
    return data.entrySet().stream().filter(entry ->  Arrays.asList(this.metrics).contains(entry.getKey()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}