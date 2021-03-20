package org.romeo.jpgtopngconverter.model

import android.content.Context
import android.graphics.Bitmap
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.FileOutputStream
import java.util.concurrent.TimeUnit

class MainImageWorker(
    private val context: Context,
    private val image: Bitmap
) : ImageWorker {

    override fun saveAsPng(filename: String): Completable =
        Completable.fromCallable {

            val out = context.openFileOutput(filename, Context.MODE_PRIVATE)

            image.compress(Bitmap.CompressFormat.PNG, 100, out)

            out.close()

        }.subscribeOn(Schedulers.io())
}