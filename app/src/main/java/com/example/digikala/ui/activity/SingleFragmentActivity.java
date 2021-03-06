package com.example.digikala.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.digikala.R;
import com.example.digikala.databinding.ActivitySingleFragmentBinding;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    private ActivitySingleFragmentBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_single_fragment);

//        NavHostFragment navHostFragment ;
//        navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(mBinding.navHostFragmentContainer.getId());
//        NavigationUI.setupWithNavController(mBinding.bottomNav,navHostFragment.getNavController());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);
        mBinding.bottomNav.setSelectedItemId(R.id.nav_host_fragment_container);
        NavigationUI.setupWithNavController(mBinding.bottomNav, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.nav_searchFragment) {
                    mBinding.bottomNav.setVisibility(View.GONE);
                }else mBinding.bottomNav.setVisibility(View.VISIBLE);
            }
        });
    }
}
