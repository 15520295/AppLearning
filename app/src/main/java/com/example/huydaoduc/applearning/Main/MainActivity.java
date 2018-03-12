package com.example.huydaoduc.applearning.Main;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.huydaoduc.applearning.Adapter.WordAdapter;
import com.example.huydaoduc.applearning.Model.Word;
import com.example.huydaoduc.applearning.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    String DATABASE_NAME="WordData.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    public static SQLiteDatabase database=null;

    ListView lvWord;
    static List<Word> dsWords = new ArrayList<>();

    //public static WordAdapter adapterWords;
    public static WordAdapter adapterWords;

    private Word word;


    public static final String TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //
        xuLySaoChepCSDLTuAssetsVaoHeThongMobile();
        addControls();
        xuLyHienThiWord();
    }

    private void xuLyHienThiWord() {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("select * from WordDatabase", null);
//        Cursor cursor=database.query("Word",null,null,null,null,null,null);
        dsWords.clear();
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            String mota = cursor.getString(2);
            String theLoai = cursor.getString(3);
            byte[] image = cursor.getBlob(4);
            byte[] sound = cursor.getBlob(5);

            Word word = new Word();
            word.setId(id);
            word.setTen(ten);
            word.setMota(mota);
            word.setImage(image);
            word.setSound(sound);
            word.setTheLoai(theLoai);
            dsWords.add(word);
        }
        cursor.close();
        adapterWords.notifyDataSetChanged();
    }

    private void addControls() {
        lvWord= (ListView) findViewById(R.id.lvWord);
        //adapterWords = new WordAdapter(this,R.layout.dong_word,dsWords);
        adapterWords = new WordAdapter(this,R.layout.dong_word,dsWords);
        lvWord.setAdapter(adapterWords);


    }

    private void xuLySaoChepCSDLTuAssetsVaoHeThongMobile() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists())
        {
            try
            {
                CopyDataBaseFromAsset();
                Toast.makeText(this, "Sao chép CSDL vào hệ thống thành công", Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(this, "Đã có Data", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void CopyDataBaseFromAsset() {
        try
        {
            //myInput: cơ sở dữ liệu lấy từ assets
            InputStream myInput=getAssets().open(DATABASE_NAME);
            String outFileName = layDuongDanLuuTru();
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!f.exists())//kiểm tra database có chưa nếu có rồi ko tạo nữa
            {
                f.mkdir();
            }
            //myOutput: nơi truyền database từ Input để sử dụng
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length; //lấy toàn bộ data (có hay ko cũng đc)
            while ((length = myInput.read(buffer)) > 0)
            {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
        catch (Exception ex)
        {
            Log.e("Loi_SaoChep",ex.toString());
        }
    }

    private String layDuongDanLuuTru() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
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
        if (id == R.id.action_setting) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.about) {

        } else if (id == R.id.game) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
