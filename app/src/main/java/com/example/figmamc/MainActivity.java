package com.example.figmamc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputLayout etPhone = findViewById(R.id.til_phone_main);
        TextInputLayout etEmail = findViewById(R.id.til_email_main);
        TextInputLayout etInfo = findViewById(R.id.til_info_main);
        MaterialToolbar toolbar = (MaterialToolbar) findViewById(R.id.mtb_main);
        toolbar.setTitle("Имя");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.edit:
                        item.setEnabled(false);
                        FloatingActionButton button = new FloatingActionButton(MainActivity.this);
                        CoordinatorLayout layout = findViewById(R.id.coordinatorLayout_main);
                        CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params.setAnchorId(R.id.til_info_main);
                        button.setTranslationY(200);
                        button.setImageResource(R.drawable.ready_icon);
                        params.anchorGravity = GravityCompat.END | Gravity.BOTTOM;
                        layout.addView(button, params);
                        etPhone.setBoxStrokeWidth(5);
                        etEmail.setBoxStrokeWidth(5);
                        etInfo.setBoxStrokeWidth(5);
                        etPhone.setEnabled(true);
                        etEmail.setEnabled(true);
                        etInfo.setEnabled(true);
                        etPhone.requestFocus();
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                etPhone.setEnabled(false);
                                etEmail.setEnabled(false);
                                etInfo.setEnabled(false);
                                etPhone.setBoxStrokeWidth(0);
                                etEmail.setBoxStrokeWidth(0);
                                etInfo.setBoxStrokeWidth(0);
                                item.setEnabled(true);
                                layout.removeView(button);
                            }
                        });
                        break;
                    case R.id.exit:
                        Toast.makeText(MainActivity.this, "EXIT", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}