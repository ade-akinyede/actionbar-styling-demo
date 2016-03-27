package com.androidplaybook.actionBarStylingDemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.androidplaybook.showcasedemo.R;

/**
 * Created by Ade on 3/27/2016.
 */
public class ChildActivity extends BaseActivity {
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_child;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setActionBarTitle("Main");
        setActionBarBackButton(true);
        setOverflowIcon(R.drawable.ic_action_add);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_child, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_github_link) {
            launchGithubSourceRepo();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchGithubSourceRepo(){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ade-akinyede/actionbar-styling-demo.git"));
        startActivity(i);
    }

}
