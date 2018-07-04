package ru.aamsystems.lyrixnotification2.view.ui.activities;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.appcompat.app.ActionBarDrawerToggle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import ru.aamsystems.lyrixnotification2.R;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavController navController; // Контроллер навигации по фрагментам
    private DrawerLayout drawer; // Корневой контейнер, содержащий выдвижное навигационное меню
    private SwitchCompat serviceSwitcher;
    private MenuItem serviceSwitcherItem; // Пункт меню, содержащий serviceSwitcher

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализация контроллера навигации по фрагментам
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // инициализация компонентов активити
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        // Навигационное меню
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Установка Toolbar
        setSupportActionBar(toolbar);

        // Инициализация переключателя службы. Обработка нажатий в onNavigationItemSelected()
        serviceSwitcherItem = navigationView.getMenu().findItem(R.id.nav_switch_service);
        serviceSwitcher = serviceSwitcherItem.getActionView().findViewById(R.id.switcher);

        serviceSwitcher
                .setOnCheckedChangeListener((compoundButton, b)
                -> Snackbar.make(compoundButton, (serviceSwitcher.isChecked())
                        ? "Служба сообщений Lyrix включена." : "Служба сообщений Lyrix отключена.",
                Snackbar.LENGTH_LONG).setAction("Action", null).show());

        // Привязка навигационного контроллера к выдвижному меню, с синхронизацией
        // с ActionBar (меняет заголовок в соответствии с фрагментом, на который переходим
        navigationView.setNavigationItemSelectedListener(this);
        NavigationUI.setupActionBarWithNavController(this, navController, drawer);
    }

    // Обработка выбора одного из пунктов в выдвижном меню.
    // Переход происходит по указанному для пункта id в activity_main_drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // если выбран пункт меню "Служба сообщений Lyrix"
        if (item.equals(serviceSwitcherItem)) {
            // https://issuetracker.google.com/issues/37074309 перещелкивается без анимации
            //serviceSwitcher.setChecked(!serviceSwitcher.isChecked());
            return false;
        }

        drawer.closeDrawer(GravityCompat.START); // закрываем меню после выбора
        return NavigationUI.onNavDestinationSelected(item, navController);
    }

    // Обработка нажатия стрелки "назад".
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(drawer, navController);
    }

}
