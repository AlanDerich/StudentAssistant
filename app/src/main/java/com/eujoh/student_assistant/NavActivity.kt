package com.eujoh.student_assistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.eujoh.student_assistant.announcements.AnnouncementsActivity
import com.eujoh.student_assistant.contacts.ContactsActivity
import com.eujoh.student_assistant.curriculum.CurriculumActivity
import com.eujoh.student_assistant.home.HomeFragment
import com.eujoh.student_assistant.lost_and_found.LostFoundActivity
import com.eujoh.student_assistant.my_profile.MyProfileActivity
import com.eujoh.student_assistant.web.PortalWebActivity
import com.eujoh.student_assistant.web.SchoolWebActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_nav.*
import kotlinx.android.synthetic.main.app_bar_main.*

class NavActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "UOE STUDENT ASSISTANT"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            (R.string.open),
            (R.string.close)){

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId){
            R.id.home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.contacts -> {
                this.startActivity(Intent(this, ContactsActivity::class.java))
                return true
//                contactsFragment =
//                    ContactsFragment()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame_layout, contactsFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    .commit()
            }
            R.id.announcements -> {
                this.startActivity(Intent(this,AnnouncementsActivity::class.java))
                return true
            }
            R.id.lost_found -> {
                this.startActivity(Intent(this, LostFoundActivity::class.java))
                return true
            }
            R.id.curriculum -> {
                this.startActivity(Intent(this, CurriculumActivity::class.java))
                return true
            }
            R.id.my_profile -> {
                this.startActivity(Intent(this, MyProfileActivity::class.java))
                return true
            }
            R.id.portal -> {
                this.startActivity(Intent(this, PortalWebActivity::class.java))
                return true
            }
            R.id.website -> {
                this.startActivity(Intent(this, SchoolWebActivity::class.java))
                return true

            }
            R.id.disclaimer -> {

            }
            R.id.developer -> {

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{super.onBackPressed()}
    }
}
