package org.romeo.jpgtopngconverter.ui

import android.app.AlertDialog
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import moxy.ktx.moxyPresenter
import org.romeo.jpgtopngconverter.R
import org.romeo.jpgtopngconverter.databinding.ActivityMainBinding
import org.romeo.jpgtopngconverter.model.MainImageWorker
import org.romeo.jpgtopngconverter.presenter.IMainPresenter
import org.romeo.jpgtopngconverter.presenter.MainPresenter
import org.romeo.jpgtopngconverter.view.MainView
import java.io.FileDescriptor


class MainActivity : ImageGetter(), MainView {
    override val presenter: IMainPresenter
            by moxyPresenter { MainPresenter() }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.mainImageView.setOnClickListener {
            presenter.onImagePressed()
        }

        binding.convertButton.setOnClickListener {
            presenter.onConvertImagePressed()
        }
    }

    override fun setImageSrc(src: String) {
        val uri = Uri.parse(src)
        val parcelFileDescriptor = contentResolver.openFileDescriptor(uri, "r")
        val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor

        val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)

        parcelFileDescriptor.close()

        binding.mainImageView.setImageBitmap(image)

        presenter.onImageWorkerReset(MainImageWorker(this, image))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private val dialog by lazy {
        AlertDialog.Builder(this)
            .setTitle(R.string.cancel_dialog)
            .setMessage(R.string.in_progress)
            .setNeutralButton(R.string.cancel) { _, _ ->
                presenter.onCancelLoadingPressed()
            }.create()
    }

    override fun showDisposeDialog() {
        dialog.show()
    }

    override fun hideDisposeDialog() {
        dialog.hide()
    }
}