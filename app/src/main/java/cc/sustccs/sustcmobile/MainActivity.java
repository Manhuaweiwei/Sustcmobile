package cc.sustccs.sustcmobile;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

		//UI Objects
    private RadioGroup bottom_menu;
    private RadioButton restaurant_btn_normal;
    private RadioButton box_btn_normal;
    private RadioButton notification_btn_normal;
    private RadioButton explore_btn_normal;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;
//	private FragmentManager fragmentManager;

	//几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        //左拉框响应事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navItem1:
                        break;
                    case R.id.navItem2:
                        break;
                    case R.id.navItem3:
                        break;
                }
                return false;
            }
        });


		mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        restaurant_btn_normal.setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
	
	private void bindViews() {
        bottom_menu = (RadioGroup) findViewById(R.id.bottom_menu);
        restaurant_btn_normal = (RadioButton) findViewById(R.id.restaurant_btn_normal);
        box_btn_normal = (RadioButton) findViewById(R.id.box_btn_normal);
        notification_btn_normal = (RadioButton) findViewById(R.id.notification_btn_normal);
        explore_btn_normal = (RadioButton) findViewById(R.id.explore_btn_normal);
        bottom_menu.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }
	
	public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.restaurant_btn_normal:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.box_btn_normal:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.notification_btn_normal:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.explore_btn_normal:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }
	
	//重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    restaurant_btn_normal.setChecked(true);
                    break;
                case PAGE_TWO:
                    box_btn_normal.setChecked(true);
                    addClass();
                    break;
                case PAGE_THREE:
                    notification_btn_normal.setChecked(true);
                    break;
                case PAGE_FOUR:
                    explore_btn_normal.setChecked(true);
                    break;
            }
        }
    }

    public void addClass(){
        //监听button事件
//        box_btn_normal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text="算法设计基础@W3502";
//                BoxFragment boxFragment = (BoxFragment)getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.vpager + ":1");
//
//                Toast tot = Toast.makeText(
//                        MainActivity.this,
//                        "刷新课表",
//                        Toast.LENGTH_LONG);
//                tot.show();
//
//                boxFragment.addView(1,1,2,text);
//                boxFragment.addView(7,2,3,text);
//                boxFragment.addView(5,9,10,text);
//                boxFragment.addView(4,2,3,text);
//                boxFragment.addView(3,5,5,text);
//                boxFragment.addView(4,10,12,text);
//            }
//        });

    }
}
