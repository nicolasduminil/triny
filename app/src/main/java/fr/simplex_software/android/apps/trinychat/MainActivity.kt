package fr.simplex_software.android.apps.trinychat

import android.os.*
import androidx.appcompat.app.*
import com.google.android.material.appbar.*
import android.view.*;
import androidx.drawerlayout.widget.*
import androidx.navigation.*
import androidx.navigation.fragment.*
import androidx.navigation.ui.*
import com.google.android.material.navigation.*

class MainActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
    val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
    val builder = AppBarConfiguration.Builder(navController.graph)
    builder.setOpenableLayout(drawer)
    val appBarConfiguration = builder.build()
    toolbar.setupWithNavController(navController, appBarConfiguration)
    val navView = findViewById<NavigationView>(R.id.nav_view)
    NavigationUI.setupWithNavController(navView, navController)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean
  {
    menuInflater.inflate(R.menu.menu_toolbar, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean
  {
    val navController = findNavController(R.id.nav_host_fragment)
    return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
  }
}