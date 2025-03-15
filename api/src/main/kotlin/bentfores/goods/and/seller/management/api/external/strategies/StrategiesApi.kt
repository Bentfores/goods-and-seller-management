package com.adron.bot.manager.api.external.strategies

import com.adron.bot.manager.api.external.strategies.model.AccountStrategyPositionProfit
import com.adron.bot.manager.api.external.strategies.model.StrategyInfoForNotifications
import com.adron.bot.manager.api.external.strategies.model.UpdateOrderPriceAndPosition
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID
import org.springframework.web.bind.annotation.PathVariable

interface StrategiesApi {

  @RequestMapping(
    method = [RequestMethod.GET],
    value = ["/strategy/commonStrategyPositionPnl"],
    produces = ["application/json"]
  )
  fun strategyCommonStrategyPositionPnlByGet(
    @RequestParam(value = "profileId", required = true) profileId: UUID,
    @RequestParam(value = "accountId", required = true) accountId: UUID
  ): AccountStrategyPositionProfit

  @RequestMapping(
    method = [RequestMethod.PATCH],
    value = ["/strategy/updateOrderPrice"],
    produces = ["application/json"],
  )
  fun updateStrategyOrderPrice(
    @RequestBody requestBody: UpdateOrderPriceAndPosition,
  )

  @RequestMapping(
    method = [RequestMethod.GET],
    value = ["/strategy/strategyInfoForNotifications/{id}"],
    produces = ["application/json"]
  )
  fun strategyInfoForNotificationsByGet(@PathVariable id: UUID): StrategyInfoForNotifications
}