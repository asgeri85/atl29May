package net.asgeri.atl29may.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import net.asgeri.atl29may.R

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).into(this);
}