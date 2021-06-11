/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * The Main App
 */
public final class App extends Application {


    /**
     * Initialize the Application.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
