package org.romeo.jpgtopngconverter.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import org.romeo.jpgtopngconverter.ui.IImageGetter

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView, IImageGetter, MessageShower {
    fun setImageSrc(src: String)
    fun showDisposeDialog()
    fun hideDisposeDialog()
}