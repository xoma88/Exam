package com.example.exam;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.exam.dataBase.ImageHandler;
import com.example.exam.dataBase.ImageIdHandler;
import com.example.exam.dataBase.UserHandler;
import com.example.exam.models.Image;
import com.example.exam.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    //UserHandler userHandler;
    //ImageHandler imageHandler;
    //ImageIdHandler imageIdHandler;

    //List<Image> images = new ArrayList<>();
    //заполнение картинок
  /*  {
        images.add(new Image(0, String.format("image_%s", 1), String.format("name_%s", 1), 0, String.format("description_%s", 1), "https://img1.goodfon.ru/wallpaper/nbig/e/d8/kuby-chernye-sinie-kubiki-3d.jpg"));
        images.add(new Image(1, String.format("image_%s", 2), String.format("name_%s", 1), 0, String.format("description_%s", 2), "https://i.pinimg.com/originals/16/81/53/16815372d03d148faca8203ccde9bc56.jpg"));
        images.add(new Image(2, String.format("image_%s", 3), String.format("name_%s", 1), 0, String.format("description_%s", 3), "https://storge.pic2.me/cm/2560x1440/317/5b85ae7451669.jpg"));
        images.add(new Image(3, String.format("image_%s", 4), String.format("name_%s", 1), 0, String.format("description_%s", 4), "https://storge.pic2.me/upload/496/5550a6708a4b3.jpg"));
        images.add(new Image(4, String.format("image_%s", 5), String.format("name_%s", 1), 0, String.format("description_%s", 5), "https://img1.goodfon.ru/wallpaper/big/b/95/kvadraty-cvet-otrazhenie.jpg"));

        images.add(new Image(5, String.format("image_%s", 6), String.format("name_%s", 2), 1, String.format("description_%s", 6), "https://i.pinimg.com/originals/65/60/da/6560da8bfab621f2cafefa171fbcd092.jpg"));
        images.add(new Image(6, String.format("image_%s", 7), String.format("name_%s", 2), 1, String.format("description_%s", 7), "https://img1.goodfon.ru/wallpaper/big/f/73/messier-42-tumannost-orion.jpg"));
        images.add(new Image(7, String.format("image_%s", 8), String.format("name_%s", 2), 1, String.format("description_%s", 8), "https://99px.ru/sstorage/53/2013/12/tmb_89172_1422.jpg"));
        images.add(new Image(8, String.format("image_%s", 9), String.format("name_%s", 2), 1, String.format("description_%s", 9), "https://oboinastol.net/katalog_kartinok/tom09/010/skachat_oboi_1280x1024.jpg"));
        images.add(new Image(9, String.format("image_%s", 10), String.format("name_%s", 2), 1, String.format("description_%s", 10), "https://img3.goodfon.ru/wallpaper/nbig/5/55/pacman-emissionnaya-tumannost.jpg"));

        images.add(new Image(10, String.format("image_%s", 11), String.format("name_%s", 3), 2, String.format("description_%s", 11), "https://img1.goodfon.ru/wallpaper/big/6/fb/bmw-chernyy-fary-siniy-svet.jpg"));
        images.add(new Image(11, String.format("image_%s", 12), String.format("name_%s", 3), 2, String.format("description_%s", 12), "https://99px.ru/sstorage/53/2013/10/tmb_83907_1450.jpg"));
        images.add(new Image(12, String.format("image_%s", 13), String.format("name_%s", 3), 2, String.format("description_%s", 13), "https://img3.goodfon.ru/wallpaper/big/4/10/reshetka-fary-bumer-siluet-1929.jpg"));
        images.add(new Image(13, String.format("image_%s", 14), String.format("name_%s", 3), 2, String.format("description_%s", 14), "https://pw.artfile.me/wallpaper/02-06-2018/650x407/avtomobili-fragmenty-avtomobilya-bmw-i8--1348905.jpg"));
        images.add(new Image(14, String.format("image_%s", 15), String.format("name_%s", 3), 2, String.format("description_%s", 15), "https://img2.goodfon.ru/wallpaper/nbig/5/91/bmv-bmw-mashina.jpg"));

        images.add(new Image(15, String.format("image_%s", 16), String.format("name_%s", 4), 3, String.format("description_%s", 16), "https://www.zastavki.com/pictures/originals/2014/_Gray_furniture_in_the_kitchen_091487_.jpg"));
        images.add(new Image(16, String.format("image_%s", 17), String.format("name_%s", 4), 3, String.format("description_%s", 17), "https://okuhne.net/wp-content/uploads/2015/11/kuxnya-v-seryx-tonax.jpg"));
        images.add(new Image(17, String.format("image_%s", 18), String.format("name_%s", 4), 3, String.format("description_%s", 18), "https://kitchen.cdnvideo.ru/wp-content/uploads/2015/07/seraya-kuxnya-v-interere.jpg"));
        images.add(new Image(18, String.format("image_%s", 19), String.format("name_%s", 4), 3, String.format("description_%s", 19), "https://mebellka.ru/wp-content/uploads/2020/03/Sovremennyj-stil-kuhni.jpg"));
        images.add(new Image(19, String.format("image_%s", 20), String.format("name_%s", 4), 3, String.format("description_%s", 20), "https://i.pinimg.com/originals/3b/ab/07/3bab078af7998c3bab7f4aa7e491b8c1.jpg"));

        images.add(new Image(20, String.format("image_%s", 21), String.format("name_%s", 5), 4, String.format("description_%s", 21), "https://99px.ru/sstorage/53/2013/07/tmb_75639_4291.jpg"));
        images.add(new Image(21, String.format("image_%s", 22), String.format("name_%s", 5), 4, String.format("description_%s", 22), "https://million-wallpapers.ru/wallpapers/6/40/471042666485597.jpg"));
        images.add(new Image(22, String.format("image_%s", 23), String.format("name_%s", 5), 4, String.format("description_%s", 23), "https://img3.goodfon.ru/wallpaper/nbig/8/3b/klen-vetka-listya-osennie-fon.jpg"));
        images.add(new Image(23, String.format("image_%s", 24), String.format("name_%s", 5), 4, String.format("description_%s", 24), "https://img2.goodfon.ru/wallpaper/big/4/ea/listya-osennie-fon-razmytost.jpg"));
        images.add(new Image(24, String.format("image_%s", 25), String.format("name_%s", 5), 4, String.format("description_%s", 25), "https://99px.ru/sstorage/53/2015/12/tmb_151278_3020.jpg"));
    }
*/
    //List<User> users = new ArrayList<>();
    //Integer[][] imageId = new Integer[5][5];
    //заполнение заполнение id картинок пользователю
  /*  {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int h = 0; h < 5; h++) {
                imageId[i][h] = count++;
            }
        }
    }
    */
    //заполнение пользователей
   /* {
        for (int i = 1; i < 6 ; i++) {
            users.add(new User(i - 1, String.format("name_%s", i), String.format("email_%s", i)
                    , imageId[i-1]
                    , String.format("login%s", i)
                    , String.format("psw%s", i)
                    , false));
        }
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //userHandler = new UserHandler(this);
        //imageHandler = new ImageHandler(this);
        //imageIdHandler = new ImageIdHandler(this);

        //запись в базу данных пользователей
        //for (int i = 0; i < users.size(); i++){
        //    userHandler.create(users.get(i));
        //}
        //запись в базу данных картинок
        //for (int i = 0; i < images.size(); i++){
        //    imageHandler.create(images.get(i));
        //}
        //запись в базу данных id картинок пользователей
        //for (int i = 0; i < imageId.length; i++){
        //    for (int h = 0; h < imageId[i].length; h++){
        //        imageIdHandler.create(i,h,imageId[i][h]);
        //    }
        //}

        //imageHandler = new ImageHandler(ctx);
        //List<Image> imagesDemo = imageHandler.getAllImage();
        //Integer[][] imageIdDemo = imageIdHandler.getAllImageId();
        //List<User>usersDemo = userHandler.getAllUser(imageIdi);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_login_registration, R.id.nav_my_gallery, R.id.nav_exit, R.id.nav_image_info, R.id.nav_user_gallery)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}