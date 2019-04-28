package com.example.dj_fit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity
{
    private FirebaseAuth mAuth;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            //Logs the user out of the application
            case R.id.action_signOut:
                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                Toast.makeText(this, "User has signed out", Toast.LENGTH_SHORT).show();
                Intent loginAct = new Intent(this, LoginActivity.class);
                startActivity(loginAct);
                return true;
            case R.id.action_mainMenu:
                Intent mainAct = new Intent(this, MainActivity.class);
                startActivity(mainAct);
                return true;
            //Displays a small about message
            case R.id.action_about:
                AlertDialog aboutDialog = new AlertDialog.Builder(this).create();
                aboutDialog.setTitle("About DJ FIT");
                aboutDialog.setMessage("Application is being developed by Matthew Cook");
                aboutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                aboutDialog.show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
