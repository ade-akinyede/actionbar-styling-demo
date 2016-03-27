package com.androidplaybook.actionBarStylingDemo;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.androidplaybook.showcasedemo.R;

/**
 * Classes that extend BaseActivity should have a Toolbar in their layout and do not need
 * to call setContentView() in their onCreate() method.
 *
 * Example usage & flow:
 *
 * 1. Activity called "MainActivity" extends BaseActivity.
 * 2. MainActivity will have to implement abstract method @see #getLayoutResource()
 * 2. In MainActivity onCreate(Bundle savedInstanceState), simply call super.onCreate(savedInstanceState).
 *
 *
 * with id "toolbar" i.e. android:id="+@id/toolbar".
 *
 * This class will
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     *
     * Non-abstract sub classes should return their layout resource file with a Toolbar,
     * where android:id="+@id/toolbar".
     *
     * @return Layout Resource file e.g. R.layout.activity_main.
     */
    protected abstract @LayoutRes int getLayoutResource();

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Subclasses MUST have returned a valid layout file for this to work
        setContentView(getLayoutResource());

        // Find the toolbar view inside the activity layout;
        // Make sure the toolbar exists in the activity and is not null
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            // Sets the Toolbar to act as the ActionBar for this Activity window.
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
            if(actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(false);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Delegate for setting the title on the action bar.
     *
     * @param title String
     */
    protected void setActionBarTitle(@NonNull String title){
        if(actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    /**
     * Delegate for setting the back button's visibility and action on the action bar.
     *
     * @param enabled true displays the back button, false does otherwise.
     */
    protected void setActionBarBackButton(boolean enabled){
        if(actionBar != null) {
            // This shows the back arrow button
            actionBar.setDisplayHomeAsUpEnabled(enabled);
            // This sets the "back" action of the back arrow button
            actionBar.setHomeButtonEnabled(enabled);
        }
    }

    protected void setToolbarAppIcon(@DrawableRes int drawable){
        // Display icon in the toolbar
        if(actionBar != null) {
            // Remove the (default) left inset margin that pushes the icon over too far to the left.
            toolbar.setContentInsetsAbsolute(0, 8);
            actionBar.setLogo(drawable);
            actionBar.setDisplayUseLogoEnabled(true);
        }
    }

    protected void setToolbarBackgroundColor(@ColorRes int color){
        toolbar.setBackgroundColor(getResources().getColor(color));
    }

    protected void setOverflowIcon(@DrawableRes int overflowIcon){
        toolbar.setOverflowIcon(getResources().getDrawable(overflowIcon));
    }

    /**
     * Opens the settings activity
     */
    protected void openSettings() {

//        Intent intent = new Intent(this, SMMainSettingsActivity.class);
//        startActivityForResult(intent, SMConstants.SETTINGS_ACTIVITY_REQUEST_CODE);
    }
}
