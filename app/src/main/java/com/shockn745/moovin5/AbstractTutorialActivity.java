package com.shockn745.moovin5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * This class factor functions related to the tutorial mode at first launch of the application
 *
 * @author Kempenich Florian
 */
public abstract class AbstractTutorialActivity extends AppCompatActivity {

    private boolean inTutorialMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.contains(getString(R.string.pref_tutorial_key))) {
            // Init
            inTutorialMode = prefs.getBoolean(getString(R.string.pref_tutorial_key), true);
        } else {
            // Save the default value to the preferences
            inTutorialMode = true;
            prefs.edit()
                    .putBoolean(getString(R.string.pref_tutorial_key), inTutorialMode)
                    .apply();
        }

    }

    /**
     * @return true is in tutorial mode
     */
    protected boolean isInTutorialMode() {
        return inTutorialMode;
    }

    /**
     * Block back key if in tutorial mode
     */
    @Override
    public void onBackPressed() {
        if (!inTutorialMode) {
            super.onBackPressed();
        }
    }
}
