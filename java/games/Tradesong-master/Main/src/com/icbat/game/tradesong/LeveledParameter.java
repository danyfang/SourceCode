package com.icbat.game.tradesong;

/** Very basic data structure to universalize parameters (originally gather/craft speed) */
public class LeveledParameter {
    private int level = 0;
    private int maxLevel = 3;
    private float currentValue;
    private String parameterName;

    public LeveledParameter(String parameterName, float currentValue) {
        this.currentValue = currentValue;
        this.parameterName = parameterName;
    }

    public LeveledParameter(String parameterName, float currentValue, int level, int maxLevel ) {
        this.level = level;
        this.maxLevel = maxLevel;
        this.currentValue = currentValue;
        this.parameterName = parameterName;
    }

    public float getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(float currentValue) {
        this.currentValue = currentValue;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public String getParameterName() {
        return parameterName;
    }
}
