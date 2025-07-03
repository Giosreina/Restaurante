package com.example.Patrones.Iterator;

public abstract class Iterator {
    public abstract void primero();
    public abstract void siguiente();
    public abstract boolean haTerminado();
    public abstract Object actual();
    public abstract int getPosicion();
}
