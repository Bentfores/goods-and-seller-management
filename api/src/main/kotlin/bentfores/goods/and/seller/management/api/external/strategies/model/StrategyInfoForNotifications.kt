package com.adron.bot.manager.api.external.strategies.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.math.BigDecimal

data class StrategyInfoForNotifications(
  @get:JsonProperty("avgPositionOpeningPrice", required = true)
  val avgPositionRealizedPnl: BigDecimal,
  @get:JsonProperty("displayedId", required = true)
  val displayedId: String
) : Serializable
