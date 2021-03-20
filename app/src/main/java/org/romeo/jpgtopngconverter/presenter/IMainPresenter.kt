package org.romeo.jpgtopngconverter.presenter

import org.romeo.jpgtopngconverter.model.ImageWorker

interface IMainPresenter : ImageListener {

    fun onImagePressed()
    fun onConvertImagePressed()
    fun onCancelLoadingPressed()
    fun onLoadingFinished()
    fun onImageWorkerReset(img: ImageWorker)
}