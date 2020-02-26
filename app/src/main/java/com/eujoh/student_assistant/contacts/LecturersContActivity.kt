package com.eujoh.student_assistant.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eujoh.student_assistant.R
import kotlinx.android.synthetic.main.activity_lecturers_cont.*

class LecturersContActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturers_cont)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentFullTimeLec(), "FULL-TIME")
        adapter.addFragment(FragmentPartTimeLec(), "PART-TIME")
        adapter.addFragment(FragmentFavLec(), "")
        lecturers_viewPager.adapter = adapter
        lecturers_tabLayout.setupWithViewPager(lecturers_viewPager)

        lecturers_tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_fav)
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}
