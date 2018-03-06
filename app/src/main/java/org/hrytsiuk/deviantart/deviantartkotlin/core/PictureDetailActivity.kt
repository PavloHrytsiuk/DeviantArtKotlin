package org.hrytsiuk.deviantart.deviantartkotlin.core

import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture_detail.*
import org.hrytsiuk.deviantart.deviantartkotlin.R
import org.hrytsiuk.deviantart.deviantartkotlin.base.BaseActivity
import org.hrytsiuk.deviantart.deviantartkotlin.core.model.Picture

class PictureDetailActivity : BaseActivity() {

    companion object {
        const val CLICKED_PICTURE: String = "Pictures list"
    }

    private lateinit var picture: Picture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detail)
        val bundle: Bundle = intent.extras
        picture = bundle.getParcelable(CLICKED_PICTURE)
        initView()
    }

    private fun initView() {
        Picasso.with(this).load(picture.content.src).into(pictureDetailImage)
        pictureDetailTitle.text = picture.title
        pictureDetailAuthor.text = picture.author.name
        Picasso.with(this).load(picture.author.usericon).into(pictureDetailAuthorIcon)

        val buf = StringBuilder()
        buf.append("Comments: ")
        buf.append(picture.stats.comments)
        buf.append("\n")
        buf.append("Favourites: ")
        buf.append(picture.stats.favourites)
        pictureDetailStats.text = buf
    }
}
