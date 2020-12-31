package com.bknower.deathban.capabilities;

public class BanTime implements IBanTime {
    private float time;

    @Override
    public void set(float time) {
        this.time = time;
    }

    @Override
    public float get() {
        return this.time;
    }
}
