package com.adron.bot.manager.api.exception

enum class ErrorCode(
  val status: Int,
  val message: String,
) {
  BMNG_00(400, "Validation Error"),
  BMNG_01(400, "Bot not found"),
  BMNG_02(400, "None of query params were passed for searching");

  companion object {
    const val MIN_NOTIONAL = "minNotional"
    const val BOT_ID = "botId"
    const val STATUS = "status"
    const val PROFILE_ID = "profileId"
    const val MAX_PROFILE_BOTS = "maxProfileBots"
    const val ORDER_ID = "orderId"
    const val ORDER_TYPE = "orderType"
    const val SORT_KEYS = "sortKeys"
  }
}