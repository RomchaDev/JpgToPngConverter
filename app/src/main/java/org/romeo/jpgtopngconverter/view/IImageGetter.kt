package org.romeo.jpgtopngconverter.view

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface IImageGetter {
    fun requestImage()
}