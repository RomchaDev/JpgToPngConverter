package org.romeo.jpgtopngconverter.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MessageShower {
    fun showMessage(message: String)
}