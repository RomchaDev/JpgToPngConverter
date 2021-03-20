package org.romeo.jpgtopngconverter.ui

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IImageGetter {
    fun requestImage()
}