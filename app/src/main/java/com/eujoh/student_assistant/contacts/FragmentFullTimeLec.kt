package com.eujoh.student_assistant.contacts

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eujoh.student_assistant.R

class FragmentFullTimeLec : Fragment(), LecStudeAdapter.OnItemClickListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val layout = inflater.inflate(R.layout.full_time_lec_fragment, container, false)

        val items = ArrayList<LecStudeItem>()

        items.add(LecStudeItem("PROF. J.K BITOK", "0722668933/0727830204", "0722668933", "", R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. VICTOR K. KIMELI", "0727830204", "0727830204", "", R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. BETTY KORIR", "0727830204/0727830204", "0727830204", "0727830204",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. ARGWINGS OTIENO", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. JULIUS SHICHIKHA", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. ERICK ROTICH", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. DENNIS KINGANGI", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("MR. JOHN ROTICH", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("MR. CHARLES SAMBULI", "0739440628/0727830204", "0739440628", "0727830204",R.drawable.contact_icon_one))

        val recycler = layout.findViewById<RecyclerView>(R.id.full_time_lec_recyclerview)

        val adapter = LecStudeAdapter(items, this, context!!)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

        return layout
    }

    override fun onItemClick(item: LecStudeItem, position: Int) {
        val dialog = AlertDialog.Builder(context!!)
        val dialogView = layoutInflater.inflate(R.layout.lec_stude_dialog, null)
        val ContactName = dialogView.findViewById<TextView>(R.id.cont_name_lec_stude_dialog)
        val Phone1 = dialogView.findViewById<TextView>(R.id.phone1_lec_stude_dialog)
        val Phone2 = dialogView.findViewById<TextView>(R.id.phone2_lec_stude_dialog)
        val Call1 = dialogView.findViewById<ImageView>(R.id.line1_lec_stude_call)
        val Call2 = dialogView.findViewById<ImageView>(R.id.line2_lec_stude_call)
        val Sms1 = dialogView.findViewById<ImageView>(R.id.line1_lec_stude_sms)
        val Sms2 = dialogView.findViewById<ImageView>(R.id.line2_lec_stude_sms)
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.show()

    }
}