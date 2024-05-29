package net.asgeri.atl29may.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("load_url")
fun loadImage(imageView: ImageView, url: String) {
    imageView.loadUrl(url)
}