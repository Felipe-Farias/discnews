package cl.ucn.disc.dsm.ffarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

/**
 * The main class.
 * @author Felipe Farias-Espinoza.
 */
public class MainActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState The instance.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TheNews", "onCreate !!");

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("TheNews", "onStart !!!");
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d("TheNews", "onResume !!!");
    }
}