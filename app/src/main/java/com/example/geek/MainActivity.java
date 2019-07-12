package com.example.geek;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.geek.base.BaseActivity;
import com.example.geek.fragment.AboutFragment;
import com.example.geek.fragment.CollectionFragment;
import com.example.geek.fragment.GankFragment;
import com.example.geek.fragment.GoldFragment;
import com.example.geek.fragment.SettingFragment;
import com.example.geek.fragment.V2exFragment;
import com.example.geek.fragment.WechatFragment;
import com.example.geek.fragment.ZhihuFragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

//李开新  1811A
public class MainActivity extends BaseActivity{
    private FrameLayout frame;
    private NavigationView nv;
    private Toolbar tb;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;
    private FragmentManager manager;
    private int lastPosition;
    private MenuItem firstItem;
    private DrawerLayout dl;
    private MaterialSearchView search;
    private static final String TAG = "MainActivity";
    private MenuItem searchItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }


    private void initListener() {

    }

    private void initView() {
        manager = getSupportFragmentManager();
        frame = (FrameLayout) findViewById(R.id.frame);
        dl = (DrawerLayout) findViewById(R.id.dl);

        nv = (NavigationView) findViewById(R.id.nv);
        firstItem = nv.getMenu().findItem(R.id.drawer_zhihu);

        tb = (Toolbar) findViewById(R.id.tb);
        tb.setTitle(R.string.zhihu);
        setSupportActionBar(tb);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl, tb, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        actionBarDrawerToggle.syncState();
        dl.addDrawerListener(actionBarDrawerToggle);


        initFragments();
        initTitles();


        switchFragment(0);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()== R.id.drawer_gank | menuItem.getItemId() == R.id.drawer_wechat){
                    searchItem.setVisible(true);
                }else{
                    searchItem.setVisible(false);
                }
                switch (menuItem.getItemId()) {
                    case R.id.drawer_zhihu:
                        switchFragment(0);
                        break;

                    case R.id.drawer_wechat:
                        switchFragment(1);
                        break;
                    case R.id.drawer_gank:
                        switchFragment(2);
                        break;
                    case R.id.drawer_gold:
                        switchFragment(3);
                        break;
                    case R.id.drawer_vtex:
                        switchFragment(4);
                        break;
                    case R.id.drawer_like:
                        switchFragment(5);
                        break;
                    case R.id.drawer_setting:
                        switchFragment(6);
                        break;
                    case R.id.drawer_about:
                        switchFragment(7);
                        break;
                }

                if (firstItem != null) {
                    firstItem.setChecked(false);
                }
                menuItem.setChecked(true);
                firstItem = menuItem;
                dl.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
        search = (MaterialSearchView) findViewById(R.id.search);
        search.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "onQueryTextSubmit: " + query);
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "");
        searchItem = menu.findItem(1);
        searchItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        searchItem.setIcon(R.drawable.ic_action_action_search);
        searchItem.setVisible(false);
        //跟搜索框绑定
        search.setMenuItem(searchItem);
        return super.onCreateOptionsMenu(menu);
    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(R.string.zhihu);
        titles.add(R.string.wechat);
        titles.add(R.string.gank);
        titles.add(R.string.gold);
        titles.add(R.string.vtex);
        titles.add(R.string.drawer_collection);
        titles.add(R.string.drawer_setting);
        titles.add(R.string.drawer_about);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new ZhihuFragment());
        fragments.add(new WechatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new V2exFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new SettingFragment());
        fragments.add(new AboutFragment());
    }

    private void switchFragment(int type) {
        Fragment fragment = fragments.get(type);
        Fragment lastFragment = fragments.get(lastPosition);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.frame, fragment);
        }
        transaction.hide(lastFragment);
        transaction.show(fragment);
        transaction.commit();
        tb.setTitle(titles.get(type));
        lastPosition = type;


    }


}
