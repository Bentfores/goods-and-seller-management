package bentfores.goods.and.seller.management.server.service.v1

import bentfores.goods.and.seller.management.api.model.ProductStatusEnum
import bentfores.goods.and.seller.management.server.data.repository.ProductRepository
import bentfores.goods.and.seller.management.server.mapper.v1.ProductMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceV1(
  private val productRepository: ProductRepository,
  private val productMapper: ProductMapper
) {

  fun getProducts(status: ProductStatusEnum) =
    productMapper.mapToProductsInfoList(
      productRepository.findProductsByStatus(
        productMapper.mapToProductStatus(
          status
        )
      ),
    )

  fun getProduct(article: String) =
    productMapper.mapToProductInfo(
      productRepository.findProductByArticle(
        article
      )
    )

  @Transactional
  fun patchProducts(status: ProductStatusEnum, articles: List<String>) {
    productRepository.updateAllByStatus(
      productMapper.mapToProductStatus(status),
      articles
    )
  }

}

