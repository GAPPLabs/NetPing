package com.gapp.netping.alert.system;

import com.gapp.netping.data.structure.Params;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.InputStream;

public class Sound {
  
  private final Params setting;
  private InputStream file;

  public Sound(Params setting) {
    this.setting = setting;
  }
  
  public Sound compile() throws FileNotFoundException {
    this.file = new FileInputStream(this.setting.getPathSound());
    return this;
  }
  
  public void playSound() throws JavaLayerException, IOException {
    Player player = new Player(this.file);
    player.play();
    player.close();
  }
}
