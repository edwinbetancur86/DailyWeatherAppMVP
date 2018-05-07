package com.example.edwinb.agiletrailblazers;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.edwinb.agiletrailblazers.Configuration.DataFacade;
import com.example.edwinb.agiletrailblazers.Dagger.App;
import com.example.edwinb.agiletrailblazers.Util.MotherUtility;

import javax.inject.Inject;

/**
 * Base Activity for all activities to extend from within the DMW application.
 * <p>
 * Subclass Activities should call setContentView from this class and populate the main content
 * frame.  Subclasses will also override a LayoutConfig function which should provide a LayoutConfig
 * object which allows for customizations within this base class (if the toolbar is shown, page title).
 * <p>
 * This class will hide/show the Bottom Navigation bar based on the activity's parent relationship
 * as defined in the manifest.
 * - shown if no parent
 * - hidden if has parent
 */
public abstract class MotherActivity extends AppCompatActivity {

    private final String TAG = "MotherActivity";
    @Inject protected DataFacade dataFacade;
    //@Inject protected CacheManager cacheManager;
    @Inject
    protected MotherUtility motherUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getComponent().inject(this);
    }


    /**
     * Populates the main frame of the activity using a layout resource
     * Provided for setting the layout of an activity based on its resource ID
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    /**
     * Populates the main frame of the activity using a view
     */
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }


    /**
     * Override behavior of up button to animate transition
     * https://stackoverflow.com/questions/20728999/custom-up-navigation-animation
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = true;
        switch (item.getItemId()) {
            case android.R.id.home://Up Button
                handleUpButtonSelection();
                break;
            default:
                result = super.onOptionsItemSelected(item);
        }
        return result;
    }

    /**
     * Handle navigate up intent and notify DmwTransitionHandler to handle a back transition.
     */
    private void handleUpButtonSelection() {
        //TODO: these next 2 lines seem to cause the activity returned to to scroll to the top of the page rather than resuming in the previous scroll point.
        Intent upIntent = NavUtils.getParentActivityIntent(this);
        NavUtils.navigateUpTo(this, upIntent);
        finish();
    }


}

