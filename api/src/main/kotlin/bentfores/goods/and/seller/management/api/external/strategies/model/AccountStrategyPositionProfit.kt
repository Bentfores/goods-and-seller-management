package com.adron.bot.manager.api.external.strategies.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class AccountStrategyPositionProfit(
  @get:JsonProperty("strategyPositionRealizedPnl", required = true)
  val strategyPositionRealizedPnl: java.math.BigDecimal,
  @get:JsonProperty("strategyPositionUnrealizedPnl", required = true)
  val strategyPositionUnrealizedPnl: java.math.BigDecimal
) : Serializable
