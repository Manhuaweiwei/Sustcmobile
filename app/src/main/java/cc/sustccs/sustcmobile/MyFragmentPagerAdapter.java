package cc.sustccs.sustcmobile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by ranmanli on 2017/5/25.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private RestaurantFragment restaurantFragment = null;
    private BoxFragment boxFragment = null;
    private NotificationFragment notificationFragment = null;
    private ExploreFragment exploreFragment = null;

    public MyFragmentPagerAdapter(FragmentManager fm){
        super(fm);
        restaurantFragment = new RestaurantFragment();
        boxFragment = new BoxFragment();
        notificationFragment = new NotificationFragment();
        exploreFragment = new ExploreFragment();
    }

    @Override
    public int getCount(){
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position){
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position){
        Fragment fragment = null;
        switch (position){
            case MainActivity.PAGE_ONE:
                fragment = restaurantFragment;
                break;
            case MainActivity.PAGE_TWO:
                fragment = boxFragment;
                break;
            case MainActivity.PAGE_THREE:
                fragment = notificationFragment;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = exploreFragment;
                break;
        }
        return fragment;
    }

}
