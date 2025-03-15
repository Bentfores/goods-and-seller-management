package bentfores.goods.and.seller.management.server.service.v1

import bentfores.goods.and.seller.management.api.model.ProductStatusEnum
import bentfores.goods.and.seller.management.api.model.ProductsResponse
import bentfores.goods.and.seller.management.server.data.repository.ProductRepository
import bentfores.goods.and.seller.management.server.mapper.v1.ProductMapper
import org.springframework.stereotype.Service

@Service
class ProductServiceV1(
  private val productRepository: ProductRepository,
  private val productMapper: ProductMapper
) {

  fun getProducts(status: ProductStatusEnum): ProductsResponse {
    return productMapper.mapToProductsResponse(
      productRepository.findProductsByStatus(
        productMapper.mapToProductStatus(
          status
        )
      ),
    )
  }

}

