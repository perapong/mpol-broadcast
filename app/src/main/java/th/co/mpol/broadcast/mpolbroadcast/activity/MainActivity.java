package th.co.mpol.broadcast.mpolbroadcast.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import th.co.mpol.broadcast.mpolbroadcast.R;
import th.co.mpol.broadcast.mpolbroadcast.fragment.HomeFragment;
import th.co.mpol.broadcast.mpolbroadcast.fragment.NingNongFragment;
import th.co.mpol.broadcast.mpolbroadcast.fragment.YupinFragment;

public class MainActivity extends AppCompatActivity {
    private static MainActivity mSingleton;
    private HomeFragment mHomeFragment;
    private YupinFragment mYupinFragment;
    private NingNongFragment mNingNongFragment;
    private static final String TAG_MAIN_FRAGMENT = "tag_main_fragment";
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flMain,
                                    mHomeFragment,
                                    TAG_MAIN_FRAGMENT)
                            .commit();

//                    onBackPressedListener = null;

                    return true;
                case R.id.menu_yupin:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flMain,
                                    mYupinFragment,
                                    TAG_MAIN_FRAGMENT)
                            .commit();
                    return true;
                case R.id.menu_ningnong:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flMain,
                                    mNingNongFragment,
                                    TAG_MAIN_FRAGMENT)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    public static MainActivity getInstance() {
        return mSingleton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHomeFragment = new HomeFragment();
        mYupinFragment = new YupinFragment();
        mNingNongFragment = new NingNongFragment();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onSendBroadcast(String broadcastPackage, String broadcastIndex, String broadcastData) {
        Intent intnet = new Intent(broadcastPackage);
        intnet.putExtra(broadcastIndex, broadcastData);
        sendBroadcast(intnet);
    }
}
