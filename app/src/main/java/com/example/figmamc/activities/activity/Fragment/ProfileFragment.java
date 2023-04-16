package com.example.figmamc.activities.activity.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.example.figmamc.R;
import com.example.figmamc.databinding.MenuProfileFragmentBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class ProfileFragment extends Fragment {
    MenuProfileFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MenuProfileFragmentBinding.inflate(inflater);
        TextInputLayout etPhone = binding.getRoot().findViewById(R.id.til_phone_main);
        binding.mtbMain.setTitle("Имя");
        binding.ava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.mtbMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "back", Toast.LENGTH_SHORT).show();
            }
        });
        binding.mtbMain.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.edit:
                        item.setEnabled(false);
                        FloatingActionButton button = new FloatingActionButton(getActivity());
                        CoordinatorLayout layout = binding.getRoot().findViewById(R.id.coordinatorLayout_main);
                        CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        button.setTranslationY(200);
                        button.setImageResource(R.drawable.ready_icon);
                        params.anchorGravity = GravityCompat.END | Gravity.BOTTOM;
                        layout.addView(button, params);
                        etPhone.setBoxStrokeWidth(5);

                        etPhone.setEnabled(true);

                        etPhone.requestFocus();
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                etPhone.setEnabled(false);

                                etPhone.setBoxStrokeWidth(0);

                                item.setEnabled(true);
                                layout.removeView(button);
                            }
                        });
                        break;
                    case R.id.exit:
                        Toast.makeText(getActivity(), "EXIT", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return binding.getRoot();
    }
}
