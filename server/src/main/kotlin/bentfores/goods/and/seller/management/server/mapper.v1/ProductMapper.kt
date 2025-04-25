package bentfores.goods.and.seller.management.server.mapper.v1

import bentfores.goods.and.seller.management.api.model.ProductStatusEnum
import bentfores.goods.and.seller.management.api.model.ProductsInfo
import bentfores.goods.and.seller.management.server.data.entity.Product
import bentfores.goods.and.seller.management.server.data.entity.Product.ProductStatus
import org.springframework.stereotype.Component

@Component
class ProductMapper {

  fun mapToProductStatus(enum: ProductStatusEnum) =
    when (enum) {
      ProductStatusEnum.NOT_PROCESSED -> ProductStatus.NOT_PROCESSED
      ProductStatusEnum.PROCESSED -> ProductStatus.PROCESSED
      ProductStatusEnum.IGNORED -> ProductStatus.IGNORED
    }

  fun mapToProductStatusEnum(enum: ProductStatus) =
    when (enum) {
      ProductStatus.NOT_PROCESSED -> ProductStatusEnum.NOT_PROCESSED
      ProductStatus.PROCESSED -> ProductStatusEnum.PROCESSED
      ProductStatus.IGNORED -> ProductStatusEnum.IGNORED

    }

  fun mapToProductsInfoList(products: List<Product>) =
    products.map { mapToProductInfo(it) }

  fun mapToProductInfo(product: Product) =
    ProductsInfo(
      article = product.article,
      imageUrl = product.imageUrl,
      name = product.productName,
      profitPlace = product.profitPlace
    )

}