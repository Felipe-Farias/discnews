package cl.ucn.disc.dsm.ffarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ucn.disc.dsm.ffarias.databinding.ActivityMainBinding;

/**
 * The main class.
 * @author Felipe Farias-Espinoza.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Logger
     */
    private static final Logger log = LoggerFactory.getLogger(MainActivity.class);

    /**
     * The Bindings
     */
     private ActivityMainBinding binding;


    /**
     *
     * @param savedInstanceState The instance.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Inflate the xml
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        // Set the toolbar
        this.setSupportActionBar(this.binding.toolbar);

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