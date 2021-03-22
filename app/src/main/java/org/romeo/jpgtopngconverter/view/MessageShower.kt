package org.romeo.jpgtopngconverter.view

import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface MessageShower {
    fun showMessage(message: String)
}