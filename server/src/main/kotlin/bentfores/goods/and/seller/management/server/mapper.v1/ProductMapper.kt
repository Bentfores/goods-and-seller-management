package bentfores.goods.and.seller.management.server.mapper.v1

import bentfores.goods.and.seller.management.api.model.ProductStatusEnum
import bentfores.goods.and.seller.management.api.model.ProductsInfo
import bentfores.goods.and.seller.management.api.model.ProductsResponse
import bentfores.goods.and.seller.management.server.data.entity.Product
import bentfores.goods.and.seller.management.server.data.entity.Product.ProductStatus
import org.springframework.stereotype.Component

@Component
class ProductMapper {

  fun mapToProductStatus(enum: ProductStatusEnum): ProductStatus {
    return when (enum) {
      ProductStatusEnum.NOT_PROCESSED -> ProductStatus.NOT_PROCESSED
      ProductStatusEnum.PROCESSED -> ProductStatus.PROCESSED
      ProductStatusEnum.IGNORED -> ProductStatus.IGNORED
    }
  }

  fun mapToProductStatusEnum(enum: ProductStatus): ProductStatusEnum {
    return when (enum) {
      ProductStatus.NOT_PROCESSED -> ProductStatusEnum.NOT_PROCESSED
      ProductStatus.PROCESSED -> ProductStatusEnum.PROCESSED
      ProductStatus.IGNORED -> ProductStatusEnum.IGNORED
    }
  }

  fun mapToProductInfoStatusEnum(enum: ProductStatus): ProductsInfo.Status {
    return when (enum) {
      ProductStatus.NOT_PROCESSED -> ProductsInfo.Status.NOT_PROCESSED
      ProductStatus.PROCESSED -> ProductsInfo.Status.PROCESSED
      ProductStatus.IGNORED -> ProductsInfo.Status.IGNORED
    }
  }

  fun mapToProductsResponse(products: List<Product>): ProductsResponse {
    return ProductsResponse(
      products = products.map { it.article }
    )
  }
}