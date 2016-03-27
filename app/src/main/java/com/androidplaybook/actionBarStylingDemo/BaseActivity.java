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
 * 1. Activity called "MainActivity" extends BaseActivity:
 * ==> MainActivity will have to implement abstract method @see #getLayoutResource() - assuming
 *     MainActivity is non-abstract.
 *
 * 2. In MainActivity onCreate(Bundle savedInstanceState), simply call super.onCreate(savedInstanceState):
 * ==> BaseActivity calls setContentView(getLayoutResource()), which handles layout inflation, and
 *     resolves the toolbar instance (and actionBar).
 *
 * 3. MainActivity can call relevant toolbar methods such as adding an icon, changing text, home/back icon etc
 *
 * NOTE: Toolbar in layout file must have android:id="+@id/toolbar".
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

        // Handle layout inflation for subclasses
        setContentView(getLayoutResource());

        // Find the toolbar view inside the activity layout
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

    /**
     * Show logo and resolve left inset spacing.
     *
     * @param drawable Drawable resource to set as the app icon
     */
    protected void setToolbarAppIcon(@DrawableRes int drawable){
        // Display icon in the toolbar
        if(actionBar != null) {
            // Remove the (default) left inset margin that pushes the icon over too far to the left.
            toolbar.setContentInsetsAbsolute(0, 8);
            actionBar.setLogo(drawable);
            actionBar.setDisplayUseLogoEnabled(true);
        }
    }

    /**
     * Delegate for setting the background color for the toolbar.
     *
     * @param color Color resource
     */
    protected void setToolbarBackgroundColor(@ColorRes int color){
        toolbar.setBackgroundColor(getResources().getColor(color));
    }

    /**
     * Delegate for setting the overflow icon
     *
     * @param overflowIcon Drawable resource to use as the overflow icon
     */
    protected void setOverflowIcon(@DrawableRes int overflowIcon){
        toolbar.setOverflowIcon(getResources().getDrawable(overflowIcon));
    }
}
