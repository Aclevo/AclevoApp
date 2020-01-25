package xyz.aclevo.androidapp;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment hf = new HomeFragment();
                    transaction.replace(R.id.fragment_container, hf);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.navigation_blog:
                    BlogFragment bf = new BlogFragment();
                    transaction.replace(R.id.fragment_container, bf);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.navigation_forums:
                    ForumFragment ff = new ForumFragment();
                    transaction.replace(R.id.fragment_container, ff);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.navigation_more:
                    MoreFragment mf = new MoreFragment();
                    transaction.replace(R.id.fragment_container, mf);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            HomeFragment firstFragment = new HomeFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
