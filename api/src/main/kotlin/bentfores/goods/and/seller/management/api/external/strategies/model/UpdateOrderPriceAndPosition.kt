package com.adron.bot.manager.api.external.strategies.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.util.UUID

data class UpdateOrderPriceAndPosition(
  @JsonProperty("id")
  var id: UUID,

  @JsonProperty("botCurrentOpenPositionAmount")
  var botCurrentOpenPositionAmount: BigDecimal,

  @JsonProperty("botAvgPositionOpeningPrice")
  var botAvgPositionOpeningPrice: BigDecimal,

  @JsonProperty("transferableFees")
  var transferableFees: BigDecimal,
)
