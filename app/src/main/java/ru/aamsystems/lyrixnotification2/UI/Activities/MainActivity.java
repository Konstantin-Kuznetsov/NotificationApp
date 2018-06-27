package ru.aamsystems.lyrixnotification2.UI.Activities;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.appcompat.app.ActionBarDrawerToggle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import ru.aamsystems.lyrixnotification2.R;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavController navController; // Контроллер навигации по фрагментам
    private DrawerLayout drawer; // Корневой контейнер, содержащий выдвижное навигационное меню
    private NavigationView navigationView; // Навигационное меню

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализация контроллера навигации по фрагментам
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // инициализация компонентов активити
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Установить Toolbar.
        setSupportActionBar(toolbar);

        // Привязка навигационного контроллера к выдвижному меню, с синхронизацией
        // с ActionBar (меняет заголовок в соответствии с фрагментом, на который переходим
        navigationView.setNavigationItemSelectedListener(this);
        NavigationUI.setupActionBarWithNavController(this, navController, drawer);
    }

    // Обработка выбора одного из пунктов в выдвижном меню.
    // Переход происходит по указанному для пункта id в activity_main_drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        navigationView.setCheckedItem(item.getItemId()); // выделение выбранного пункта меню
        drawer.closeDrawer(GravityCompat.START); // закрываем меню после выбора
        return NavigationUI.onNavDestinationSelected(item, navController);
    }

    // Обработка нажатия стрелки "назад"
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(drawer, navController);
    }
}
