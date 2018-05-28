package com.github.pyro2266.lightit.led.modes;

import com.github.mbelling.ws281x.Color;
import com.github.pyro2266.lightit.led.LedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleRainbowMode implements LedMode {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleRainbowMode.class);
    private static final String MODE_ID = "Rainbow";
    private static final int MAX_HUE = 1;

    private float step = 0.001f;
    private float hue = 0;
    private float saturation = 1;
    private float value = 1;

    @Override
    public String getModeId() {
        return MODE_ID;
    }

    @Override
    public Color[] getNextColors(Color[] previousColors) {
        Color[] newColors = new Color[LedService.LED_COUNT];
        for (int i = 0; i < newColors.length; i++) {
            newColors[i] = new Color(java.awt.Color.getHSBColor(hue, saturation, value).getRGB());
        }
        hue = hue % MAX_HUE + step;
        return newColors;
    }

    public float getStep() {
        return step;
    }

    public void setStep(float step) {
        this.step = step;
    }

    public float getHue() {
        return hue;
    }

    public void setHue(float hue) {
        this.hue = hue;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
